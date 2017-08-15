package Game.gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * A very simple viewer for piece placements in the link game.
 *
 * NOTE: This class is separate from your main game class.  This
 * class does not play a game, it just illustrates various piece
 * placements.
 */
public class Viewer extends Application {

    /* board layout */
    private static final int SQUARE_SIZE = 100;
    private static final int PIECE_IMAGE_SIZE = 3*SQUARE_SIZE;
    private static final double ROW_HEIGHT = SQUARE_SIZE * 0.8660254; // 60 degrees
    private static final int VIEWER_WIDTH = 750;
    private static final int VIEWER_HEIGHT = 500;

    private static final Paint PegColor = Color.gray(211.0 / 255.0);
    private static final double RADIUS = 30.0;
    private static final int LeftMargin = (VIEWER_WIDTH - (5 * SQUARE_SIZE + SQUARE_SIZE / 2 + 2 * (int) RADIUS)) / 2;
    private static final int TopMargin = SQUARE_SIZE / 2;

    private static final String URI_BASE = "assets/";

    private final Group root = new Group();
    private final Group controls = new Group();
    TextField textField;

    private final Group placementGroup = new Group();


    /**
     * Draw a placement in the window, removing any previously drawn one
     *
     * @param placement  A valid placement string
     */
    void makePlacement(String placement) {
        // Task 5: implement the simple placement viewer
        this.placementGroup.getChildren().remove(0, this.placementGroup.getChildren().size());
        this.root.getChildren().remove(this.placementGroup);
        for (int i = 0; i < placement.length(); i += 3) {
            ImageView piece = this.placePiece(placement.substring(i, i + 3));
            this.placementGroup.getChildren().add(piece);
        }
        this.root.getChildren().addAll(this.placementGroup);

    }
    /**
     * place a certain piece
     * (0, 0) - x
     * |
     * y
     *
     * @param placement
     * @return ImageView generated
     */
    private ImageView placePiece(String placement) {
        int origin = placement.charAt(0) - 'A';
        char pieceName = placement.charAt(1);
        int rotate = placement.charAt(2) - 'A';
        String IMG_PATH = "comp1110/ass2/gui/" + this.URI_BASE + pieceName + ".png";
        Image pieceImg = new Image(IMG_PATH);
        ImageView pieceImgView = new ImageView();
        pieceImgView.setImage(pieceImg);
        // find coordinate of left-top point of the image
        // first find coordinate of the center
        int row = origin / 6, col = origin % 6;
        double Y = this.TopMargin + this.RADIUS + row * this.ROW_HEIGHT;
        double X = this.LeftMargin + this.RADIUS + col * this.SQUARE_SIZE;
        // for the odd lines, add an extra offset to X
        // line number starts at 0
        if (row % 2 != 0) {
            X += this.SQUARE_SIZE / 2;
        }
        // then the top-left point
        X -= this.PIECE_IMAGE_SIZE / 2;
        Y -= this.PIECE_IMAGE_SIZE / 2;
        // set coordinate for image
        pieceImgView.setX(X);
        pieceImgView.setY(Y);
        // rotate by degree, clockwise
        pieceImgView.setRotate(60 * rotate);
        // need flip?
        if (rotate >= 6) {
            pieceImgView.setScaleY(-1);
        }
        return pieceImgView;
    }

    // Draw pegs
    private void drawPegs() {
        // radius is 60 pixels. counted...
        double radius = this.RADIUS;
        double centerX, centerY;
        Circle circle;
        // create a new group
        Group pegs = new Group();
        // draw the first and the third line
        for (int i = 0; i < 6; i++) {
            centerX = this.LeftMargin + this.SQUARE_SIZE * i + radius;
            centerY = this.TopMargin + radius;
            circle = new Circle(centerX, centerY, radius);
            circle.setFill(this.PegColor);
            pegs.getChildren().add(circle);
            circle = new Circle(centerX, centerY + 2 * this.ROW_HEIGHT, radius);
            circle.setFill(this.PegColor);
            pegs.getChildren().add(circle);
        }
        // draw the second and the forth line
        for (int i = 0; i < 6; i++) {
            centerX = this.LeftMargin + this.SQUARE_SIZE * i + radius + this.SQUARE_SIZE / 2;
            centerY = this.TopMargin + radius + this.ROW_HEIGHT;
            circle = new Circle(centerX, centerY, radius);
            circle.setFill(this.PegColor);
            pegs.getChildren().add(circle);
            circle = new Circle(centerX, centerY + 2 * this.ROW_HEIGHT, radius);
            circle.setFill(this.PegColor);
            pegs.getChildren().add(circle);
        }
        this.root.getChildren().add(pegs);
    }


    /**
     * Create a basic text field for input and a refresh button.
     */
    private void makeControls() {
        Label label1 = new Label("Placement:");
        textField = new TextField ();
        textField.setPrefWidth(300);
        Button button = new Button("Refresh");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                makePlacement(textField.getText());
                textField.clear();
            }
        });
        HBox hb = new HBox();
        hb.getChildren().addAll(label1, textField, button);
        hb.setSpacing(10);
        hb.setLayoutX(130);
        hb.setLayoutY(VIEWER_HEIGHT - 50);
        controls.getChildren().add(hb);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("LinkGame Viewer");
        Scene scene = new Scene(root, VIEWER_WIDTH, VIEWER_HEIGHT);

        root.getChildren().add(controls);

        makeControls();

        drawPegs();

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
