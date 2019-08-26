package SetGame;

import java.util.HashSet;
import java.util.Set;
import java.util.Random;

public class Game {
    private static Set<Card> board = new HashSet<>();

    Game() {
        initializeBoard();
    }

    private void addCard(Set board) {
        Random randNums = new Random(1);
        int randColor = randNums.nextInt(4);
        int randFill = randNums.nextInt(4);
        int randShape = randNums.nextInt(4);
        int randCount = randNums.nextInt(4);
        Card newCard = new Card(randColor, randFill, randShape, randCount);
        board.add(newCard);
    }

    private void initializeBoard() {
        while (board.size() < 12) {
            addCard(board);
        }
    }
}
