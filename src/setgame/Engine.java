package setgame;

import edu.princeton.cs.introcs.StdDraw;

public class Engine {
    public static final int WIDTH = 1200;
    public static final int HEIGHT = 600;
    public static final int BOARD_X_DIM = 4;
    public static final int BOARD_Y_DIM = 3;



    /*public static void drawCard(Card c, Point p) {
        StdDraw.setPenColor(StdDraw.BLACK);
        drawCardOutline(p);
        switch (c.color()) {
            case 1:
                StdDraw.setPenColor(StdDraw.RED);
                break;
            case 2:
                StdDraw.setPenColor(StdDraw.GREEN);
                break;
            case 3: //purple
                StdDraw.setPenColor(138, 43, 226);
                break;
        }
        switch (c.count()) {
            case 1:
                drawOne(c, p);
                break;
            case 2:
                drawTwo(c, p);
                break;
            case 3:
                drawThree(c, p);
                break;
        }
        switch (c.fill()) {
            case 1:
                fillSolid(c, p);
                break;
            case 2:
                fillStripes(c, p);
                break;
            case 3: //hollow
                break;
        }
    }

    private static void drawOne(Card c, Point p) {

    }

    private static void drawTwo(Card c, Point p) {

    }

    private static void drawThree(Card c, Point p) {

    }

    private static void fillSolid(Card c, Point p) {

    }

    private static void fillStripes(Card c, Point p) {

    }*/

    public void interactWithMouse() {

    }

    public static void main(String[] args) {
        Game game = new Game();
    }
}
