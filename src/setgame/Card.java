package setgame;

public class Card {
    private int color;
    private int fill;
    private int shape;
    private int count;
    private Point loc;
    private int boardIndex;

    public Card(int c, int f, int s, int num, int b) {
        color = c;
        fill = f;
        shape = s;
        count = num;
        boardIndex = b; // board array index
        loc = indexToPoint(boardIndex);
    }

    private Point indexToPoint(int b) {

    }

    public int boardIndex() {
        return boardIndex;
    }

    public Point loc() {
        return loc;
    }

    public int color() {
        return color;
    }

    public int fill() {
        return fill;
    }

    public int shape() {
        return shape;
    }

    public int count() {
        return count;
    }

    public boolean equals(Card a, Card b) {
        return a.color == b.color && a.fill == b.fill
                && a.shape == b.shape && a.count == b.count;
    }

    public int hashCode(Card c) {
        return (int) ((c.color * Math.pow(3, 4)) + (c.fill * Math.pow(3, 3))
                + (c.shape * Math.pow(3, 2)) + (c.count * 3));
    }
}
