package setgame;

import java.util.HashSet;
import java.util.Set;
import java.util.Random;
import java.util.ArrayList;

public class Game {
/*
    public ArrayList<Card> board = new ArrayList<>();
    public Set<Card> discard = new HashSet<>();
    public Random randNums = new Random(1);

    Game() {
        initializeBoard();
    }

    public int size() {
        return board.size();
    }

    private void addCard() {
        int randColor = randNums.nextInt(4);
        int randFill = randNums.nextInt(4);
        int randShape = randNums.nextInt(4);
        int randCount = randNums.nextInt(4);
        Card newCard = new Card(randColor, randFill, randShape, randCount);
        if (discard.contains(newCard) || board.contains(newCard)) {
            addCard();
        } else {
            board.add(newCard);
        }
    }

    private void removeCard(Card a) {
        board.remove(a);
    }

    public void initializeBoard() {
        while (board.size() < 12) {
            addCard();
        }
    }

    private boolean isSet(Card a, Card b, Card c) {
        boolean colorDiff = (a.color() != b.color()) && (b.color() != c.color()) && (a.color() != c.color());
        boolean fillDiff = (a.fill() != b.fill()) && (b.fill() != c.fill()) && (a.fill() != c.fill());
        boolean shapeDiff = (a.shape() != b.shape()) && (b.shape() != c.shape())  && (a.shape() != c.shape());
        boolean countDiff = (a.count() != b.count()) && (b.count() != c.count()) && (a.count() != c.count());
        return colorDiff || fillDiff || shapeDiff || countDiff;
    }

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

    private Random rng = new Random(1);
    private int[] board = new int[12];
    private Set<Card> discard = new HashSet<>();
    private int boardSize = 12;
    public static final int BOARD_X_DIM = 4;
    public static final int BOARD_Y_DIM = 3;

    public int size() {
        return boardSize;
    }

    public void addCard(int boardIndex) {

    }

    private Card generateCard() {
        int randColor = rng.nextInt(3);
        int randFill = rng.nextInt(3);
        int randShape = rng.nextInt(3);
        int randCount = rng.nextInt(3);
    }
}

