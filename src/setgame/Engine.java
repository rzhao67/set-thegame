package setgame;

import edu.princeton.cs.introcs.StdDraw;

public class Engine {
    /*public static final int WIDTH = 1200;
    public static final int HEIGHT = 600;
    public static final int BOARD_X_DIM = 4;
    public static final int BOARD_Y_DIM = 3;

    public static void displayBoard(Game game) {
        for (int i = 0; i < BOARD_X_DIM; i++) {
            for (int j = 0; j < BOARD_Y_DIM; j++) {
                // x-point scales by less than BOARD_X_DIM + 1 to spread cards out. Then subtract 0.1 to shift all cards left.
                Point slot = new Point((float) (i + 1) / (BOARD_X_DIM + 0.15) - 0.1025,
                        (float) (j + 1) / (BOARD_Y_DIM + 0.7) + 0.05);
                drawCard(game.board.get((4 * j) + 1), slot);
            }
        }
    }

    public static void drawCard(Card c, Point p) {
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

    }

    private static void drawCardOutline(Point p) {
        Point northWest = new Point(p.getX() - 0.11, p.getY() + 0.11);
        Point southWest = new Point(p.getX() - 0.11, p.getY() - 0.11);
        Point northEast = new Point(p.getX() + 0.11, p.getY() + 0.11);
        Point southEast = new Point(p.getX() + 0.11, p.getY() - 0.11);
        StdDraw.line(northWest.getX(), northWest.getY(), northEast.getX(), northEast.getY());
        StdDraw.line(northWest.getX(), northWest.getY(), southWest.getX(), southWest.getY());
        StdDraw.line(southWest.getX(), southWest.getY(), southEast.getX(), southEast.getY());
        StdDraw.line(northEast.getX(), northEast.getY(), southEast.getX(), southEast.getY());
    }

    public void interactWithMouse() {

    }

    public static void main(String[] args) {
        Game game = new Game();
        System.out.println(game.size());
        StdDraw.setCanvasSize(WIDTH, HEIGHT);
        displayBoard(game);
    }*/
}
