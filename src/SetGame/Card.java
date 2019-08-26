package SetGame;

public class Card {
    private int color;
    private int fill;
    private int shape;
    private int count;

    Card(int c, int f, int s, int num) {
        color = c;
        fill = f;
        shape = s;
        count = num;
    }

    public boolean equals(Card a, Card b) {
        return a.color == b.color && a.fill == b.fill &&
                a.shape == b.shape && a.count == b.count;
    }

    public int hashCode(Card c) {
        return (int) ((c.color * Math.pow(3, 4)) + (c.fill * Math.pow(3, 3)) +
                (c.shape * Math.pow(3, 2)) + (c.count * 3));
    }
}
