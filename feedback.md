# Assignment Two Feedback

## Group memebers: u5968211, u6106722, u6001933

## Tutor Comment
Great work! I like your use of multiple difficulties! The interface was very intuitive.
I couldn't find how to get the hints from the game, so the future it would be good to have a legend describing how to play the game, the keyboard shortcuts, etc.

You lost half a mark here, because you although you implemented different difficulties with varying starting placements, it was through a solutions.txt file and not through algorithms, thereby not "interesting". Steve has stated in the past that there are over 10,000 solutions, which could not be accumulated in your one solutions.txt file. For "interesting" starting placements, the specification was more about taking a difficulty, and algorithmically deriving a string from scratch that implements this difficulty. Currently if I test the code with an unfamiliar string set, the computation time is very slow and the jar stopped responding.

It would also have been nice to see a test for your Component class, to show you have considered the various edge cases.

Overall, very good effort, thorough use of git, good commenting and good code style. I'm impressed!

*EDIT: After discussion with the students regarding their interesting placements algorithm, the mark was amended and the 0.5 mark was re-added*

## Mark

### Manual mark
| Task | Description | Mark |
|:-:|---|:-:|
|8|Basic game                       | 1/1 |
|9|Basic starting placements        | 1/1 |
|11|Hints                           | 1/1 |
|12|Interesting starting placements | 1/1 |

#### Manual mark 4.0/4


### Test results
| Task | Test | Result |
|:-:|---|:-:|
| |Compiled|1/1|
|3|PiecePlacementWellFormed|5/5|
|4|PlacementWellFormed|4/4|
|6|PegsForPiecePlacement|4/4|
|7|PlacementValid|5/5|
|10|Solutions|2/2|

#### Auto grade 7.0/7
### Deductions
| Description | Deduction |
|---|:-:|
|All files correct                | /-1 |
|Authorship clear for all classes | /-1 |
|Appropriate use of git           | /-1 |
|Classes compile correctly        | /-1 |
|Program runs from jar            | /-1 |
|Appropriate use of OO features   | /-.5 |
|Presentation pdf complete        | /-.5 |
|Program well designed            | /-.5 |
|Comments clear and sufficient    | /-.5 |
|Coding style good                | /-.5 |
|Appropriate use of JUnit tests   | /-.5 | - appropriate, although more additions could have been useful
|Design and code of very high quality | /-.5 |
|Works well and easy to run | /-.5 |

#### Total deductions:

### Final mark 11/11
## Originality statement


Signed: Yinshuo Bai (u5968211), Yifei Zhang (u6001933), and Qianru Chen (u6106722)

## Git Log
```
commit 345412ab1718c37c0712038d04bdbc8023dfd248
Merge: 0ebd816 e458339
Author: Bai Yinshuo <baiyinshuo@clatter.cn>
Date:   Fri Oct 14 06:34:58 2016 +1100

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/u5968211/comp1110-ass2-thu09m

    # Conflicts:
    #	admin/G-originality.md

commit 0ebd81679f2a5582f237b7129eecd4a9f55ae680
Author: Bai Yinshuo <baiyinshuo@clatter.cn>
Date:   Fri Oct 14 06:19:37 2016 +1100

    UML & JAR

commit e458339f815b238914b3fdf15388131855f93732
Merge: 2c2dc52 f834eeb
Author: yifei <yifeiimp@gmail.com>
Date:   Fri Oct 14 06:17:38 2016 +1100

    Merge remote-tracking branch 'origin/master'

commit 2c2dc5205ad412df02a8c66bfe7c97fda738ca67
Author: yifei <yifeiimp@gmail.com>
Date:   Fri Oct 14 06:16:32 2016 +1100

    build pathtree for task 12

commit 238445986ac5d535151699263f6248b9923eabf9
Merge: 6e4ede3 c74dbd8
Author: yifei <yifeiimp@gmail.com>
Date:   Fri Oct 14 05:56:49 2016 +1100

    Merge branch 'dev-bai' of https://gitlab.cecs.anu.edu.au/u5968211/comp1110-ass2-thu09m into yifeitest

commit f834eeb85dae3d13f3bed82596c7a250d26ee1ac
Author: Bai Yinshuo <baiyinshuo@clatter.cn>
Date:   Fri Oct 14 05:50:29 2016 +1100

    UML & JAR

commit c74dbd8ece7be83dad9797dfd0e435b89757fb41
Author: Bai Yinshuo <baiyinshuo@clatter.cn>
Date:   Fri Oct 14 05:46:46 2016 +1100

    write some starting points in java file

commit 6e4ede3a677336d3f1e67a22ff31bd704706d9c7
Merge: 2a98e03 7e46cf9
Author: yifei <yifeiimp@gmail.com>
Date:   Fri Oct 14 05:23:18 2016 +1100

    Merge branch 'dev-bai' of https://gitlab.cecs.anu.edu.au/u5968211/comp1110-ass2-thu09m into yifeitest

commit 2a98e0308773cfc795336bb89fc14268d4d3dd12
Author: yifei <yifeiimp@gmail.com>
Date:   Fri Oct 14 05:22:52 2016 +1100

    build pathtree for task 12

commit 7e46cf9a8c1c7b64c5c4d254c186cecb21e98b8c
Author: Bai Yinshuo <baiyinshuo@clatter.cn>
Date:   Fri Oct 14 04:49:39 2016 +1100

    all tasks finished

commit 059bfc87c8ddba2b5a9997113a21f55420e7fea7
Merge: 60f0046 d4e2880
Author: Bai Yinshuo <baiyinshuo@clatter.cn>
Date:   Fri Oct 14 02:56:53 2016 +1100

    Merge branch 'dev-bai'

commit 60f0046ebf1554a7a4bdcd87970926a987afca89
Merge: e9ce9f6 43faa56
Author: Bai Yinshuo <baiyinshuo@clatter.cn>
Date:   Fri Oct 14 02:55:32 2016 +1100

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/comp1110/comp1110-ass2

commit d4e28805e9e8d5ef877a07d0b9c8847c22376d94
Author: Bai Yinshuo <baiyinshuo@clatter.cn>
Date:   Fri Oct 14 02:54:37 2016 +1100

    pre-compute which pegs can a piece be placed at

commit e9ce9f68efe084ef2261b79bfb60c6e7fc096f71
Author: yifei <yifeiimp@gmail.com>
Date:   Fri Oct 14 02:41:34 2016 +1100

    build pathtree for task 12

commit 0dec5511c8a548e19f85a0cc7ae7c941a9af0cc4
Author: yifei <yifeiimp@gmail.com>
Date:   Thu Oct 13 01:57:44 2016 +1100

    build pathtree for task 12

commit dcbf6c1870df2898cb2358d6917154a978a32d26
Author: yifei <yifeiimp@gmail.com>
Date:   Thu Oct 13 01:57:20 2016 +1100

    build pathtree for task 12

commit 43faa56d8d61fb5efe5751c20c5cc1177a11f6ad
Author: COMP1110 Sem 2 2016 <steve.blackburn+comp1110-2016@anu.edu.au>
Date:   Thu Oct 6 21:42:02 2016 +1100

    Added two more simple good placements (that demonstrate a ring with a double opening).

commit 99aa69637f0c48859f8b7c85e02c0cfef0058dd9
Author: COMP1110 Sem 2 2016 <steve.blackburn+comp1110-2016@anu.edu.au>
Date:   Wed Oct 5 15:16:17 2016 +1100

    Added another simple bad placement

commit bc12606aa9bba50bed3acec5702bc38dcbed2bf0
Merge: 21246a3 62ae398
Author: yifei <yifeiimp@gmail.com>
Date:   Tue Oct 4 21:28:42 2016 +1100

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/u5968211/comp1110-ass2-thu09m into yifeitest

commit 62ae3985366324b22a33210b9eafb740a082ad67
Merge: 205b8b5 ae8bac2
Author: Bai Yinshuo <baiyinshuo@clatter.cn>
Date:   Tue Oct 4 21:27:41 2016 +1100

    Merge branch 'dev-bai'

commit ae8bac29ec3544da2522c70cb1c2ecf6742797a4
Author: Bai Yinshuo <baiyinshuo@clatter.cn>
Date:   Tue Oct 4 21:27:27 2016 +1100

    bug fix: condition of where to flip the image of a piece

commit 21246a3d446babedf32d4ea9e91270431c888eb4
Merge: eec94f0 205b8b5
Author: yifei <yifeiimp@gmail.com>
Date:   Tue Oct 4 21:18:19 2016 +1100

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/u5968211/comp1110-ass2-thu09m into yifeitest

commit eec94f01193ac5207503734a06e616dcf97f36e4
Author: yifei <yifeiimp@gmail.com>
Date:   Tue Oct 4 21:18:08 2016 +1100

    bug fix: incorrect image when show hints; inconsistency in flipping a  piece

    update hints every time a piece is placed

commit 205b8b5454ec00dbf3b6d7f84c8a64c7a7c89c69
Merge: adcec9b 3343205
Author: Bai Yinshuo <baiyinshuo@clatter.cn>
Date:   Tue Oct 4 21:13:53 2016 +1100

    Merge branch 'dev-bai'

commit 3343205291a2d3a3ab27be20114e43c4d1de5107
Author: Bai Yinshuo <baiyinshuo@clatter.cn>
Date:   Tue Oct 4 21:13:38 2016 +1100

    explain why set daemon

commit 2f14e787a7dcdacb8bc371062dc1dd245d9c7b23
Author: Bai Yinshuo <baiyinshuo@clatter.cn>
Date:   Tue Oct 4 21:10:52 2016 +1100

    now update hints in a separate thread

    update will be executed every time the placement is changed or the slash key is pressed

commit adcec9b46857f552521278fa947b017d92a8ffff
Merge: 946f875 4f480bd
Author: Bai Yinshuo <baiyinshuo@clatter.cn>
Date:   Tue Oct 4 15:21:16 2016 +1100

    Merge branch 'dev-bai'

commit 4f480bd493edf0d5a2f26567bdb705f39aeb3301
Author: Bai Yinshuo <baiyinshuo@clatter.cn>
Date:   Tue Oct 4 15:21:00 2016 +1100

    bug fixed in Board: incorrect image rotation when creating a FXPiece instance (seems not fixed yet)

commit 946f875dc53a20166bc408b0bad2b487704e29ff
Merge: b7049e0 ef0f0fc
Author: Bai Yinshuo <baiyinshuo@clatter.cn>
Date:   Tue Oct 4 14:41:06 2016 +1100

    Merge remote-tracking branch 'origin/master'

    # Conflicts:
    #	src/comp1110/ass2/LinkGame.java
    #	src/comp1110/ass2/Piece.java

commit b7049e0e0451fa1a06864da26d6177c91856c8ce
Author: Bai Yinshuo <baiyinshuo@clatter.cn>
Date:   Tue Oct 4 14:38:41 2016 +1100

    bug fixed in Board: incorrect image rotation when creating a FXPiece instance

    hints now updated every time the placement on the board in changed

commit e1e55b7b94acadefaa98ee46dfdd53b498c83dc3
Author: Bai Yinshuo <baiyinshuo@clatter.cn>
Date:   Sun Oct 2 17:36:23 2016 +1100

    try to find all solutions. however too difficult :(

commit 80298728bb554e897cea8eb43705a4911b419faa
Author: Bai Yinshuo <baiyinshuo@clatter.cn>
Date:   Sun Oct 2 03:09:58 2016 +1100

    public PiecePool, used instance pool to reduce time cost when extends a placement in DFS

commit 94fd3a863ea2f4f4ee0ac5c70d4e1f2789662a37
Author: Bai Yinshuo <baiyinshuo@clatter.cn>
Date:   Sun Oct 2 01:07:47 2016 +1000

    clean up old codes;

    improve performance in getSuccessor of Placement class, no longer create a temporary Placement instance in each loop

commit 4b44dc35ac6c1f271560480744795401764ec795
Author: Bai Yinshuo <baiyinshuo@clatter.cn>
Date:   Sat Oct 1 17:05:53 2016 +1000

    finished.

    several bugs fixed

    why Java dose not support struct???

commit 9b3b5d558ce409b6f8182f3a6a5f0f9991ab17eb
Author: Bai Yinshuo <baiyinshuo@clatter.cn>
Date:   Fri Sep 30 23:04:23 2016 +1000

    refactor: piece finished

commit ef0f0fca262eae70982a9e4247378162e3c1bc93
Author: yifei <yifeiimp@gmail.com>
Date:   Fri Sep 30 15:14:02 2016 +1000

    task 10 finished and refine class Placement

commit ac5b19af87eb95d8850b275db5ff3653e43cd4ad
Author: yifei <yifeiimp@gmail.com>
Date:   Fri Sep 30 15:11:49 2016 +1000

    task 10 finished and refine class Placement

commit dec95e9ae56ce917e8d8c6c1393fb31aaa3a0c9c
Author: Bai Yinshuo <baiyinshuo@clatter.cn>
Date:   Fri Sep 30 15:10:41 2016 +1000

    refactor: piece

commit fd07b36a070c85fae9eaf1bd3c5cd793e74cc1c5
Author: Bai Yinshuo <baiyinshuo@clatter.cn>
Date:   Fri Sep 30 00:31:54 2016 +1000

    refactor: Component; add a new class temporarily.

    add occupy and free support using new Component representation in Peg.

commit e6713d158f4c258282837f786c9c67176cf920bc
Author: Bai Yinshuo <baiyinshuo@clatter.cn>
Date:   Thu Sep 29 22:14:12 2016 +1000

    refactor: Peg

    update Placement

commit 5ed8ba4b233dc668aea9044ac4d97fdac68292d1
Author: Bai Yinshuo <baiyinshuo@clatter.cn>
Date:   Thu Sep 29 09:27:49 2016 +1000

    add game.jar to VCS

commit 2c21c1bf1eb26b0cad99280f7d7ea0fa3f7e4d11
Merge: 0db7d43 45385f8
Author: Bai Yinshuo <baiyinshuo@clatter.cn>
Date:   Thu Sep 29 00:44:26 2016 +1000

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/comp1110/comp1110-ass2

commit 0db7d43716ad67e12530fec5b38aa6875cea1b12
Author: Bai Yinshuo <baiyinshuo@clatter.cn>
Date:   Thu Sep 29 00:43:40 2016 +1000

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/u5968211/comp1110-ass2-thu09m into dev-bai

    # Conflicts:
    #	src/comp1110/ass2/Placement.java

    Search performance need to be improved

    have some problem in placing hints

    originality & contribution

commit a9d2499be9fc4809ce56105619ca1850e0c911a7
Merge: 96c7bde c7f33d7
Author: Bai Yinshuo <baiyinshuo@clatter.cn>
Date:   Thu Sep 29 00:42:44 2016 +1000

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/u5968211/comp1110-ass2-thu09m into dev-bai

    # Conflicts:
    #	src/comp1110/ass2/Placement.java

    Search performance need to be improved

    have some problem in placing hints

    originality & contribution

commit 96c7bde6dba407b108f0f22cf02dcfce34badfb0
Author: Bai Yinshuo <baiyinshuo@clatter.cn>
Date:   Wed Sep 28 23:07:23 2016 +1000

    TASK#8 done;

    bug fix: now check off-board for each component of a piece;

commit c7f33d76a135f6f8e2185f9d944c8e94b5ba5784
Author: yifei <yifeiimp@gmail.com>
Date:   Wed Sep 28 22:43:45 2016 +1000

    task 10 finished and refine class Placement

commit 09a515c8c629f7f3f6ce30ae7b459c6d9dc2997a
Author: yifei <yifeiimp@gmail.com>
Date:   Wed Sep 28 22:42:21 2016 +1000

    task 10 finished and refine class Placement

commit a07ac4b5d6a9afb6ef746bd6a34052c6be501c27
Author: yifei <yifeiimp@gmail.com>
Date:   Wed Sep 28 22:41:08 2016 +1000

    task 10 finished and refine class Placement

commit 3e1ed37802e880d7d00105c62e29b3b76a5e25c4
Merge: cf8e680 b4d0f82
Author: yifei <yifeiimp@gmail.com>
Date:   Wed Sep 28 15:11:50 2016 +1000

    Merge remote-tracking branch 'origin/master'

commit cf8e680de6f13bf5686e40f77dc2df05c231c938
Author: yifei <yifeiimp@gmail.com>
Date:   Wed Sep 28 15:11:20 2016 +1000

    task 10 finished and refine class Placement

commit 45385f86d7e3aac3c0d4a6369bbafcb02bb8a811
Author: COMP1110 Sem 2 2016 <steve.blackburn+comp1110-2016@anu.edu.au>
Date:   Tue Sep 27 06:24:20 2016 +1000

    Increased timeouts by a further factor of 10x (excepting SolutionsTest).   They now all have 100x of slack, except for SolutionsTest, which has 10x.

commit d0c7b4602ac35a2e55b05ce8c64d7b43def4c1bf
Author: COMP1110 Sem 2 2016 <steve.blackburn+comp1110-2016@anu.edu.au>
Date:   Mon Sep 26 09:23:27 2016 +1000

    Added timeouts to tests

commit b4d0f82135da29dffe34350ffb631cc66ea5dfd2
Merge: 4a1819d fb71b6b
Author: u6106722 <u6106722@anu.edu.au>
Date:   Thu Sep 22 09:14:58 2016 +1000

    Merge remote-tracking branch 'origin/master'

commit 4a1819d87065b20f4a7208d8e2b1bf8ca41a88f1
Author: u6106722 <u6106722@anu.edu.au>
Date:   Thu Sep 22 09:14:32 2016 +1000

    Cc done

commit fb71b6b5d489bee8a802bedda101d079b0c9149c
Author: yifei <yifeiimp@gmail.com>
Date:   Thu Sep 22 09:12:44 2016 +1000

    originality e yifei

commit d57916c5b03b7900737761e6fdeae6b899a6a2da
Author: yifei <yifeiimp@gmail.com>
Date:   Thu Sep 22 09:10:49 2016 +1000

    originality e yifei

commit f764fbda8ce7d1a8d4fa4fbd9fb6ed43eb540500
Author: Bai Yinshuo <baiyinshuo@clatter.cn>
Date:   Thu Sep 22 03:25:53 2016 +1000

    TASK#7 bug fix: pieces placed off the board;

commit 381c1065e5437109d0c16be62e1a183b6125a666
Merge: 3ca7032 c3542a5
Author: Bai Yinshuo <baiyinshuo@clatter.cn>
Date:   Thu Sep 22 03:13:51 2016 +1000

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/comp1110/comp1110-ass2

commit 3ca7032323c51142d29dba38f95b177c97a01ab7
Merge: fb14051 244ae5c
Author: Bai Yinshuo <baiyinshuo@clatter.cn>
Date:   Thu Sep 22 03:12:48 2016 +1000

    Merge branches 'dev-bai', 'master' and 'yifeitest' of https://gitlab.cecs.anu.edu.au/u5968211/comp1110-ass2-thu09m

commit fb140515bd648467070ffd61914b74b8cfe27dc1
Author: Bai Yinshuo <baiyinshuo@clatter.cn>
Date:   Thu Sep 22 03:06:06 2016 +1000

    bug fix: class initialization error in Piece due to infinite recursion(see line 80 in Piece.java);

    bug fix: fail to rotate a piece to orientation G(see line 121 in Piece.java);

    bug fix: miss 'L' in ID lookup table(see line 27~28 in Piece.java);

    update ID after rotate/flip a Piece;

    Now able to remove a piece from a Placement;

    PiecePlacements are now comparable;

    Placements are now independent to the order in which pieces are placed;

    ====

    add unit test for class Placement;

    add E-originality;

commit a3ac75a1752559465cc36875e03c02a8875a4a44
Author: Bai Yinshuo <baiyinshuo@clatter.cn>
Date:   Tue Sep 20 10:42:55 2016 +1000

    now it is possible find the string of a piece according to the Piece instance;

commit 244ae5cd34cc59a6201f1fec61a0d3303ecc5613
Author: yifei <yifeiimp@gmail.com>
Date:   Sun Sep 18 19:50:58 2016 +1000

    unit test for Piece and Ring class

commit cb479b86463bb41ea04ce95143396aa9f48ea83e
Author: Bai Yinshuo <baiyinshuo@clatter.cn>
Date:   Sun Sep 18 14:56:09 2016 +1000

    class peg;
    class placement;
    task#7

commit c3542a5ae8d5786013954c4a8b9bba93f4618707
Author: COMP1110 Sem 2 2016 <steve.blackburn+comp1110-2016@anu.edu.au>
Date:   Thu Sep 15 13:46:08 2016 +1000

    Removed test case with three starting pieces (the assignment only asks you to solve for four or more starting pieces)

commit c1eb0283e9da160c2f6dcca10056c70e6de7b5a4
Merge: fc179c1 7c23cfd
Author: COMP1110 Sem 2 2016 <steve.blackburn+comp1110-2016@anu.edu.au>
Date:   Wed Sep 14 16:07:16 2016 +1000

    Merge remote-tracking branch 'origin/master'

commit fc179c1d0a21005e67b3b38c340f4604bca231f7
Author: COMP1110 Sem 2 2016 <steve.blackburn+comp1110-2016@anu.edu.au>
Date:   Wed Sep 14 16:06:57 2016 +1000

    Fix bug in invalidPiecePlacement, thanks to group tue13h.

commit 207d2c115803da2e45c009b2c56b77eb1e0cb3a5
Merge: 773742c 0372a4d
Author: Bai Yinshuo <baiyinshuo@clatter.cn>
Date:   Thu Sep 1 09:15:07 2016 +1000

    Merge branches 'master' and 'yifeitest' of https://gitlab.cecs.anu.edu.au/u5968211/comp1110-ass2-thu09m

commit 773742cd999adf9419b27fe3f675211bdf6d643d
Author: Bai Yinshuo <baiyinshuo@clatter.cn>
Date:   Thu Sep 1 09:14:53 2016 +1000

    originality

commit 0372a4d272d31bd8b9ae190667186c92b9787104
Author: yifei <yifeiimp@gmail.com>
Date:   Thu Sep 1 09:10:01 2016 +1000

    D-originality

commit 74c0185473e87285974034a79a2691178a657f55
Author: Bai Yinshuo <baiyinshuo@clatter.cn>
Date:   Thu Aug 25 09:05:15 2016 +1000

    originality

commit 6785aa71ea2fc763476bb4cd5fbccf8a8b8ce60f
Merge: a160400 7c23cfd
Author: Bai Yinshuo <baiyinshuo@clatter.cn>
Date:   Wed Aug 24 22:54:02 2016 +1000

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/comp1110/comp1110-ass2

commit a1604007092a4b4a920167705085cdcab8032e5e
Author: Connie Tyrell <u6106722@anu.edu.au>
Date:   Wed Aug 24 19:54:54 2016 +1000

    TASK#5

commit 27be9d29fad6379964a1c51a99c561a6c6dc9b0c
Author: Bai Yinshuo <baiyinshuo@clatter.cn>
Date:   Wed Aug 24 19:02:42 2016 +1000

    refine ring/piece/orientation design;
    fix bug in constructing piece E;
    finish task#6

commit a43c72826e8800fafa878e4f3df6c317d47b12f8
Merge: c85a861 f83e2dd
Author: Bai Yinshuo <baiyinshuo@clatter.cn>
Date:   Wed Aug 24 11:53:09 2016 +1000

    Merge branch 'master' into dev-bai

commit f83e2dd9605cb27214be7af685d5f1a1426bc350
Author: Bai Yinshuo <baiyinshuo@clatter.cn>
Date:   Wed Aug 24 11:52:50 2016 +1000

    resolve typo

commit db6a7281e4a4d8a8c00c3f562d690ec61b243941
Author: yifei <yifeiimp@gmail.com>
Date:   Tue Aug 23 19:57:49 2016 +1000

    refine piece

commit 7c23cfdafdbe4291e78f71de9d686684096bd63e
Author: COMP1110 Sem 2 2016 <steve.blackburn+comp1110-2016@anu.edu.au>
Date:   Thu Aug 18 23:53:50 2016 +1000

    Clarify peg numbering

commit f9596a17d84b365d65b35002e0a55ae952889810
Merge: 0448de8 cb25100
Author: u6106722 <u6106722@anu.edu.au>
Date:   Thu Aug 18 10:07:28 2016 +1000

    Merge remote-tracking branch 'origin/master'

    # Conflicts:
    #	src/gittest/Main.java

commit cb25100863c450143cc229785ab81185930749ed
Merge: 43b81cd d13bdb3
Author: yifei <yifeiimp@gmail.com>
Date:   Thu Aug 18 10:05:42 2016 +1000

    Merge remote-tracking branch 'origin/master'

    # Conflicts:
    #	src/gittest/Main.java

commit 43b81cdd57d1a52810578b3c20327d08b10e2686
Author: Bob <u6001933@anu.edu.au>
Date:   Thu Aug 18 10:04:17 2016 +1000

    add B b = new B()

commit 0448de804fae13737276b84d2d490328f94757f2
Merge: cdb5337 221de67
Author: Cindy <u6106722@anu.edu.au>
Date:   Thu Aug 18 10:01:18 2016 +1000

    Cc done

commit d13bdb3d437e3c3b1b8388fbd83140902ecfe576
Merge: cdb5337 221de67
Author: Alice <u5968211@anu.edu.au>
Date:   Thu Aug 18 10:00:57 2016 +1000

    gittest8

commit 221de6742178de0c8ec3d3c1c1454876c0660e15
Author: Bob <u6001933@anu.edu.au>
Date:   Thu Aug 18 09:58:37 2016 +1000

    New branch

commit cdb53379724612987dbb1e8f9a0cd3f1255b76fd
Merge: ccb65ef aa4298e
Author: u6106722 <u6106722@anu.edu.au>
Date:   Thu Aug 18 09:54:29 2016 +1000

    Merge remote-tracking branch 'origin/master'

    # Conflicts:
    #	src/gittest/A.java

commit ccb65ef732983663c80169e3968c658176b76677
Author: Cindy <u6106722@anu.edu.au>
Date:   Thu Aug 18 09:51:29 2016 +1000

    gittest

commit aa4298e6fbab9f7eb6003eacc67785234da536ea
Merge: 9a9b4c6 8cc05bc
Author: Bai Yinshuo <baiyinshuo@clatter.cn>
Date:   Thu Aug 18 09:54:01 2016 +1000

    Merge remote-tracking branch 'origin/master'

commit 9a9b4c6b944b74c43135e8b1de70ab7b4c0abb4e
Author: Alice <u5968211@anu.edu.au>
Date:   Thu Aug 18 09:53:53 2016 +1000

    gittest2 -- forget to set author

commit 8cc05bcb1e29a02184849e0905e58b5fe91e2703
Merge: ada2415 ba4e882
Author: yifei <yifeiimp@gmail.com>
Date:   Thu Aug 18 09:53:14 2016 +1000

    Merge remote-tracking branch 'origin/master'

commit ada24154c0beed5056e467ba9e7c2d918f3484a2
Author: Bob <u1234567@anu.edu.au>
Date:   Thu Aug 18 09:52:58 2016 +1000

    Bob done

commit ba4e882661dfad60d4a687d0072d87e895dd4958
Author: u6106722 <u6106722@anu.edu.au>
Date:   Thu Aug 18 09:51:29 2016 +1000

    gittest

commit 975a9e03e1648b2db52e29fa4866def6ec5c4dc6
Merge: 5277406 640f82b
Author: Bai Yinshuo <baiyinshuo@clatter.cn>
Date:   Thu Aug 18 09:48:18 2016 +1000

    Merge remote-tracking branch 'origin/master'

commit 52774065b917a3e013415a7fc6438fd907968bd9
Author: Bai Yinshuo <baiyinshuo@clatter.cn>
Date:   Thu Aug 18 09:48:08 2016 +1000

    gittest2

commit 640f82b91c0425a5850898ec69ff22972a92b3b9
Author: yifei <yifeiimp@gmail.com>
Date:   Thu Aug 18 09:37:42 2016 +1000

    contribution & originality

commit 35156067bbb7cbc523c573da21244bfda54215e6
Author: u6106722 <u6106722@anu.edu.au>
Date:   Thu Aug 18 09:34:47 2016 +1000

    contribution

commit d1e90c7f8255e04b1bdd12fc96712a6450945aac
Merge: f6d439f c82c901
Author: u6106722 <u6106722@anu.edu.au>
Date:   Thu Aug 18 09:29:29 2016 +1000

    Merge remote-tracking branch 'origin/master'

    # Conflicts:
    #	admin/B-originality.md

commit f6d439ff729effe592063ed7aace7408093f61d8
Author: u6106722 <u6106722@anu.edu.au>
Date:   Thu Aug 18 09:29:01 2016 +1000

    Done

commit c82c9014d685126ff57273fc86bc43fbf86fcde5
Author: yifei <yifeiimp@gmail.com>
Date:   Thu Aug 18 09:29:01 2016 +1000

    contribution & originality

commit c85a861f2bc7cd3fef67bca1b617d794ea2467a5
Merge: 57d625f 60dc608
Author: Bai Yinshuo <baiyinshuo@clatter.cn>
Date:   Thu Aug 18 09:24:57 2016 +1000

    Merge branch 'master' into dev-bai

commit 60dc60812b7f5024856566b769c762cb6ff9f1dd
Author: Bai Yinshuo <baiyinshuo@clatter.cn>
Date:   Thu Aug 18 09:24:34 2016 +1000

    contribution&originality

commit c05e92636baf5184ddec265a1b3aac3d75e45d2b
Merge: 3073bec 0ba568e
Author: yifei <yifeiimp@gmail.com>
Date:   Thu Aug 18 09:20:33 2016 +1000

    Merge remote-tracking branch 'origin/master'

    # Conflicts:
    #	src/comp1110/ass2/Ball.java

commit 3073bec6d897c16277a83fcb8543ad18ce5c1dbf
Author: yifei <yifeiimp@gmail.com>
Date:   Thu Aug 18 09:20:11 2016 +1000

    resolve conflicts

commit 0ba568e233312e8cbc57ce192ad92e7bd7739660
Author: Bai Yinshuo <baiyinshuo@clatter.cn>
Date:   Thu Aug 18 09:18:04 2016 +1000

    UML.png

commit 4ee37718b34a78e3f7e3b9bb66dd701c10008260
Author: Bai Yinshuo <baiyinshuo@clatter.cn>
Date:   Thu Aug 18 09:17:35 2016 +1000

    UML

commit 5986b2709ff0ef57499209cdab3ced64cf2f7436
Author: yifei <yifeiimp@gmail.com>
Date:   Thu Aug 18 09:15:12 2016 +1000

    resolve conflicts

commit 57d625f476565b929c005649aafdf3e3a21cdd95
Merge: 58bde70 5e5e898
Author: Bai Yinshuo <baiyinshuo@clatter.cn>
Date:   Wed Aug 17 16:55:12 2016 +1000

    Merge branch 'master' into dev-bai

commit 5e5e8980efc48fecc64149fd8e2b81023d142df5
Merge: e916fd0 c81aa07
Author: yifei <yifeiimp@gmail.com>
Date:   Wed Aug 17 16:52:39 2016 +1000

    resolve conflicts

commit c81aa07f6e38fd07761e6a7f5682b63738d7b14c
Author: Bai Yinshuo <baiyinshuo@clatter.cn>
Date:   Wed Aug 17 16:41:53 2016 +1000

    resolve conflicts

commit e916fd0782686e83e9d4f3016105415812f59d1a
Merge: d65ab23 7f529f1
Author: yifei <yifeiimp@gmail.com>
Date:   Wed Aug 17 16:32:56 2016 +1000

    Merge branch 'dev-bai' of https://gitlab.cecs.anu.edu.au/u5968211/comp1110-ass2-thu09m

commit d65ab238ea5171254725bb1136ab7beea0e3e976
Merge: 95404d6 957440e
Author: yifei <yifeiimp@gmail.com>
Date:   Wed Aug 17 16:32:30 2016 +1000

    Merge remote-tracking branch 'origin/master'

    # Conflicts:
    #	src/comp1110/ass2/Piece.java

commit 95404d60e14a6928296c65f07be414e5707b05fe
Author: yifei <yifeiimp@gmail.com>
Date:   Wed Aug 17 16:31:20 2016 +1000

    refine piece design

commit 58bde7013b58479106b810970f850264bde1efb7
Merge: 94510db 957440e
Author: Bai Yinshuo <baiyinshuo@clatter.cn>
Date:   Wed Aug 17 16:30:07 2016 +1000

    Merge branch 'master' into dev-bai

commit 957440e108b5da95f504cd7b4c0c3948edfac4a4
Author: Bai Yinshuo <baiyinshuo@clatter.cn>
Date:   Wed Aug 17 16:29:30 2016 +1000

    add I to L in Piece class;
    fix D in Piece class

commit 9ab93a7ea1c7d82b628cd6e6e080f29e7483f7aa
Author: yifei <yifeiimp@gmail.com>
Date:   Wed Aug 17 16:11:03 2016 +1000

    refine piece design

commit 1c33653e32ee853e13fe39fafefb41f230625ced
Author: yifei <yifeiimp@gmail.com>
Date:   Wed Aug 17 16:10:26 2016 +1000

    refine piece design

commit 94510dbbab69e96c79273be8007926c8a3c71ac1
Merge: 7f529f1 93e0e93
Author: Bai Yinshuo <baiyinshuo@clatter.cn>
Date:   Wed Aug 17 16:08:17 2016 +1000

    Merge branches 'dev-bai' and 'master' of https://gitlab.cecs.anu.edu.au/u5968211/comp1110-ass2-thu09m into dev-bai

commit 93e0e9372df50b5b676ba7c934c72de2f628671a
Author: yifei <yifeiimp@gmail.com>
Date:   Wed Aug 17 16:07:29 2016 +1000

    refine piece design

commit 7f529f1644d26b62b4e639a562a40ab45cbf65c9
Author: Bai Yinshuo <baiyinshuo@clatter.cn>
Date:   Wed Aug 17 15:48:18 2016 +1000

    task #3 & task #4

commit e5f226a99c0da094ecda5d162ffd74ed86ecfd7b
Author: Bai Yinshuo <baiyinshuo@clatter.cn>
Date:   Wed Aug 17 14:29:15 2016 +1000

    merge dev-bai
    add UML file

commit 953236bb3ef63d1f26e49f3520098dc4687d24fd
Merge: 5e219e3 c4f9a3c
Author: Bai Yinshuo <baiyinshuo@clatter.cn>
Date:   Wed Aug 17 14:07:33 2016 +1000

    Merge branch 'master' into dev-bai

commit 5e219e32b2e449190c59e5e17c0151f40229071b
Author: Bai Yinshuo <baiyinshuo@clatter.cn>
Date:   Wed Aug 17 13:45:08 2016 +1000

    initial design for UML
    revert mis-change in View class

commit f77e027ab12063540e721199a28b5326dd9a26c2
Author: Bai Yinshuo <baiyinshuo@clatter.cn>
Date:   Wed Aug 17 01:20:01 2016 +1000

    change orientation into to enumerates
    initial designs for the board

commit fd0e6a6aa7d18260312bff00c9c3893306c0f983
Author: Bai Yinshuo <baiyinshuo@clatter.cn>
Date:   Tue Aug 16 18:23:55 2016 +1000

    Initial design of Piece

commit c4f9a3ce49079e394ae448d7f5efe43d895bb3fb
Author: COMP1110 Sem 2 2016 <steve.blackburn+comp1110-2016@anu.edu.au>
Date:   Tue Aug 16 13:33:12 2016 +1000

    Make it clear how units are numbered.

commit b725d00d654b9cf06b26817e66c5b58e35b7bc24
Author: COMP1110 Sem 2 2016 <steve.blackburn+comp1110-2016@anu.edu.au>
Date:   Tue Aug 16 13:28:47 2016 +1000

    Typos: change 'link' to 'unit'

commit 73ae4739fc8f0a4804c3c8c1e45a46ea2e55e5ff
Author: COMP1110 Sem 2 2016 <steve.blackburn+comp1110-2016@anu.edu.au>
Date:   Tue Aug 16 06:35:23 2016 +1000

    Added missing test for duplicate pieces

commit 31f8dd7b82d7eeb361fc3e0019189dfbbf090e80
Author: COMP1110 Sem 2 2016 <steve.blackburn+comp1110-2016@anu.edu.au>
Date:   Mon Aug 15 23:06:26 2016 +1000

    Added tests

commit ce45890548e232253feb91620ab04e6a04e55d2a
Author: COMP1110 Sem 2 2016 <steve.blackburn+comp1110-2016@anu.edu.au>
Date:   Mon Aug 15 23:05:49 2016 +1000

    Clarify that the A piece has only six valid orientations

commit 995ba01ac70992a368965f387b4fff25ad1ba246
Author: COMP1110 Sem 2 2016 <steve.blackburn+comp1110-2016@anu.edu.au>
Date:   Mon Aug 15 23:04:48 2016 +1000

    Remove stray line

commit 6de4754635d96596632efa382a422f4ed36a9e4c
Author: COMP1110 Sem 2 2016 <steve.blackburn+comp1110-2016@anu.edu.au>
Date:   Wed Aug 10 06:52:17 2016 +1000

    Update README.md

commit 08f7d62a026f4aa630d6ca9951361fd20c7a6397
Author: COMP1110 Sem 2 2016 <steve.blackburn+comp1110-2016@anu.edu.au>
Date:   Tue Aug 9 02:05:06 2016 +1000

    Initial import
```
## Changes
```
diff -ru -x .git ../master/comp1110-ass2/.idea/comp1110-ass2-dev.iml comp1110-ass2/.idea/comp1110-ass2-dev.iml
--- ../master/comp1110-ass2/.idea/comp1110-ass2-dev.iml	2016-10-14 01:20:31.000000000 +1100
+++ comp1110-ass2/.idea/comp1110-ass2-dev.iml	2016-10-14 23:31:45.000000000 +1100
@@ -6,8 +6,29 @@
       <sourceFolder url="file://$MODULE_DIR$/src" isTestSource="false" />
       <sourceFolder url="file://$MODULE_DIR$/src-dev" isTestSource="false" />
       <sourceFolder url="file://$MODULE_DIR$/tests" isTestSource="true" />
+      <sourceFolder url="file://$MODULE_DIR$/res" type="java-resource" />
     </content>
     <orderEntry type="inheritedJdk" />
     <orderEntry type="sourceFolder" forTests="false" />
+    <orderEntry type="module-library" scope="TEST">
+      <library name="JUnit4">
+        <CLASSES>
+          <root url="jar://$MODULE_DIR$/.idea/lib/junit-4.12.jar!/" />
+          <root url="jar://$MODULE_DIR$/.idea/lib/hamcrest-core-1.3.jar!/" />
+        </CLASSES>
+        <JAVADOC />
+        <SOURCES />
+      </library>
+    </orderEntry>
+    <orderEntry type="module-library" scope="TEST">
+      <library name="JUnit4">
+        <CLASSES>
+          <root url="jar://$APPLICATION_HOME_DIR$/lib/junit-4.12.jar!/" />
+          <root url="jar://$APPLICATION_HOME_DIR$/lib/hamcrest-core-1.3.jar!/" />
+        </CLASSES>
+        <JAVADOC />
+        <SOURCES />
+      </library>
+    </orderEntry>
   </component>
 </module>
\ No newline at end of file
diff -ru -x .git ../master/comp1110-ass2/.idea/misc.xml comp1110-ass2/.idea/misc.xml
--- ../master/comp1110-ass2/.idea/misc.xml	2016-10-14 01:20:31.000000000 +1100
+++ comp1110-ass2/.idea/misc.xml	2016-10-14 01:32:00.000000000 +1100
@@ -3,13 +3,6 @@
   <component name="EntryPointsManager">
     <entry_points version="2.0" />
   </component>
-  <component name="MavenImportPreferences">
-    <option name="generalSettings">
-      <MavenGeneralSettings>
-        <option name="mavenHome" value="Bundled (Maven 3)" />
-      </MavenGeneralSettings>
-    </option>
-  </component>
   <component name="ProjectLevelVcsManager" settingsEditedManually="false">
     <OptionsSetting value="true" id="Add" />
     <OptionsSetting value="true" id="Remove" />
Only in comp1110-ass2: OneSolutionTable.txt
diff -ru -x .git ../master/comp1110-ass2/admin/B-contribution.md comp1110-ass2/admin/B-contribution.md
--- ../master/comp1110-ass2/admin/B-contribution.md	2016-10-14 01:20:31.000000000 +1100
+++ comp1110-ass2/admin/B-contribution.md	2016-10-14 01:32:00.000000000 +1100
@@ -1,7 +1,7 @@
 We declare that the work toward our submission of Stage B was distributed among the group members as follows:

-* u2345678 30
-* u3456789 40
-* u0234567 30
+* u5968211 30
+* u6001933 40
+* u6106722 30

-Signed: Mary Jones (u2345678), Bob Smith (u3456789), and Sue Black (u0234567)
+Signed: Yinshuo Bai (u5968211), Yifei Zhang (u6001933), and Qianru Chen (u6106722)
diff -ru -x .git ../master/comp1110-ass2/admin/B-originality.md comp1110-ass2/admin/B-originality.md
--- ../master/comp1110-ass2/admin/B-originality.md	2016-10-14 01:20:31.000000000 +1100
+++ comp1110-ass2/admin/B-originality.md	2016-10-14 01:32:00.000000000 +1100
@@ -1,9 +1,4 @@
-We declare that the work we have submitted for Stage B of this assignment and all stages before it is entirely our own work, with the following documented exceptions:
+We declare that the work we have submitted for Stage B of this assignment and all stages before it is entirely our own work.

-* The idea of using <...> to make the game run faster came from a discussion with <...> (noted in source code comments)

-* The code in class <...> is based on a solution we found when researching the problem (URL provided in source code comments)
-
-*  ....
-
-Signed: Mary Jones (u2345678), Bob Smith (u3456789), and Sue Black (u0123456)
+Signed: Yinshuo Bai (u5968211), Yifei Zhang (u6001933), and Qianru Chen (u6106722)
diff -ru -x .git ../master/comp1110-ass2/admin/C-contribution.md comp1110-ass2/admin/C-contribution.md
--- ../master/comp1110-ass2/admin/C-contribution.md	2016-10-14 01:20:31.000000000 +1100
+++ comp1110-ass2/admin/C-contribution.md	2016-10-14 01:32:00.000000000 +1100
@@ -1,7 +1,7 @@
-We declare that the work toward our submission of Stage C was distributed among the group members as follows:
+We declare that the work toward our submission of Stage B was distributed among the group members as follows:

-* u2345678 30
-* u3456789 40
-* u0234567 30
+* u5968211 40
+* u6001933 40
+* u6106722 20

-Signed: Mary Jones (u2345678), Bob Smith (u3456789), and Sue Black (u0234567)
+Signed: Yinshuo Bai (u5968211), Yifei Zhang (u6001933), and Qianru Chen (u6106722)
diff -ru -x .git ../master/comp1110-ass2/admin/C-originality.md comp1110-ass2/admin/C-originality.md
--- ../master/comp1110-ass2/admin/C-originality.md	2016-10-14 01:20:31.000000000 +1100
+++ comp1110-ass2/admin/C-originality.md	2016-10-14 01:32:00.000000000 +1100
@@ -1,9 +1,4 @@
-We declare that the work we have submitted for Stage C of this assignment and all stages before it is entirely our own work, with the following documented exceptions:
+We declare that the work we have submitted for Stage B of this assignment and all stages before it is entirely our own work.

-* The idea of using <...> to make the game run faster came from a discussion with <...> (noted in source code comments)

-* The code in class <...> is based on a solution we found when researching the problem (URL provided in source code comments)
-
-*  ....
-
-Signed: Mary Jones (u2345678), Bob Smith (u3456789), and Sue Black (u0123456)
+Signed: Yinshuo Bai (u5968211), Yifei Zhang (u6001933), and Qianru Chen (u6106722)
Only in ../master/comp1110-ass2/admin: D-originality-u1234567.md
Only in comp1110-ass2/admin: D-originality-u5968211.md
Only in comp1110-ass2/admin: D-originality-u6001933.md
Only in comp1110-ass2/admin: D-originality-u6106722.md
Only in ../master/comp1110-ass2/admin: E-originality-u1234567.md
Only in comp1110-ass2/admin: E-originality-u5968211.md
Only in comp1110-ass2/admin: E-originality-u6001933.md
Only in comp1110-ass2/admin: E-originality-u6106722.md
diff -ru -x .git ../master/comp1110-ass2/admin/F-contribution.md comp1110-ass2/admin/F-contribution.md
--- ../master/comp1110-ass2/admin/F-contribution.md	2016-10-14 01:20:31.000000000 +1100
+++ comp1110-ass2/admin/F-contribution.md	2016-10-14 01:32:00.000000000 +1100
@@ -1,8 +1,8 @@
 We declare that the work toward our submission of Stage F was distributed among the group members as follows:

-* u2345678 30
-* u3456789 40
-* u0123456 30
+* u5968211 40
+* u6001933 40
+* u6106722 20

-Signed: Mary Jones (u2345678), Bob Smith (u3456789), and Sue Black (u0123456)
+Signed: Yinshuo Bai (u5968211), Yifei Zhang (u6001933), and Qianru Chen (u6106722)

diff -ru -x .git ../master/comp1110-ass2/admin/F-originality.md comp1110-ass2/admin/F-originality.md
--- ../master/comp1110-ass2/admin/F-originality.md	2016-10-14 01:20:31.000000000 +1100
+++ comp1110-ass2/admin/F-originality.md	2016-10-14 01:32:00.000000000 +1100
@@ -1,9 +1,3 @@
-We declare that the work we have submitted for Stage F of this assignment and all stages before it is entirely our own work, with the following documented exceptions:
+We declare that the work we have submitted for Stage F of this assignment and all stages before it is entirely our own work.

-* The idea of using <...> to make the game run faster came from a discussion with <...> (noted in source code comments)
-
-* The code in class <...> is based on a solution we found when researching the problem (URL provided in source code comments)
-
-* ....
-
-Signed: Mary Jones (u2345678), Bob Smith (u3456789), and Sue Black (u0123456)
+Signed: Yinshuo Bai (u5968211), Yifei Zhang (u6001933), and Qianru Chen (u6106722)
Only in ../master/comp1110-ass2/admin: G-best-u1234567.md
Only in comp1110-ass2/admin: G-best-u5968211.md
Only in comp1110-ass2/admin: G-best-u6001933.md
diff -ru -x .git ../master/comp1110-ass2/admin/G-contribution.md comp1110-ass2/admin/G-contribution.md
--- ../master/comp1110-ass2/admin/G-contribution.md	2016-10-14 01:20:31.000000000 +1100
+++ comp1110-ass2/admin/G-contribution.md	2016-10-14 23:31:45.000000000 +1100
@@ -1,8 +1,8 @@
 We declare that the work toward our submission of Stage G was distributed among the group members as follows:

-* u2345678 30
-* u3456789 40
-* u0123456 30
+* u5968211 40
+* u6001933 40
+* u6106722 20

-Signed: Mary Jones (u2345678), Bob Smith (u3456789), and Sue Black (u0123456)
+Signed: Yinshuo Bai (u5968211), Yifei Zhang (u6001933), and Qianru Chen (u6106722)

diff -ru -x .git ../master/comp1110-ass2/admin/G-originality.md comp1110-ass2/admin/G-originality.md
--- ../master/comp1110-ass2/admin/G-originality.md	2016-10-14 01:20:31.000000000 +1100
+++ comp1110-ass2/admin/G-originality.md	2016-10-14 23:31:45.000000000 +1100
@@ -1,9 +1,4 @@
-We declare that the work we have submitted for Stage G of this assignment and all stages before it is entirely our own work, with the following documented exceptions:
+We declare that the work we have submitted for Stage G of this assignment and all stages before it is entirely our own work.

-* The idea of using <...> to make the game run faster came from a discussion with <...> (noted in source code comments)

-* The code in class <...> is based on a solution we found when researching the problem (URL provided in source code comments)
-
-* ....
-
-Signed: Mary Jones (u2345678), Bob Smith (u3456789), and Sue Black (u0123456)
+Signed: Yinshuo Bai (u5968211), Yifei Zhang (u6001933), and Qianru Chen (u6106722)
Only in comp1110-ass2: ass2.uml
Only in comp1110-ass2: feedback.md
Only in comp1110-ass2: game.jar
Only in comp1110-ass2: presentation.pdf
Only in comp1110-ass2: solutions.txt
Only in comp1110-ass2/src: META-INF
Only in comp1110-ass2/src/comp1110/ass2: Component.class
Only in comp1110-ass2/src/comp1110/ass2: Component.java
Only in comp1110-ass2/src/comp1110/ass2: LinkGame.class
diff -ru -x .git ../master/comp1110-ass2/src/comp1110/ass2/LinkGame.java comp1110-ass2/src/comp1110/ass2/LinkGame.java
--- ../master/comp1110-ass2/src/comp1110/ass2/LinkGame.java	2016-10-14 01:20:31.000000000 +1100
+++ comp1110-ass2/src/comp1110/ass2/LinkGame.java	2016-10-14 23:31:45.000000000 +1100
@@ -1,41 +1,72 @@
 package comp1110.ass2;

+
+import java.io.BufferedReader;
+import java.io.FileReader;
+import java.util.*;
+
 /**
+ *  Modified by yifei on 16/9/27.
  * This class provides the text interface for the Link Game
- *
+ * <p>
  * The game is based directly on Smart Games' IQ-Link game
  * (http://www.smartgames.eu/en/smartgames/iq-link)
  */
-public class LinkGame {

+
+public class LinkGame {
     /**
      * Determine whether a piece placement is well-formed according to the following:
      * - it consists of exactly three characters
      * - the first character is in the range A .. X
      * - the second character is in the range A .. L
      * - the third character is in the range A .. F if the second character is A, otherwise
-     *   in the range A .. L
+     * in the range A .. L
      *
      * @param piecePlacement A string describing a piece placement
      * @return True if the piece placement is well-formed
      */
     static boolean isPiecePlacementWellFormed(String piecePlacement) {
-        // FIXME Task 3: determine whether a piece placement is well-formed
-        return false;
+        // Task 3: determine whether a piece placement is well-formed
+        char[] placement = piecePlacement.toCharArray();
+        if (placement.length != 3) return false;
+        if (placement[0] < 'A' || placement[0] > 'X') return false;
+        if (placement[1] < 'A' || placement[1] > 'L') return false;
+        if (placement[1] == 'A') {
+            if (placement[2] < 'A' || placement[2] > 'F') return false;
+        } else {
+            if (placement[2] < 'A' || placement[2] > 'L') return false;
+        }
+        return true;
     }

     /**
      * Determine whether a placement string is well-formed:
-     *  - it consists of exactly N three-character piece placements (where N = 1 .. 12);
-     *  - each piece placement is well-formed
-     *  - no piece appears more than once in the placement
+     * - it consists of exactly N three-character piece placements (where N = 1 .. 12);
+     * - each piece placement is well-formed
+     * - no piece appears more than once in the placement
      *
      * @param placement A string describing a placement of one or more pieces
      * @return True if the placement is well-formed
      */
     static boolean isPlacementWellFormed(String placement) {
-        // FIXME Task 4: determine whether a placement is well-formed
-        return false;
+        // Task 4: determine whether a placement is well-formed
+        if (placement == null) {
+            return false;
+        }
+        int nPiece = placement.length() / 3;
+        if (nPiece < 1 || nPiece > 12 || nPiece * 3 != placement.length()) {
+            return false;
+        }
+        boolean[] duplicated = new boolean[26];
+        for (int i = 1; i < placement.length(); i += 3) {
+            int peg = placement.charAt(i) - 'A';
+            if (!isPiecePlacementWellFormed(placement.substring(i - 1, i + 2)) || duplicated[peg]) {
+                return false;
+            }
+            duplicated[peg] = true;
+        }
+        return true;
     }

     /**
@@ -44,14 +75,70 @@
      * piece.
      * The code needs to account for the origin of the piece, the piece shape, and the piece
      * orientation.
+     *
      * @param piecePlacement A valid string describing a piece placement
      * @return An array of integers corresponding to the pegs which the piece placement touches,
      * listed in the normal order of units for that piece.   The value 0 corresponds to
      * peg 'A', 1 to peg 'B', etc.
      */
     static int[] getPegsForPiecePlacement(String piecePlacement) {
-        // FIXME Task 6: determine the pegs touched by a piece placement
-        return null;
+        // Task 6: determine the pegs touched by a piece placement
+        // for line 1 and 3
+        final int[][] odd_line_offsets = {
+                {0, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}
+        };
+        // for line 0 and 2
+        final int[][] even_line_offsets = {
+                {0, -1}, {-1, -1}, {-1, 0}, {0, 1}, {1, 0}, {1, -1}
+        };
+        int[] pegs = new int[3];
+        int origin = piecePlacement.charAt(0) - 'A';
+        int row = origin / 6, col = origin % 6;
+        // find which one is the first
+        Piece unRotated = Piece.get(piecePlacement.charAt(1) + "A");
+        int cursor = 0;
+        while (cursor < 6) {
+            if (unRotated.getComponent(cursor) == null) {
+                cursor++;
+                continue;
+            }
+            break;
+        }
+        Piece piece = Piece.get(piecePlacement.substring(1, 3));
+        int size = 6;
+        pegs[1] = origin;
+        int[][] offsets = (row % 2 == 0) ? even_line_offsets : odd_line_offsets;
+        boolean first = true;
+        int first_index, third_index;
+        if (piecePlacement.charAt(2) - 'A' < 6) {
+            first_index = 0;
+            third_index = 2;
+        } else {
+            // flipped, first and third swapped
+            first_index = 2;
+            third_index = 0;
+            cursor = (size - cursor) % size;
+        }
+        int checked = 0;
+        while (checked < 2) {
+            if (piece.getComponent(cursor) == null) {
+                cursor++;
+                continue;
+            }
+            int peg_row = row + offsets[cursor % size][0];
+            int peg_col = col + offsets[cursor % size][1];
+            int p = (peg_row < 0 || peg_row >= 4 || peg_col < 0 || peg_col >= 6) ?
+                    -1 : peg_row * 6 + peg_col;
+            if (first) {
+                pegs[first_index] = p;
+                first = false;
+            } else {
+                pegs[third_index] = p;
+            }
+            checked++;
+            cursor++;
+        }
+        return pegs;
     }


@@ -63,19 +150,123 @@
      * @return True if the placement is valid
      */
     static boolean isPlacementValid(String placement) {
-        // FIXME Task 7: determine whether a placement is valid
-        return false;
+        // Task 7: determine whether a placement is valid
+        if (!LinkGame.isPlacementWellFormed(placement)) {
+            return false;
+        }
+        Placement piecePlacement = new Placement();
+        for (int i = 0; i < placement.length(); i += 3) {
+            int origin = placement.charAt(i) - 'A';
+            Piece piece = Piece.get(placement.substring(i + 1, i + 3));
+            if (!piecePlacement.placePiece(piece, origin)) {
+                return false;
+            }
+        }
+        return true;
     }

     /**
      * Return an array of all solutions given a starting placement.
      *
-     * @param placement  A valid piece placement string.
+     * @param placement A valid piece placement string.
      * @return An array of strings, each describing a solution to the game given the
      * starting point provied by placement.
      */
     static String[] getSolutions(String placement) {
-        // FIXME Task 10: determine all solutions to the game, given a particular starting placement
-        return null;
+        // Task 10: determine all solutions to the game, given a particular starting placement
+        return getSolutions(placement, false);
+    }
+
+    // lazy mode returns only one solution, this lazy model is for gennerate hints
+    public static String[] getSolutions(String placement, boolean lazy) {
+        // using String placement to construct init Placement
+        HashSet<Placement> L = new HashSet<>();
+        Stack<Placement> PlacementStack = new Stack<>();
+        if (placement.equals("")) {
+            Placement begin1 = new Placement();
+            PlacementStack.add(begin1);
+        } else {
+            Placement begin2 = new Placement(placement);
+            PlacementStack.add(begin2);
+        }
+
+        // using DFS to search all the possible Placement
+        while (PlacementStack.size() != 0) {
+            Placement temp = PlacementStack.pop();
+            if (temp.isCompleted()) {
+                // System.out.println(temp);
+                if (lazy) {
+                    return new String[]{temp.toString()};
+                }
+                L.add(temp);
+            } else {
+                List<Placement> lists = temp.getsuss();
+                PlacementStack.addAll(lists);
+            }
+        }
+        // add result to a string arr
+        String[] Sol = new String[L.size()];
+        int i = 0;
+        for (Placement plc : L) {
+            Sol[i] = plc.toString();
+            i++;
+        }
+        return Sol;
+    }
+
+    // load starting points
+//    public static String[][] startingList = new String[12][];
+//    static {
+//        try(BufferedReader br = new BufferedReader(new FileReader("starting.txt"))) {
+//            String line = br.readLine();
+//            int i = 1;
+//            ArrayList<String> starting = new ArrayList<>();
+//            while (line != null) {
+//                if (line.length() / 3 > i) {
+//                    LinkGame.startingList[i++] = starting.toArray(new String[0]);
+//                    starting = new ArrayList<>();
+//                }
+//                starting.add(line);
+//                line = br.readLine();
+//            }
+//        } catch (Exception e) {
+//            System.err.println("Error in read starting points");
+//            System.err.println(e);
+//        }
+//    }
+    public static String[][] startingList = StartingPoint.startList;
+
+    public static String getStartingPoint(int difficulty) {
+        // difficulty 0 - 7
+        difficulty = difficulty < 0 ? 0 : difficulty;
+        difficulty = difficulty > 7 ? 7 : difficulty;
+        Random r = new Random();
+        return startingList[10 - difficulty][r.nextInt(startingList[10 - difficulty].length)];
+    }
+
+    public static void main(String[] args) {
+        for (String str : getSolutions("BGECBGGDFHKLJLHKAFKJALEFPFBSHBUCA")) {
+            System.out.println(str);
+        }
+//        System.out.println(GenerateHits("BGECBGGDFHKLJLHKAFKJALEFPFBSHB"));
+//
+//        System.out.println(LinkGame.isPlacementValid("OEANLH"));
+//        String start = args[0];
+//        if (!isPlacementValid(start)) {
+//            System.exit(1);
+//        }
+//        String[] allSolutions = getSolutions(start);
+//        for (String s : allSolutions) {
+//            System.out.println(s);
+//        }
+//        try {
+//            PrintWriter writer = new PrintWriter("solutions" + start + ".txt", "UTF-8");
+//            for (String s : allSolutions) {
+//                writer.println(s);
+//            }
+//            writer.close();
+//        } catch (Exception e) {
+//            System.err.println(e);
+//        }
     }
 }
Only in comp1110-ass2/src/comp1110/ass2: Peg.class
Only in comp1110-ass2/src/comp1110/ass2: Peg.java
Only in comp1110-ass2/src/comp1110/ass2: Piece.class
Only in comp1110-ass2/src/comp1110/ass2: Piece.java
Only in comp1110-ass2/src/comp1110/ass2: PiecePlacement.class
Only in comp1110-ass2/src/comp1110/ass2: Placement.class
Only in comp1110-ass2/src/comp1110/ass2: Placement.java
Only in comp1110-ass2/src/comp1110/ass2: StartingPoint.class
Only in comp1110-ass2/src/comp1110/ass2: StartingPoint.java
Only in comp1110-ass2/src/comp1110/ass2/gui: Board$1.class
Only in comp1110-ass2/src/comp1110/ass2/gui: Board$FXPiece.class
Only in comp1110-ass2/src/comp1110/ass2/gui: Board$ThreadedHint$TaskThread.class
Only in comp1110-ass2/src/comp1110/ass2/gui: Board$ThreadedHint.class
Only in comp1110-ass2/src/comp1110/ass2/gui: Board.class
diff -ru -x .git ../master/comp1110-ass2/src/comp1110/ass2/gui/Board.java comp1110-ass2/src/comp1110/ass2/gui/Board.java
--- ../master/comp1110-ass2/src/comp1110/ass2/gui/Board.java	2016-10-14 01:20:31.000000000 +1100
+++ comp1110-ass2/src/comp1110/ass2/gui/Board.java	2016-10-14 23:31:45.000000000 +1100
@@ -1,12 +1,616 @@
 package comp1110.ass2.gui;

+import Piece;
+import LinkGame;
+import Placement;
 import javafx.application.Application;
+import javafx.geometry.Pos;
+import javafx.scene.Group;
+import javafx.scene.Node;
+import javafx.scene.Scene;
+import javafx.scene.control.Button;
+import javafx.scene.control.Label;
+import javafx.scene.control.Slider;
+import javafx.scene.control.TextArea;
+import javafx.scene.image.Image;
+import javafx.scene.image.ImageView;
+import javafx.scene.input.MouseButton;
+import javafx.scene.layout.Border;
+import javafx.scene.layout.HBox;
+import javafx.scene.layout.Pane;
+import javafx.scene.paint.Color;
+import javafx.scene.paint.Paint;
+import javafx.scene.shape.Circle;
 import javafx.stage.Stage;
+import javafx.stage.StageStyle;
+
+import java.io.BufferedReader;
+import java.io.FileReader;
+import java.util.ArrayList;

 public class Board extends Application {
     private static final int BOARD_WIDTH = 933;
     private static final int BOARD_HEIGHT = 700;

+    private static final int SQUARE_SIZE = 100;
+    private static final int PIECE_IMAGE_SIZE = 3 * SQUARE_SIZE;
+    private static final double ROW_HEIGHT = SQUARE_SIZE * 0.8660254; // 60 degrees
+
+    private static final Paint PegColor = Color.gray(211.0 / 255.0);
+    private static final double RADIUS = 30.0;
+    private static final int LeftMargin = (BOARD_WIDTH - (5 * SQUARE_SIZE + SQUARE_SIZE / 2 + 2 * (int) RADIUS)) / 2;
+    //    private static final int TopMargin = (int) (BOARD_HEIGHT - (ROW_HEIGHT * 3 + RADIUS * 2)) / 2;
+    private static final int TopMargin = (int) (BOARD_HEIGHT - (ROW_HEIGHT * 3 + RADIUS * 2)) / 5;
+    private static final int homeSlotTopMargin = (int) (TopMargin * 2 + 3 * ROW_HEIGHT + SQUARE_SIZE);
+
+    private static final int nPieces = 12;
+    private static final int nPegs = 24;
+
+    private static final int[][] pegCenters = new int[nPegs][2];
+    private static final int[][] homeCenters = new int[nPieces][2];
+    private static final boolean[] homeAvailable = new boolean[nPieces];
+
+    private static final Group gameRoot = new Group();
+    private static final Group initSlot = new Group();
+    private static final Group controls = new Group();
+    private static final Placement currentPlacement = new Placement();
+    private static final Group currentPlacementGroup = new Group();
+    private static final Group hintGroup = new Group();
+
+    private static final FXPiece[] pieces = new FXPiece[nPieces];
+    private static final FXPiece[] hintPieces = new FXPiece[nPieces];
+    private static String IMG_PATH = "comp1110/ass2/gui/assets/%s.png";
+
+    private static final int HINT_THRESHOLD = 3;
+
+
+    // initialize homeAvailable, pegCenters and homeCenters
+    static {
+        for (int i = 0; i < nPieces; i++) {
+            homeAvailable[i] = true;
+        }
+
+        // line 0 and 2
+        for (int i = 0; i < 6; i++) {
+            int centerX = LeftMargin + SQUARE_SIZE * i + (int) RADIUS,
+                    centerY = TopMargin + (int) RADIUS;
+            pegCenters[i][0] = centerX;
+            pegCenters[i][1] = centerY;
+            pegCenters[i + 12][0] = centerX;
+            pegCenters[i + 12][1] = (int) (centerY + 2 * ROW_HEIGHT);
+        }
+        // line 1 and 3
+        for (int i = 0; i < 6; i++) {
+            int centerX = (int) (LeftMargin + SQUARE_SIZE * i + RADIUS + SQUARE_SIZE / 2),
+                    centerY = (int) (TopMargin + RADIUS + ROW_HEIGHT);
+            pegCenters[i + 6][0] = centerX;
+            pegCenters[i + 6][1] = centerY;
+            pegCenters[i + 18][0] = centerX;
+            pegCenters[i + 18][1] = (int) (centerY + 2 * ROW_HEIGHT);
+        }
+
+        int _slotsHeight = (BOARD_HEIGHT - homeSlotTopMargin) / 2;
+        int _slotWidth = BOARD_WIDTH / 6;
+        int _leftMargin = _slotWidth / 2;
+        for (int i = 0; i < nPieces; i++) {
+            homeCenters[i][0] = _leftMargin + (i % 6) * _slotWidth;
+            homeCenters[i][1] = homeSlotTopMargin + (i / 6) * _slotsHeight;
+        }
+    }
+
+
+    /**
+     * Singleton thread
+     * <p>
+     * Use separate thread to calculate hints so that there won't be obvious delay
+     * when user is placing a piece.
+     * <p>
+     * Hints will be updated every time the placement on the board is changed
+     * or the user press the slash key to get a hint.
+     * <p>
+     * Only one thread will be create to get hints
+     * The constructor is claimed as private to make sure there is only one thread
+     * <p>
+     * The reason for using singleton is to prevent the case in which the user
+     * is pressing slash key continuously and lots of threads are created.
+     * <p>
+     * This class will provide a static methods: getSolution
+     * This method will notify the inner thread to start computing task
+     * or it will interrupt the current computing task and start another task
+     * See details below
+     */
+    static class ThreadedHint {
+        /**
+         * This class will do computing in a separate thread
+         * ThreadedHint will maintain one (and only one) reference to
+         * a RunningThread instance
+         */
+        private static class TaskThread extends Thread {
+            private String startPoint = null;
+            // solutions will also cache results found
+            private String[] solutions = null;
+
+            private TaskThread(String startPoint) {
+                this.startPoint = startPoint;
+            }
+
+            @Override
+            public void run() {
+                this.solutions = LinkGame.getSolutions(this.startPoint, true);
+            }
+
+            private String getSolution() {
+                if (super.isAlive()) {
+                    // the thread is still running
+                    return null;
+                } else {
+                    if (this.solutions == null || this.solutions.length == 0) {
+                        // thread finished but no solutions found
+                        return null;
+                    } else {
+                        // ... or find a solution
+                        return this.solutions[0];
+                    }
+                }
+            }
+        }
+
+        private static TaskThread hintThread = null;
+        // keep current task, use this to determine whether to stop current task
+        // and to start a new task or not
+        private static String currentTask = null;
+
+        // private constructor to prevent a instance being created
+        private ThreadedHint() {
+        }
+
+        /**
+         * The only method can be called
+         * First the method will check whether the new task (placement) is same
+         * as last task. If so, it will return saved result for current task
+         * (note that this result could be null if no solutions were found or the
+         * thread is still running) otherwise it will stop current task and start
+         * a new task
+         *
+         * @param placement: the start point
+         * @return a string
+         * null if no solutions or still running
+         * or one solution found for the given starting point
+         */
+        public static String getSolution(String placement) {
+            if (placement.equals(ThreadedHint.currentTask) || ThreadedHint.currentTask == null) {
+                if (ThreadedHint.hintThread == null) {
+                    // in this case, the thread has not been created yet
+                    // we should first create a thread and start the task
+                    // this should be reached only once during the whole execution
+                    // of the program
+                    ThreadedHint.currentTask = placement;
+                    ThreadedHint.hintThread = new TaskThread(ThreadedHint.currentTask);
+                    // set daemon to prevent possible blocks on exit
+                    // block may happen if user exit the program but the thread
+                    // is still running
+                    ThreadedHint.hintThread.setDaemon(true);
+                    ThreadedHint.hintThread.start();
+                    return ThreadedHint.hintThread.getSolution();
+                } else {
+                    // or there already exists a task thread
+                    // just call getSolution method of TaskThread instance
+                    // a solution will be return iff. there exist a solution
+                    // and the task thread has finished running
+                    return ThreadedHint.hintThread.getSolution();
+                }
+            } else {
+                // or a new task comes
+                // first stop old task
+                ThreadedHint.hintThread.interrupt();
+                // then create a new thread and update current task
+                ThreadedHint.currentTask = placement;
+                ThreadedHint.hintThread = new TaskThread(ThreadedHint.currentTask);
+                // set daemon to prevent possible blocks on exit
+                ThreadedHint.hintThread.setDaemon(true);
+                ThreadedHint.hintThread.start();
+                return ThreadedHint.hintThread.getSolution();
+            }
+        }
+    }
+
+    private static void updateHints() {
+        if (currentPlacement.size() < HINT_THRESHOLD) return;
+        gameRoot.getChildren().removeAll(hintGroup.getChildren());
+        gameRoot.getChildren().remove(hintGroup);
+        hintGroup.getChildren().clear();
+//        String[] hintStrings = LinkGame.getSolutions(currentPlacement.toString(), true);
+//        if (hintStrings == null || hintStrings.length == 0) {
+//            hints = null;
+//            return;
+//        }
+//        String hintString = hintStrings[0];
+        String hintString = ThreadedHint.getSolution(currentPlacement.toString());
+        if (hintString == null || hintString.length() == 0) {
+            return;
+        }
+//        System.out.println(hintString);
+        for (int i = 0; i < nPieces; i++) {
+            hintPieces[i] = new FXPiece(hintString.substring(i * 3 + 1, i * 3 + 3));
+            hintPieces[i].placeAt(hintString.charAt(i * 3) - 'A');
+            hintPieces[i].setOpacity(.3);
+        }
+        hintGroup.getChildren().addAll(hintPieces);
+        hintGroup.setVisible(false);
+        gameRoot.getChildren().add(hintGroup);
+    }
+
+    private static void showHints() {
+        hintGroup.setVisible(true);
+    }
+
+    private static void hideHints() {
+        hintGroup.setVisible(false);
+    }
+
+    private static void drawPegs() {
+        double centerX, centerY;
+        Circle circle;
+        // line 0 and 2
+        for (int i = 0; i < 6; i++) {
+            centerX = LeftMargin + SQUARE_SIZE * i + RADIUS;
+            centerY = TopMargin + RADIUS;
+            circle = new Circle(centerX, centerY, RADIUS);
+            circle.setFill(PegColor);
+            gameRoot.getChildren().add(circle);
+            circle = new Circle(centerX, centerY + 2 * ROW_HEIGHT, RADIUS);
+            circle.setFill(PegColor);
+            gameRoot.getChildren().add(circle);
+        }
+        // line 1 and 3
+        for (int i = 0; i < 6; i++) {
+            centerX = LeftMargin + SQUARE_SIZE * i + RADIUS + SQUARE_SIZE / 2;
+            centerY = TopMargin + RADIUS + ROW_HEIGHT;
+            circle = new Circle(centerX, centerY, RADIUS);
+            circle.setFill(PegColor);
+            gameRoot.getChildren().add(circle);
+            circle = new Circle(centerX, centerY + 2 * ROW_HEIGHT, RADIUS);
+            circle.setFill(PegColor);
+            gameRoot.getChildren().add(circle);
+        }
+    }
+
+    static Slider difficulty;
+    static Button restart;
+    private static void makeController() {
+        HBox controllers = new HBox(3);
+        controllers.setSpacing(30);
+        controllers.setFillHeight(true);
+        difficulty = new Slider(0, 7, 3);
+        difficulty.setShowTickLabels(true);
+        difficulty.setShowTickMarks(true);
+        difficulty.setMajorTickUnit(1);
+        difficulty.setMinorTickCount(0);
+        difficulty.setSnapToTicks(true);
+
+        restart = new Button("Restart");
+        restart.setBorder(Border.EMPTY);
+
+        Label label = new Label("Difficulty: ");
+        controllers.getChildren().addAll(label, difficulty, restart);
+        controllers.setAlignment(Pos.CENTER);
+        controllers.setLayoutX(BOARD_WIDTH / 3);
+        controllers.setLayoutY(TopMargin / 4);
+        controls.getChildren().add(controllers);
+    }
+
+    private static void newGame() {
+        currentPlacement.clear();
+        for (int i = 0; i < homeAvailable.length; i++) {
+            homeAvailable[i] = false;
+        }
+        gameRoot.getChildren().clear();
+        initSlot.getChildren().clear();
+        currentPlacementGroup.getChildren().clear();
+        hintGroup.getChildren().clear();
+        for (int i = 0; i < nPieces; i++) {
+            pieces[i] = new FXPiece(String.format("%c%c", (char) (i + 'A'), 'A'));
+        }
+        for (FXPiece piece : pieces) {
+            piece.placeAt(-(piece._piece.getPieceID().charAt(0) - 'A' + 1));
+            gameRoot.getChildren().add(piece);
+        }
+        drawPegs();
+        gameRoot.getChildren().add(controls);
+        String starting = LinkGame.getStartingPoint((int) difficulty.getValue());
+        for (int i = 0; i < starting.length(); i += 3) {
+            putPieceOnboard(starting.substring(i, i + 3));
+        }
+//        putPieceOnboard("BAA");
+//        putPieceOnboard("HBA");
+//        putPieceOnboard("TCJ");
+        if (currentPlacement.size() >= HINT_THRESHOLD) {
+            updateHints();
+        }
+    }
+
+    // resolve threading synchronize issue
+    private static void updatePlacement() {
+        synchronized (currentPlacement) {
+            currentPlacement.clear();
+            for (FXPiece fxPiece : pieces) {
+                synchronized (fxPiece) {
+                    if (fxPiece._isOnBoard) {
+                        currentPlacement.placePiece(fxPiece._piece, fxPiece._position);
+                    }
+                }
+            }
+        }
+    }
+
+    static class FXPiece extends ImageView {
+        private Piece _piece;
+        private boolean _isOnBoard;
+        // _position keeps the last valid position of a piece
+        private int _position;  // 0 ~ 23: pegs;    -1 ~ -12: home slots
+        private int _x, _y;     // coordinate of center of the piece
+        private static int _img_size = PIECE_IMAGE_SIZE;
+        private boolean _isDrag = false;
+
+        // rotate _piece (will create a new Piece instance)
+        // will not check valid or not
+        private Piece rotate(boolean counterClockwise) {
+            return Piece.getRotated(this._piece, counterClockwise);
+        }
+
+        private Piece flip() {
+            return Piece.getFlipped(this._piece);
+        }
+
+        // return 0 ~ 23, will *NOT* check if the placement is valid
+        private int findNearestPeg() {
+            int p = Integer.MAX_VALUE;
+            int minDistance = Integer.MAX_VALUE;
+            for (int i = 0; i < nPegs; i++) {
+                int xCenter = pegCenters[i][0];
+                int yCenter = pegCenters[i][1];
+                int distance = (xCenter - _x) * (xCenter - _x)
+                        + (yCenter - _y) * (yCenter - _y);
+                if (distance < minDistance) {
+                    p = i;
+                    minDistance = distance;
+                }
+            }
+            return p;
+        }
+
+        // return -1 ~ -12, will check if the slot is available
+        private int findNearestHomeSlot() {
+            int p = -Integer.MAX_VALUE;
+            int minDistance = Integer.MAX_VALUE;
+            for (int i = 0; i < nPieces; i++) {
+                if (!homeAvailable[i]) continue;
+                int xCenter = homeCenters[i][0];
+                int yCenter = homeCenters[i][1];
+                int distance = (xCenter - _x) * (xCenter - _x)
+                        + (yCenter - _y) * (yCenter - _y);
+                if (distance < minDistance) {
+                    p = -(i + 1);
+                    minDistance = distance;
+                }
+            }
+            return p;
+        }
+
+        // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
+        //  This method will not check if the place is valid
+        // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
+        private void placeAt(int position) {
+            if (position < 0) {
+                int slotOrdinal = -(position + 1);
+                // place to first off-board slot
+                _x = homeCenters[slotOrdinal][0] - _img_size / 2;
+                _y = homeCenters[slotOrdinal][1] - _img_size / 2;
+                setX(_x);
+                setY(_y);
+                if (!_isOnBoard && !_isDrag) {
+                    super.setScaleX(.5);
+                    super.setScaleY(getScaleY() / Math.abs(getScaleY()) * .5);
+                }
+                homeAvailable[slotOrdinal] = false;
+                _position = position;
+            } else {
+                // place to peg #position
+                _x = pegCenters[position][0] - _img_size / 2;
+                _y = pegCenters[position][1] - _img_size / 2;
+                setX(_x);
+                setY(_y);
+                if (_position < 0) {
+                    homeAvailable[-(_position + 1)] = true;
+                }
+                super.setScaleX(1.);
+                super.setScaleY(getScaleY() / Math.abs(getScaleY()));
+                _position = position;
+            }
+        }
+
+        private void update(double x, double y) {
+            _x = (int) x;
+            _y = (int) y;
+            this.setX(_x - _img_size / 2);
+            this.setY(_y - _img_size / 2);
+        }
+
+        FXPiece(String pieceString) {
+            super.setImage(new Image(String.format(IMG_PATH, pieceString.charAt(0))));
+            int orientation = pieceString.charAt(1) - 'A';
+            if (orientation >= 6) {
+                orientation -= 6;
+                super.setScaleY(-1);
+                super.setRotate(60. * orientation);
+            } else {
+                super.setRotate(60. * orientation);
+            }
+
+            this._piece = Piece.get(pieceString);
+            this._isDrag = false;
+            this._isOnBoard = false;
+            this.placeAt(-(pieceString.charAt(0) - 'A' + 1));
+
+            // scale up by 1.1
+            setOnMouseDragged(event -> {
+                _isDrag = true;
+                _isOnBoard = false;
+                if (_position < 0) {
+                    // free the slot it was occupying
+                    homeAvailable[-(_position + 1)] = true;
+                } else {
+                    // remove from board
+                    currentPlacement.removePiece(_piece);
+                }
+                toFront();
+                update(event.getSceneX(), event.getSceneY());
+                super.setScaleX(1.1);
+                super.setScaleY(getScaleY() / Math.abs(getScaleY()) * 1.1);
+            });
+
+            // scale back to 1
+            setOnMouseReleased(event -> {
+                if (_isDrag) {
+                    update(event.getSceneX(), event.getSceneY());
+                    int nearestPeg = findNearestPeg();
+                    if (currentPlacement.placePiece(_piece, nearestPeg)) {
+                        _isDrag = false;
+                        _isOnBoard = true;
+                        if (currentPlacement.size() >= HINT_THRESHOLD) {
+                            updateHints();
+                        }
+                        placeAt(nearestPeg);
+                    } else {
+                        _isDrag = false;
+                        _isOnBoard = false;
+                        placeAt(findNearestHomeSlot());
+                    }
+                    _isDrag = false;
+                }
+            });
+
+            // rotate
+            setOnScroll(event -> {
+                // setup a threshold
+                double threshold = .5;
+                if (event.getDeltaY() > threshold || event.getDeltaY() < -threshold) {
+                    if (event.getDeltaY() > 0) {
+                        // click left button to rotate (clockwise)
+                        if (_isOnBoard) {
+                            if (currentPlacement.rotatePiece(_piece, false)) {
+                                _piece = rotate(false);
+                                if (currentPlacement.size() >= HINT_THRESHOLD) {
+                                    updateHints();
+                                }
+                                setRotate((getRotate() + 60) % 360);
+                            }
+                        } else {
+                            _piece = rotate(false);
+                            setRotate((getRotate() + 60) % 360);
+
+                        }
+                    } else {
+                        // counter-clockwise
+                        if (_isOnBoard) {
+                            if (currentPlacement.rotatePiece(_piece, true)) {
+                                _piece = rotate(true);
+                                if (currentPlacement.size() >= HINT_THRESHOLD) {
+                                    updateHints();
+                                }
+                                setRotate((getRotate() - 60) % 360);
+                            }
+                        } else {
+                            _piece = rotate(true);
+                            setRotate((getRotate() - 60) % 360);
+
+                        }
+                    }
+                }
+            });
+
+            setOnMouseClicked(event -> {
+                if (event.getClickCount() == 1) {
+                    // right click to reset to home
+                    if (event.getButton() == MouseButton.SECONDARY) {
+                        if (currentPlacement.removePiece(this._piece)) {
+                            int homeSlot = findNearestHomeSlot();
+                            if (homeSlot >= -nPieces) {
+                                // free the slot it currently occupies
+                                if (_position < 0) {
+                                    homeAvailable[-(_position + 1)] = true;
+                                }
+                                _isDrag = false;
+                                _isOnBoard = false;
+                                placeAt(homeSlot);
+                                if (currentPlacement.size() >= HINT_THRESHOLD) {
+                                    updateHints();
+                                }
+                                System.out.println("reset to home: " + this._piece);
+                            }
+                        }
+                    }
+                } else if (event.getClickCount() == 2) {
+                    // double left click -- flip
+                    if (event.getButton() == MouseButton.PRIMARY) {
+                        if (_isOnBoard) {
+                            // check if flip is valid
+                            if (currentPlacement.flipPiece(_piece)) {
+                                super.setRotate(-super.getRotate());
+                                super.setScaleY(-super.getScaleY());
+                                _piece = flip();
+                                if (currentPlacement.size() >= HINT_THRESHOLD) {
+                                    updateHints();
+                                }
+                            }
+                        } else {
+                            super.setRotate(-super.getRotate());
+                            super.setScaleY(-super.getScaleY());
+                            _piece = flip();
+                        }
+                    }
+                }
+            });
+
+        }
+
+    }
+
+    private static void Piecerot(FXPiece p) {
+        p._piece = p.rotate(false);
+        p.setRotate((p.getRotate() + 60) % 360);
+    }
+
+    private static void Piecefilp(FXPiece p) {
+        p.setRotate(-p.getRotate());
+        p.setScaleY(-p.getScaleY());
+        p._piece = p.flip();
+    }
+
+    public static void putPieceOnboard(String p) {
+        int pos = p.charAt(0) - 'A';
+        int pie = p.charAt(1) - 'A';
+        int ori = p.charAt(2) - 'A';
+        if (ori < 6) {
+            int num = ori;
+            for (int i = 0; i < num; i++) {
+                Piecerot(pieces[pie]);
+            }
+        } else {
+            int num = ori - 6;
+            Piecefilp(pieces[pie]);
+            for (int i = 0; i < num; i++) {
+                Piecerot(pieces[pie]);
+            }
+        }
+        pieces[pie].placeAt(pos);
+        pieces[pie]._isOnBoard = true;
+
+        currentPlacement.placePiece(pieces[pie]._piece, pos);
+        pieces[pie].toFront();
+    }
+
+
     // FIXME Task 8: Implement a basic playable Link Game in JavaFX that only allows pieces to be placed in valid places

     // FIXME Task 9: Implement starting placements
@@ -17,6 +621,43 @@

     @Override
     public void start(Stage primaryStage) throws Exception {
-
+        Scene gameScene = new Scene(this.gameRoot, BOARD_WIDTH, BOARD_HEIGHT);
+        primaryStage.setTitle("IQ-link");
+        makeController();
+        newGame();
+        gameScene.setOnKeyReleased(event -> {
+            switch (event.getCode()) {
+                case R: {
+                    newGame();
+                    break;
+                }
+                case SLASH: {
+                    hideHints();
+//                    System.out.println("hind hints");
+                    break;
+                }
+            }
+        });
+        gameScene.setOnKeyPressed(event -> {
+            switch (event.getCode()) {
+                case SLASH: {
+                    if (currentPlacement.size() < HINT_THRESHOLD) break;
+                    updateHints();
+                    showHints();
+//                    System.out.println("show hints");
+                    break;
+                }
+                case Q: {
+                    primaryStage.close();
+                    System.exit(0);
+                    break;
+                }
+            }
+        });
+        restart.setOnMouseReleased(event -> {
+            newGame();
+        });
+        primaryStage.setScene(gameScene);
+        primaryStage.show();
     }
 }
Only in comp1110-ass2/src/comp1110/ass2/gui: Viewer$1.class
Only in comp1110-ass2/src/comp1110/ass2/gui: Viewer.class
diff -ru -x .git ../master/comp1110-ass2/src/comp1110/ass2/gui/Viewer.java comp1110-ass2/src/comp1110/ass2/gui/Viewer.java
--- ../master/comp1110-ass2/src/comp1110/ass2/gui/Viewer.java	2016-10-14 01:20:31.000000000 +1100
+++ comp1110-ass2/src/comp1110/ass2/gui/Viewer.java	2016-10-14 01:32:00.000000000 +1100
@@ -8,7 +8,12 @@
 import javafx.scene.control.Button;
 import javafx.scene.control.Label;
 import javafx.scene.control.TextField;
+import javafx.scene.image.Image;
+import javafx.scene.image.ImageView;
 import javafx.scene.layout.HBox;
+import javafx.scene.paint.Color;
+import javafx.scene.paint.Paint;
+import javafx.scene.shape.Circle;
 import javafx.stage.Stage;

 /**
@@ -27,12 +32,19 @@
     private static final int VIEWER_WIDTH = 750;
     private static final int VIEWER_HEIGHT = 500;

+    private static final Paint PegColor = Color.gray(211.0 / 255.0);
+    private static final double RADIUS = 30.0;
+    private static final int LeftMargin = (VIEWER_WIDTH - (5 * SQUARE_SIZE + SQUARE_SIZE / 2 + 2 * (int) RADIUS)) / 2;
+    private static final int TopMargin = SQUARE_SIZE / 2;
+
     private static final String URI_BASE = "assets/";

     private final Group root = new Group();
     private final Group controls = new Group();
     TextField textField;

+    private final Group placementGroup = new Group();
+

     /**
      * Draw a placement in the window, removing any previously drawn one
@@ -40,7 +52,89 @@
      * @param placement  A valid placement string
      */
     void makePlacement(String placement) {
-        // FIXME Task 5: implement the simple placement viewer
+        // Task 5: implement the simple placement viewer
+        this.placementGroup.getChildren().remove(0, this.placementGroup.getChildren().size());
+        this.root.getChildren().remove(this.placementGroup);
+        for (int i = 0; i < placement.length(); i += 3) {
+            ImageView piece = this.placePiece(placement.substring(i, i + 3));
+            this.placementGroup.getChildren().add(piece);
+        }
+        this.root.getChildren().addAll(this.placementGroup);
+
+    }
+    /**
+     * place a certain piece
+     * (0, 0) - x
+     * |
+     * y
+     *
+     * @param placement
+     * @return ImageView generated
+     */
+    private ImageView placePiece(String placement) {
+        int origin = placement.charAt(0) - 'A';
+        char pieceName = placement.charAt(1);
+        int rotate = placement.charAt(2) - 'A';
+        String IMG_PATH = "comp1110/ass2/gui/" + this.URI_BASE + pieceName + ".png";
+        Image pieceImg = new Image(IMG_PATH);
+        ImageView pieceImgView = new ImageView();
+        pieceImgView.setImage(pieceImg);
+        // find coordinate of left-top point of the image
+        // first find coordinate of the center
+        int row = origin / 6, col = origin % 6;
+        double Y = this.TopMargin + this.RADIUS + row * this.ROW_HEIGHT;
+        double X = this.LeftMargin + this.RADIUS + col * this.SQUARE_SIZE;
+        // for the odd lines, add an extra offset to X
+        // line number starts at 0
+        if (row % 2 != 0) {
+            X += this.SQUARE_SIZE / 2;
+        }
+        // then the top-left point
+        X -= this.PIECE_IMAGE_SIZE / 2;
+        Y -= this.PIECE_IMAGE_SIZE / 2;
+        // set coordinate for image
+        pieceImgView.setX(X);
+        pieceImgView.setY(Y);
+        // rotate by degree, clockwise
+        pieceImgView.setRotate(60 * rotate);
+        // need flip?
+        if (rotate >= 6) {
+            pieceImgView.setScaleY(-1);
+        }
+        return pieceImgView;
+    }
+
+    // Draw pegs
+    private void drawPegs() {
+        // radius is 60 pixels. counted...
+        double radius = this.RADIUS;
+        double centerX, centerY;
+        Circle circle;
+        // create a new group
+        Group pegs = new Group();
+        // draw the first and the third line
+        for (int i = 0; i < 6; i++) {
+            centerX = this.LeftMargin + this.SQUARE_SIZE * i + radius;
+            centerY = this.TopMargin + radius;
+            circle = new Circle(centerX, centerY, radius);
+            circle.setFill(this.PegColor);
+            pegs.getChildren().add(circle);
+            circle = new Circle(centerX, centerY + 2 * this.ROW_HEIGHT, radius);
+            circle.setFill(this.PegColor);
+            pegs.getChildren().add(circle);
+        }
+        // draw the second and the forth line
+        for (int i = 0; i < 6; i++) {
+            centerX = this.LeftMargin + this.SQUARE_SIZE * i + radius + this.SQUARE_SIZE / 2;
+            centerY = this.TopMargin + radius + this.ROW_HEIGHT;
+            circle = new Circle(centerX, centerY, radius);
+            circle.setFill(this.PegColor);
+            pegs.getChildren().add(circle);
+            circle = new Circle(centerX, centerY + 2 * this.ROW_HEIGHT, radius);
+            circle.setFill(this.PegColor);
+            pegs.getChildren().add(circle);
+        }
+        this.root.getChildren().add(pegs);
     }


@@ -76,6 +170,8 @@

         makeControls();

+        drawPegs();
+
         primaryStage.setScene(scene);
         primaryStage.show();
     }
Only in comp1110-ass2/src/comp1110/ass2/gui: pathtree.class
Only in comp1110-ass2/src/comp1110/ass2/gui: pathtree.java
Only in comp1110-ass2/src: gittest
Only in comp1110-ass2: starting
Only in comp1110-ass2/tests/comp1110/ass2: PlacementTest.java
Only in comp1110-ass2: uml.png
```
## Test log
```
--javac output--
----
java -cp comp1110-ass2/src:/Users/yaya_lu14/Documents/comp1510-tutoring-practice/comp1110-tutors/bin/../ass2/ass2-1110-tests.jar:/Users/yaya_lu14/Documents/comp1510-tutoring-practice/comp1110-tutors/bin/../ass2/hamcrest-core-1.3.jar:/Users/yaya_lu14/Documents/comp1510-tutoring-practice/comp1110-tutors/bin/../ass2/junit-4.12.jar org.junit.runner.JUnitCore PiecePlacementWellFormedTest
---
JUnit version 4.12
.....
Time: 0.016

OK (5 tests)

java -cp comp1110-ass2/src:/Users/yaya_lu14/Documents/comp1510-tutoring-practice/comp1110-tutors/bin/../ass2/ass2-1110-tests.jar:/Users/yaya_lu14/Documents/comp1510-tutoring-practice/comp1110-tutors/bin/../ass2/hamcrest-core-1.3.jar:/Users/yaya_lu14/Documents/comp1510-tutoring-practice/comp1110-tutors/bin/../ass2/junit-4.12.jar org.junit.runner.JUnitCore PlacementWellFormedTest
---
JUnit version 4.12
.....
Time: 0.017

OK (5 tests)

java -cp comp1110-ass2/src:/Users/yaya_lu14/Documents/comp1510-tutoring-practice/comp1110-tutors/bin/../ass2/ass2-1110-tests.jar:/Users/yaya_lu14/Documents/comp1510-tutoring-practice/comp1110-tutors/bin/../ass2/hamcrest-core-1.3.jar:/Users/yaya_lu14/Documents/comp1510-tutoring-practice/comp1110-tutors/bin/../ass2/junit-4.12.jar org.junit.runner.JUnitCore PegsForPiecePlacementTest
---
JUnit version 4.12
....
Time: 0.042

OK (4 tests)

java -cp comp1110-ass2/src:/Users/yaya_lu14/Documents/comp1510-tutoring-practice/comp1110-tutors/bin/../ass2/ass2-1110-tests.jar:/Users/yaya_lu14/Documents/comp1510-tutoring-practice/comp1110-tutors/bin/../ass2/hamcrest-core-1.3.jar:/Users/yaya_lu14/Documents/comp1510-tutoring-practice/comp1110-tutors/bin/../ass2/junit-4.12.jar org.junit.runner.JUnitCore PlacementValidTest
---
JUnit version 4.12
.....
Time: 0.045

OK (5 tests)

java -cp comp1110-ass2/src:/Users/yaya_lu14/Documents/comp1510-tutoring-practice/comp1110-tutors/bin/../ass2/ass2-1110-tests.jar:/Users/yaya_lu14/Documents/comp1510-tutoring-practice/comp1110-tutors/bin/../ass2/hamcrest-core-1.3.jar:/Users/yaya_lu14/Documents/comp1510-tutoring-practice/comp1110-tutors/bin/../ass2/junit-4.12.jar org.junit.runner.JUnitCore SolutionsTest
---
JUnit version 4.12
..
Time: 0.433

OK (2 tests)

```
