package SetGame;

import SetGame.Card;

import java.util.HashSet;
import java.util.Set;
import java.util.Random;

public class Game {
    protected static Set<Card> board = new HashSet<>();

    Game() {
        initializeBoard();
    }

    public void addCard(Set board) {
        Random randNums = new Random(1);
        int randColor = randNums.nextInt(4);
        int randFill = randNums.nextInt(4);
        int randShape = randNums.nextInt(4);
        int randCount = randNums.nextInt(4);
        Card newCard = new Card(randColor, randFill, randShape, randCount);
        board.add(newCard);
    }

    public void initializeBoard() {
        while (board.size() < 12) {
            addCard(board);
        }
    }
}
