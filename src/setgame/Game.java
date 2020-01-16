package setgame;

import edu.princeton.cs.introcs.StdDraw;

import java.util.*;

public class Game {
    private static Random rng = new Random(1);
    private static Card[] board = new Card[12];
    private static Set<Card> deployed = new HashSet<>(); // Cards that have been seen

    // Cards that were on the board; now discarded
    private static Set<Card> discard = new HashSet<>();
    private static int boardSize = 12;
    private static final int WIDTH = 1200;
    private static final int HEIGHT = 600;
    public static final int BOARD_X_DIM = 4;
    public static final int BOARD_Y_DIM = 3;
    private static final boolean GAME_OVER = false;
    public static int numCardsClicked;
    public static List<Card> clickedCards = new ArrayList<>();

    Game() {
        StdDraw.enableDoubleBuffering();
        board = initializeBoard();
        displayBoard();
        StdDraw.show();
    }
/*
    private class ClickObject {
        private double upperBound;
        private double lowerBound;
        private double leftBound;
        private double rightBound;

        ClickObject(double u, double l, double left, double right) {
            upperBound = u;
            lowerBound = l;
            leftBound = left;
            rightBound = right;
        }
    }*/

    private static void displayBoard() { // Call this method after each set is collected
        for (int i = 0; i < boardSize; i++) {
            StdDraw.setPenColor(StdDraw.BLACK);
            board[i].drawCardOutline();
            board[i].drawCard();
        }
    }

    public int size() {
        return boardSize;
    }

    private Card[] initializeBoard() {
        for (int i = 0; i < Game.boardSize; i++) {
            if (board[i] == null) {
                addCard(i);
            }
        }
        return board;
    }

    private static void addCard(int boardIndex) {
        board[boardIndex] = generateCard(boardIndex);
    }

    private static Card generateCard(int boardIndex) {
        int randColor = rng.nextInt(3);
        int randFill = rng.nextInt(3);
        int randShape = rng.nextInt(3);
        int randCount = rng.nextInt(3);
        Card addCard = new Card(randColor, randFill, randShape, randCount, boardIndex);
        // Checks if card is unique
        if (discard.contains(addCard) || deployed.contains(addCard)) {
            return generateCard(boardIndex);
        } else {
            deployed.add(addCard);
            return addCard;
        }
    }

    private static boolean isSet(Card a, Card b, Card c) {
        boolean colorDiff = (a.color() != b.color()) && (b.color() != c.color())
                && (a.color() != c.color());
        boolean fillDiff = (a.fill() != b.fill()) && (b.fill() != c.fill())
                && (a.fill() != c.fill());
        boolean shapeDiff = (a.shape() != b.shape()) && (b.shape() != c.shape())
                && (a.shape() != c.shape());
        boolean countDiff = (a.count() != b.count()) && (b.count() != c.count())
                && (a.count() != c.count());
        boolean colorSame = (a.color() == b.color()) && (b.color() == c.color())
                && (a.color() == c.color());
        boolean fillSame = (a.fill() == b.fill()) && (b.fill() == c.fill())
                && (a.fill() == c.fill());
        boolean shapeSame = (a.shape() == b.shape()) && (b.shape() == c.shape())
                && (a.shape() == c.shape());
        boolean countSame = (a.count() == b.count()) && (b.count() == c.count())
                && (a.count() == c.count());
        return (colorDiff || colorSame) && (fillDiff || fillSame)
                && (shapeDiff || shapeSame) && (countDiff || countSame);
    }

    public static void collectSet(Card a, Card b, Card c) {
        removeCard(a);
        removeCard(b);
        removeCard(c);
        if (discard.size() < 69) {
            for (int i = 0; i < boardSize; i++) {
                if (board[i] == null) {
                    addCard(i);
                }
            }
        }
        displayBoard();
        StdDraw.show();
    }

    private static void removeCard(Card c) {
        c.borderHighlight();
        board[c.boardIndex()] = null;
        discard.add(c);
        clickedCards.remove(c);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.filledRectangle(c.loc().getX(), c.loc().getY(),
                c.loc().getX() - c.getLeftBound(), c.loc().getY() - c.getLowerBound());
    }

    // Checks if the mouse click has clicked within the boundaries of a Card.
    private static void checkClickCard(double x, double y) {
        // May cause NullExceptionError. If so, adjust the for loop to use indices instead.
        for (Card c : board) {
            if ((x > c.getLeftBound() && x < c.getRightBound()) && (y > c.getLowerBound()
                    && y < c.getUpperBound()) && (numCardsClicked < 3 || c.isHighlighted())) {
                c.borderHighlight();
            }
        }
    }

    public static void displaySubmit() {
        StdDraw.setPenColor(StdDraw.MAGENTA);
        StdDraw.setPenRadius(0.005);
        StdDraw.text(0.5, 0.1, "SUBMIT");
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.rectangle(0.5, 0.105, 0.03, 0.025);
        StdDraw.show();
    }

    public static void clearSubmit() {
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.setPenRadius(0.15);
        StdDraw.line(0.45, 0.1, 0.55, 0.1);
        StdDraw.show();
    }

    public static void checkClickSubmit(double x, double y) {
        Card a = clickedCards.get(0);
        Card b = clickedCards.get(1);
        Card c = clickedCards.get(2);
        if ((x > 0.47 && x < 0.53) && (y > 0.08 && y < 0.13)) {
            if (isSet(a, b, c)) {
                collectSet(a, b, c);
                numCardsClicked = 0;
            } else {
                StdDraw.setPenColor(StdDraw.MAGENTA);
                StdDraw.text(0.5, 0.05, "Not a set, dummy");
                StdDraw.show();
            }
        }
    }

    public static void main(String[] args) {
        StdDraw.setCanvasSize(WIDTH, HEIGHT);
        StdDraw.setPenRadius(0.005);
        new Game();
        while (!GAME_OVER) {
            if (StdDraw.isMousePressed()) {
                checkClickCard(StdDraw.mouseX(), StdDraw.mouseY());
            }
            if (numCardsClicked == 3) {
                displaySubmit();
            }
            if (numCardsClicked != 3) {
                clearSubmit();
            }
            StdDraw.pause(200);
            if (StdDraw.isMousePressed() && numCardsClicked == 3) {
                checkClickSubmit(StdDraw.mouseX(), StdDraw.mouseY());
            }
        }
    }
}

