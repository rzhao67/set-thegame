package setgame;

import edu.princeton.cs.introcs.StdDraw;

import java.util.HashSet;
import java.util.Set;
import java.util.Random;

public class Game {
/*
    public void collectSet(Card a, Card b, Card c) {
        discard.add(a);
        discard.add(b);
        discard.add(c);
        board.remove(a);
        board.remove(b);
        board.remove(c);
        while (board.size() < 12 && discard.size() < 69) {
            addCard();
        }
    }*/

    private static Random rng = new Random(1);
    private static Card[] board = new Card[12];
    private static Set<Card> deployed = new HashSet<>(); // Cards that have been seen
    private static Set<Card> discard = new HashSet<>(); // Cards that were on the board; now discarded
    private static int boardSize = 12;
    public static final int WIDTH = 1200;
    public static final int HEIGHT = 600;
    public static final int BOARD_X_DIM = 4;
    public static final int BOARD_Y_DIM = 3;

    public Game() {
        initializeBoard();
        displayBoard();
    }

    public void displayBoard() { // Call this method after each set is collected
        for (int i = 0; i < boardSize; i++) {
            board[i].drawCardOutline();
        }
    }

    public int size() {
        return boardSize;
    }

    private void initializeBoard() {
        for (int i = 0; i < Game.boardSize; i++) {
            if (board[i] == null) {
                addCard(i);
            }
        }
    }

    private void addCard(int boardIndex) {
        board[boardIndex] = generateCard(boardIndex);
    }

    public static Card generateCard(int boardIndex) {
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

    private void removeCard(Card c) {
        board[c.boardIndex()] = null;
        discard.add(c);
    }

    private boolean isSet(Card a, Card b, Card c) {
        boolean colorDiff = (a.color() != b.color()) && (b.color() != c.color()) && (a.color() != c.color());
        boolean fillDiff = (a.fill() != b.fill()) && (b.fill() != c.fill()) && (a.fill() != c.fill());
        boolean shapeDiff = (a.shape() != b.shape()) && (b.shape() != c.shape())  && (a.shape() != c.shape());
        boolean countDiff = (a.count() != b.count()) && (b.count() != c.count()) && (a.count() != c.count());
        boolean colorSame = (a.color() == b.color()) && (b.color() == c.color()) && (a.color() == c.color());
        boolean fillSame = (a.fill() == b.fill()) && (b.fill() == c.fill()) && (a.fill() == c.fill());
        boolean shapeSame = (a.shape() == b.shape()) && (b.shape() == c.shape())  && (a.shape() == c.shape());
        boolean countSame = (a.count() == b.count()) && (b.count() == c.count()) && (a.count() == c.count());
        return (colorDiff || colorSame) && (fillDiff || fillSame)
                && (shapeDiff || shapeSame) && (countDiff || countSame);
    }

    public static void main(String[] args) {
        StdDraw.setCanvasSize(WIDTH, HEIGHT);
/*        Game game = new Game();*/
        Card c = generateCard(0);
        c.drawCardOutline();
        c.drawDiamond(c.loc());
    }
}

