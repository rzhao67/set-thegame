package SetGame;

import edu.princeton.cs.introcs.StdDraw;

public class Card {
    protected int color;
    protected int fill;
    protected int shape;
    protected int count;

    Card(int c, int f, int s, int num) {
        color = c;
        fill = f;
        shape = s;
        count = num;
    }

    public void drawCard(Card c) {
        switch (c.color) {
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

    public boolean equals(Card a, Card b) {
        return a.color == b.color && a.fill == b.fill &&
                a.shape == b.shape && a.count == b.count;
    }

    public int hashCode(Card c) {
        return (int) ((c.color * Math.pow(3, 4)) + (c.fill * Math.pow(3, 3)) +
                (c.shape * Math.pow(3, 2)) + (c.count * 3));
    }
}
