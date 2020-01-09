package SetGame;

import java.util.HashSet;
import java.util.Set;
import java.util.Random;
import static org.junit.Assert.assertTrue;

public class Game {
    protected static Set<Card> board = new HashSet<>();
    private static Set<Card> discard = new HashSet<>();
    private Random randNums = new Random(1);

    Game() {
        initializeBoard();
    }

    private void addCard() {
        int randColor = randNums.nextInt(4);
        int randFill = randNums.nextInt(4);
        int randShape = randNums.nextInt(4);
        int randCount = randNums.nextInt(4);
        Card newCard = new Card(randColor, randFill, randShape, randCount);
        if (discard.contains(newCard)) {
            addCard();
        } else {
            board.add(newCard);
        }
    }

    private void removeCard(Card a) {
        board.remove(a);
    }

    private void initializeBoard() {
        while (board.size() < 12) {
            addCard();
        }
    }

    private boolean isSet(Card a, Card b, Card c) {
        boolean colorDiff = (a.color != b.color) && (b.color != c.color) && (a.color != c.color);
        boolean fillDiff = (a.fill != b.fill) && (b.fill != c.fill) && (a.fill != c.fill);
        boolean shapeDiff = (a.shape != b.shape) && (b.shape != c.shape) && (a.shape != c.shape);
        boolean countDiff = (a.count != b.count) && (b.count != c.count) && (a.count != c.count);
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
    }
}
