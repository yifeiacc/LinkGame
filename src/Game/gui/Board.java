package Game.gui;

import Game.Piece;
import Game.LinkGame;
import Game.Placement;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Board extends Application {
    private static final int BOARD_WIDTH = 933;
    private static final int BOARD_HEIGHT = 700;

    private static final int SQUARE_SIZE = 100;
    private static final int PIECE_IMAGE_SIZE = 3 * SQUARE_SIZE;
    private static final double ROW_HEIGHT = SQUARE_SIZE * 0.8660254; // 60 degrees

    private static final Paint PegColor = Color.gray(211.0 / 255.0);
    private static final double RADIUS = 30.0;
    private static final int LeftMargin = (BOARD_WIDTH - (5 * SQUARE_SIZE + SQUARE_SIZE / 2 + 2 * (int) RADIUS)) / 2;
    //    private static final int TopMargin = (int) (BOARD_HEIGHT - (ROW_HEIGHT * 3 + RADIUS * 2)) / 2;
    private static final int TopMargin = (int) (BOARD_HEIGHT - (ROW_HEIGHT * 3 + RADIUS * 2)) / 5;
    private static final int homeSlotTopMargin = (int) (TopMargin * 2 + 3 * ROW_HEIGHT + SQUARE_SIZE);

    private static final int nPieces = 12;
    private static final int nPegs = 24;

    private static final int[][] pegCenters = new int[nPegs][2];
    private static final int[][] homeCenters = new int[nPieces][2];
    private static final boolean[] homeAvailable = new boolean[nPieces];

    private static final Group gameRoot = new Group();
    private static final Group initSlot = new Group();
    private static final Group controls = new Group();
    private static final Placement currentPlacement = new Placement();
    private static final Group currentPlacementGroup = new Group();
    private static final Group hintGroup = new Group();

    private static final FXPiece[] pieces = new FXPiece[nPieces];
    private static final FXPiece[] hintPieces = new FXPiece[nPieces];
    private static String IMG_PATH = "comp1110/ass2/gui/assets/%s.png";

    private static final int HINT_THRESHOLD = 3;


    private static final Text win = new Text("Well done!");
    static void showWin() {
        win.toFront();
        win.setOpacity(1);
    }
    static void hindWin() {
        win.toBack();
        win.setOpacity(0);
    }

    // initialize homeAvailable, pegCenters and homeCenters
    static {
        for (int i = 0; i < nPieces; i++) {
            homeAvailable[i] = true;
        }

        // line 0 and 2
        for (int i = 0; i < 6; i++) {
            int centerX = LeftMargin + SQUARE_SIZE * i + (int) RADIUS,
                    centerY = TopMargin + (int) RADIUS;
            pegCenters[i][0] = centerX;
            pegCenters[i][1] = centerY;
            pegCenters[i + 12][0] = centerX;
            pegCenters[i + 12][1] = (int) (centerY + 2 * ROW_HEIGHT);
        }
        // line 1 and 3
        for (int i = 0; i < 6; i++) {
            int centerX = (int) (LeftMargin + SQUARE_SIZE * i + RADIUS + SQUARE_SIZE / 2),
                    centerY = (int) (TopMargin + RADIUS + ROW_HEIGHT);
            pegCenters[i + 6][0] = centerX;
            pegCenters[i + 6][1] = centerY;
            pegCenters[i + 18][0] = centerX;
            pegCenters[i + 18][1] = (int) (centerY + 2 * ROW_HEIGHT);
        }

        int _slotsHeight = (BOARD_HEIGHT - homeSlotTopMargin) / 2;
        int _slotWidth = BOARD_WIDTH / 6;
        int _leftMargin = _slotWidth / 2;
        for (int i = 0; i < nPieces; i++) {
            homeCenters[i][0] = _leftMargin + (i % 6) * _slotWidth;
            homeCenters[i][1] = homeSlotTopMargin + (i / 6) * _slotsHeight;
        }
    }


    /**
     * Singleton thread
     * <p>
     * Use separate thread to calculate hints so that there won't be obvious delay
     * when user is placing a piece.
     * <p>
     * Hints will be updated every time the placement on the board is changed
     * or the user press the slash key to get a hint.
     * <p>
     * Only one thread will be create to get hints
     * The constructor is claimed as private to make sure there is only one thread
     * <p>
     * The reason for using singleton is to prevent the case in which the user
     * is pressing slash key continuously and lots of threads are created.
     * <p>
     * This class will provide a static methods: getSolution
     * This method will notify the inner thread to start computing task
     * or it will interrupt the current computing task and start another task
     * See details below
     */
    static class ThreadedHint {
        /**
         * This class will do computing in a separate thread
         * ThreadedHint will maintain one (and only one) reference to
         * a RunningThread instance
         */
        private static class TaskThread extends Thread {
            private String startPoint = null;
            // solutions will also cache results found
            private String[] solutions = null;

            private TaskThread(String startPoint) {
                this.startPoint = startPoint;
            }

            @Override
            public void run() {
                this.solutions = LinkGame.getSolutions(this.startPoint, true);
            }

            private String getSolution() {
                if (super.isAlive()) {
                    // the thread is still running
                    return null;
                } else {
                    if (this.solutions == null || this.solutions.length == 0) {
                        // thread finished but no solutions found
                        return null;
                    } else {
                        // ... or find a solution
                        return this.solutions[0];
                    }
                }
            }
        }

        private static TaskThread hintThread = null;
        // keep current task, use this to determine whether to stop current task
        // and to start a new task or not
        private static String currentTask = null;

        // private constructor to prevent a instance being created
        private ThreadedHint() {
        }

        /**
         * The only method can be called
         * First the method will check whether the new task (placement) is same
         * as last task. If so, it will return saved result for current task
         * (note that this result could be null if no solutions were found or the
         * thread is still running) otherwise it will stop current task and start
         * a new task
         *
         * @param placement: the start point
         * @return a string
         * null if no solutions or still running
         * or one solution found for the given starting point
         */
        public static String getSolution(String placement) {
            if (placement.equals(ThreadedHint.currentTask) || ThreadedHint.currentTask == null) {
                if (ThreadedHint.hintThread == null) {
                    // in this case, the thread has not been created yet
                    // we should first create a thread and start the task
                    // this should be reached only once during the whole execution
                    // of the program
                    ThreadedHint.currentTask = placement;
                    ThreadedHint.hintThread = new TaskThread(ThreadedHint.currentTask);
                    // set daemon to prevent possible blocks on exit
                    // block may happen if user exit the program but the thread
                    // is still running
                    ThreadedHint.hintThread.setDaemon(true);
                    ThreadedHint.hintThread.start();
                    return ThreadedHint.hintThread.getSolution();
                } else {
                    // or there already exists a task thread
                    // just call getSolution method of TaskThread instance
                    // a solution will be return iff. there exist a solution
                    // and the task thread has finished running
                    return ThreadedHint.hintThread.getSolution();
                }
            } else {
                // or a new task comes
                // first stop old task
                ThreadedHint.hintThread.interrupt();
                // then create a new thread and update current task
                ThreadedHint.currentTask = placement;
                ThreadedHint.hintThread = new TaskThread(ThreadedHint.currentTask);
                // set daemon to prevent possible blocks on exit
                ThreadedHint.hintThread.setDaemon(true);
                ThreadedHint.hintThread.start();
                return ThreadedHint.hintThread.getSolution();
            }
        }
    }

    private static void updateHints() {
        if (currentPlacement.isCompleted()) {
            showWin();
        }
        if (currentPlacement.size() < HINT_THRESHOLD) return;
        gameRoot.getChildren().removeAll(hintGroup.getChildren());
        gameRoot.getChildren().remove(hintGroup);
        hintGroup.getChildren().clear();
//        String[] hintStrings = LinkGame.getSolutions(currentPlacement.toString(), true);
//        if (hintStrings == null || hintStrings.length == 0) {
//            hints = null;
//            return;
//        }
//        String hintString = hintStrings[0];
        String hintString = ThreadedHint.getSolution(currentPlacement.toString());
        if (hintString == null || hintString.length() == 0) {
            return;
        }
//        System.out.println(hintString);
        for (int i = 0; i < nPieces; i++) {
            hintPieces[i] = new FXPiece(hintString.substring(i * 3 + 1, i * 3 + 3));
            hintPieces[i].placeAt(hintString.charAt(i * 3) - 'A');
            hintPieces[i].setOpacity(.3);
        }
        hintGroup.getChildren().addAll(hintPieces);
        hintGroup.setVisible(false);
        gameRoot.getChildren().add(hintGroup);
    }

    private static void showHints() {
        hintGroup.setVisible(true);
    }

    private static void hideHints() {
        hintGroup.setVisible(false);
    }

    private static void drawPegs() {
        double centerX, centerY;
        Circle circle;
        // line 0 and 2
        for (int i = 0; i < 6; i++) {
            centerX = LeftMargin + SQUARE_SIZE * i + RADIUS;
            centerY = TopMargin + RADIUS;
            circle = new Circle(centerX, centerY, RADIUS);
            circle.setFill(PegColor);
            gameRoot.getChildren().add(circle);
            circle = new Circle(centerX, centerY + 2 * ROW_HEIGHT, RADIUS);
            circle.setFill(PegColor);
            gameRoot.getChildren().add(circle);
        }
        // line 1 and 3
        for (int i = 0; i < 6; i++) {
            centerX = LeftMargin + SQUARE_SIZE * i + RADIUS + SQUARE_SIZE / 2;
            centerY = TopMargin + RADIUS + ROW_HEIGHT;
            circle = new Circle(centerX, centerY, RADIUS);
            circle.setFill(PegColor);
            gameRoot.getChildren().add(circle);
            circle = new Circle(centerX, centerY + 2 * ROW_HEIGHT, RADIUS);
            circle.setFill(PegColor);
            gameRoot.getChildren().add(circle);
        }
    }

    static Slider difficulty;
    static Button restart;
    private static void makeController() {
        HBox controllers = new HBox(3);
        controllers.setSpacing(30);
        controllers.setFillHeight(true);
        difficulty = new Slider(0, 7, 3);
        difficulty.setShowTickLabels(true);
        difficulty.setShowTickMarks(true);
        difficulty.setMajorTickUnit(1);
        difficulty.setMinorTickCount(0);
        difficulty.setSnapToTicks(true);

        restart = new Button("Restart");
        restart.setBorder(Border.EMPTY);

        Label label = new Label("Difficulty: ");
        controllers.getChildren().addAll(label, difficulty, restart);
        controllers.setAlignment(Pos.CENTER);
        controllers.setLayoutX(BOARD_WIDTH / 3);
        controllers.setLayoutY(TopMargin / 4);
        controls.getChildren().add(controllers);


        win.setFill(Color.BLACK);
        win.setFont(Font.font("Arial", 80));
        win.setLayoutX(3.1*SQUARE_SIZE);
        win.setLayoutY(0.9*SQUARE_SIZE);
        win.setTextAlignment(TextAlignment.CENTER);
        gameRoot.getChildren().add(win);
    }

    private static void newGame() {
        currentPlacement.clear();
        for (int i = 0; i < homeAvailable.length; i++) {
            homeAvailable[i] = false;
        }
        gameRoot.getChildren().clear();
        initSlot.getChildren().clear();
        currentPlacementGroup.getChildren().clear();
        hintGroup.getChildren().clear();
        for (int i = 0; i < nPieces; i++) {
            pieces[i] = new FXPiece(String.format("%c%c", (char) (i + 'A'), 'A'));
        }
        for (FXPiece piece : pieces) {
            piece.placeAt(-(piece._piece.getPieceID().charAt(0) - 'A' + 1));
            gameRoot.getChildren().add(piece);
        }
        drawPegs();
        hindWin();
        gameRoot.getChildren().add(controls);
        gameRoot.getChildren().add(win);
        String starting = LinkGame.getStartingPoint((int) difficulty.getValue());
        for (int i = 0; i < starting.length(); i += 3) {
            putPieceOnboard(starting.substring(i, i + 3));
        }
//        putPieceOnboard("BAA");
//        putPieceOnboard("HBA");
//        putPieceOnboard("TCJ");
        if (currentPlacement.size() >= HINT_THRESHOLD) {
            updateHints();
        }
    }

    // resolve threading synchronize issue
    private static void updatePlacement() {
        synchronized (currentPlacement) {
            currentPlacement.clear();
            for (FXPiece fxPiece : pieces) {
                synchronized (fxPiece) {
                    if (fxPiece._isOnBoard) {
                        currentPlacement.placePiece(fxPiece._piece, fxPiece._position);
                    }
                }
            }
        }
    }

    static class FXPiece extends ImageView {
        private Piece _piece;
        private boolean _isOnBoard;
        // _position keeps the last valid position of a piece
        private int _position;  // 0 ~ 23: pegs;    -1 ~ -12: home slots
        private int _x, _y;     // coordinate of center of the piece
        private static int _img_size = PIECE_IMAGE_SIZE;
        private boolean _isDrag = false;

        // rotate _piece (will create a new Piece instance)
        // will not check valid or not
        private Piece rotate(boolean counterClockwise) {
            return Piece.getRotated(this._piece, counterClockwise);
        }

        private Piece flip() {
            return Piece.getFlipped(this._piece);
        }

        // return 0 ~ 23, will *NOT* check if the placement is valid
        private int findNearestPeg() {
            int p = Integer.MAX_VALUE;
            int minDistance = Integer.MAX_VALUE;
            for (int i = 0; i < nPegs; i++) {
                int xCenter = pegCenters[i][0];
                int yCenter = pegCenters[i][1];
                int distance = (xCenter - _x) * (xCenter - _x)
                        + (yCenter - _y) * (yCenter - _y);
                if (distance < minDistance) {
                    p = i;
                    minDistance = distance;
                }
            }
            return p;
        }

        // return -1 ~ -12, will check if the slot is available
        private int findNearestHomeSlot() {
            int p = -Integer.MAX_VALUE;
            int minDistance = Integer.MAX_VALUE;
            for (int i = 0; i < nPieces; i++) {
                if (!homeAvailable[i]) continue;
                int xCenter = homeCenters[i][0];
                int yCenter = homeCenters[i][1];
                int distance = (xCenter - _x) * (xCenter - _x)
                        + (yCenter - _y) * (yCenter - _y);
                if (distance < minDistance) {
                    p = -(i + 1);
                    minDistance = distance;
                }
            }
            return p;
        }

        // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        //  This method will not check if the place is valid
        // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        private void placeAt(int position) {
            if (position < 0) {
                int slotOrdinal = -(position + 1);
                // place to first off-board slot
                _x = homeCenters[slotOrdinal][0] - _img_size / 2;
                _y = homeCenters[slotOrdinal][1] - _img_size / 2;
                setX(_x);
                setY(_y);
                if (!_isOnBoard && !_isDrag) {
                    super.setScaleX(.5);
                    super.setScaleY(getScaleY() / Math.abs(getScaleY()) * .5);
                }
                homeAvailable[slotOrdinal] = false;
                _position = position;
            } else {
                // place to peg #position
                _x = pegCenters[position][0] - _img_size / 2;
                _y = pegCenters[position][1] - _img_size / 2;
                setX(_x);
                setY(_y);
                if (_position < 0) {
                    homeAvailable[-(_position + 1)] = true;
                }
                super.setScaleX(1.);
                super.setScaleY(getScaleY() / Math.abs(getScaleY()));
                _position = position;
            }
        }

        private void update(double x, double y) {
            _x = (int) x;
            _y = (int) y;
            this.setX(_x - _img_size / 2);
            this.setY(_y - _img_size / 2);
        }

        FXPiece(String pieceString) {
            super.setImage(new Image(String.format(IMG_PATH, pieceString.charAt(0))));
            int orientation = pieceString.charAt(1) - 'A';
            if (orientation >= 6) {
                orientation -= 6;
                super.setScaleY(-1);
                super.setRotate(60. * orientation);
            } else {
                super.setRotate(60. * orientation);
            }

            this._piece = Piece.get(pieceString);
            this._isDrag = false;
            this._isOnBoard = false;
            this.placeAt(-(pieceString.charAt(0) - 'A' + 1));

            // scale up by 1.1
            setOnMouseDragged(event -> {
                _isDrag = true;
                _isOnBoard = false;
                if (_position < 0) {
                    // free the slot it was occupying
                    homeAvailable[-(_position + 1)] = true;
                } else {
                    // remove from board
                    currentPlacement.removePiece(_piece);
                }
                toFront();
                update(event.getSceneX(), event.getSceneY());
                super.setScaleX(1.1);
                super.setScaleY(getScaleY() / Math.abs(getScaleY()) * 1.1);
            });

            // scale back to 1
            setOnMouseReleased(event -> {
                if (_isDrag) {
                    update(event.getSceneX(), event.getSceneY());
                    int nearestPeg = findNearestPeg();
                    if (currentPlacement.placePiece(_piece, nearestPeg)) {
                        _isDrag = false;
                        _isOnBoard = true;
                        if (currentPlacement.size() >= HINT_THRESHOLD) {
                            updateHints();
                        }
                        placeAt(nearestPeg);
                    } else {
                        _isDrag = false;
                        _isOnBoard = false;
                        placeAt(findNearestHomeSlot());
                    }
                    _isDrag = false;
                }
            });

            // rotate
            setOnScroll(event -> {
                // setup a threshold
                double threshold = .5;
                if (event.getDeltaY() > threshold || event.getDeltaY() < -threshold) {
                    if (event.getDeltaY() > 0) {
                        // click left button to rotate (clockwise)
                        if (_isOnBoard) {
                            if (currentPlacement.rotatePiece(_piece, false)) {
                                _piece = rotate(false);
                                if (currentPlacement.size() >= HINT_THRESHOLD) {
                                    updateHints();
                                }
                                setRotate((getRotate() + 60) % 360);
                            }
                        } else {
                            _piece = rotate(false);
                            setRotate((getRotate() + 60) % 360);

                        }
                    } else {
                        // counter-clockwise
                        if (_isOnBoard) {
                            if (currentPlacement.rotatePiece(_piece, true)) {
                                _piece = rotate(true);
                                if (currentPlacement.size() >= HINT_THRESHOLD) {
                                    updateHints();
                                }
                                setRotate((getRotate() - 60) % 360);
                            }
                        } else {
                            _piece = rotate(true);
                            setRotate((getRotate() - 60) % 360);

                        }
                    }
                }
            });

            setOnMouseClicked(event -> {
                if (event.getClickCount() == 1) {
                    // right click to reset to home
                    if (event.getButton() == MouseButton.SECONDARY) {
                        if (currentPlacement.removePiece(this._piece)) {
                            int homeSlot = findNearestHomeSlot();
                            if (homeSlot >= -nPieces) {
                                // free the slot it currently occupies
                                if (_position < 0) {
                                    homeAvailable[-(_position + 1)] = true;
                                }
                                _isDrag = false;
                                _isOnBoard = false;
                                placeAt(homeSlot);
                                if (currentPlacement.size() >= HINT_THRESHOLD) {
                                    updateHints();
                                }
                                System.out.println("reset to home: " + this._piece);
                            }
                        }
                    }
                } else if (event.getClickCount() == 2) {
                    // double left click -- flip
                    if (event.getButton() == MouseButton.PRIMARY) {
                        if (_isOnBoard) {
                            // check if flip is valid
                            if (currentPlacement.flipPiece(_piece)) {
                                super.setRotate(-super.getRotate());
                                super.setScaleY(-super.getScaleY());
                                _piece = flip();
                                if (currentPlacement.size() >= HINT_THRESHOLD) {
                                    updateHints();
                                }
                            }
                        } else {
                            super.setRotate(-super.getRotate());
                            super.setScaleY(-super.getScaleY());
                            _piece = flip();
                        }
                    }
                }
            });

        }

    }

    private static void Piecerot(FXPiece p) {
        p._piece = p.rotate(false);
        p.setRotate((p.getRotate() + 60) % 360);
    }

    private static void Piecefilp(FXPiece p) {
        p.setRotate(-p.getRotate());
        p.setScaleY(-p.getScaleY());
        p._piece = p.flip();
    }

    public static void putPieceOnboard(String p) {
        int pos = p.charAt(0) - 'A';
        int pie = p.charAt(1) - 'A';
        int ori = p.charAt(2) - 'A';
        if (ori < 6) {
            int num = ori;
            for (int i = 0; i < num; i++) {
                Piecerot(pieces[pie]);
            }
        } else {
            int num = ori - 6;
            Piecefilp(pieces[pie]);
            for (int i = 0; i < num; i++) {
                Piecerot(pieces[pie]);
            }
        }
        pieces[pie].placeAt(pos);
        pieces[pie]._isOnBoard = true;

        currentPlacement.placePiece(pieces[pie]._piece, pos);
        pieces[pie].toFront();
    }


    // FIXME Task 8: Implement a basic playable Link Game in JavaFX that only allows pieces to be placed in valid places

    // FIXME Task 9: Implement starting placements

    // FIXME Task 11: Implement hints

    // FIXME Task 12: Generate interesting starting placements

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene gameScene = new Scene(this.gameRoot, BOARD_WIDTH, BOARD_HEIGHT);
        primaryStage.setTitle("IQ-link");
        makeController();
        newGame();
        gameScene.setOnKeyReleased(event -> {
            switch (event.getCode()) {
                case R: {
                    newGame();
                    break;
                }
                case SLASH: {
                    hideHints();
//                    System.out.println("hind hints");
                    break;
                }
            }
        });
        gameScene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case SLASH: {
                    if (currentPlacement.size() < HINT_THRESHOLD) break;
                    updateHints();
                    showHints();
//                    System.out.println("show hints");
                    break;
                }
                case Q: {
                    primaryStage.close();
                    System.exit(0);
                    break;
                }
            }
        });
        restart.setOnMouseReleased(event -> {
            newGame();
        });
        gameScene.setOnMouseClicked(event -> {
            hindWin();
        });
        primaryStage.setScene(gameScene);
        primaryStage.show();
    }
}
