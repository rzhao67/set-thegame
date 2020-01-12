package SetGame;

import edu.princeton.cs.introcs.StdDraw;

public class Engine {
    public static final int WIDTH = 1200;
    public static final int HEIGHT = 600;
    public static final int BOARD_X_DIM = 4;
    public static final int BOARD_Y_DIM = 3;

    public static void displayBoard(Game game) {
        for (int i = 0; i < BOARD_X_DIM; i++) {
            for (int j = 0; j < BOARD_Y_DIM; j++) {
                Point slot = new Point(i + 1, j + 1);
                StdDraw.text((float) slot.getX() / (BOARD_X_DIM + 1),
                        (float) slot.getY() / (BOARD_Y_DIM + 1), "Hello!");
            }
        }
    }

    public void drawCard(Card c) {
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
    }

    public void interactWithMouse() {

    }

    public static void main(String[] args) {
        Game game = new Game();
        System.out.println(game.size());
        StdDraw.setCanvasSize(WIDTH, HEIGHT);
        displayBoard(game);
    }
}
