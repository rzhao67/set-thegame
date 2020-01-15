package setgame;

import edu.princeton.cs.introcs.StdDraw;

public class Card {
    private int color;
    private int fill;
    private int shape;
    private int count;
    private Point loc;
    private int boardIndex;
    private Point northWest;
    private Point northEast;
    private Point southWest;
    private Point southEast;

    public Card(int c, int f, int s, int num, int b) {
        color = c;
        fill = f;
        shape = s;
        count = num;
        boardIndex = b; // board array index
        loc = indexToPoint(boardIndex);
        northWest = new Point(loc.getX() - 0.11, loc.getY() + 0.11);
        southWest = new Point(loc.getX() - 0.11, loc.getY() - 0.11);
        northEast = new Point(loc.getX() + 0.11, loc.getY() + 0.11);
        southEast = new Point(loc.getX() + 0.11, loc.getY() - 0.11);
    }

    private Point indexToPoint(int b) {
        int i = (int) Math.floor((float) b / 3);
        int j = b % 3;
        // x-point scales by less than BOARD_X_DIM + 1 to spread cards out.
        // Then subtract 0.1 to shift all cards left.
        return new Point((float) (i + 1) / (Game.BOARD_X_DIM + 0.15) - 0.1025,
                        (float) (j + 1) / (Game.BOARD_Y_DIM + 0.7) + 0.05);
    }

    public void drawCardOutline() {
        double[] xInd = new double[]{northWest.getX(), northEast.getX(), southEast.getX(), southWest.getX()};
        double[] yInd = new double[]{northWest.getY(), northEast.getY(), southEast.getY(), southWest.getY()};
        StdDraw.polygon(xInd, yInd);
    }

    public static void drawDiamond(Point p) {
        Point west = new Point(p.getX() - 0.025, p.getY());
        Point north = new Point(p.getX(), p.getY() + 0.075);
        Point east = new Point(p.getX() + 0.025, p.getY());
        Point south = new Point(p.getX(), p.getY() - 0.075);
        double[] xInd = new double[]{west.getX(), north.getX(), east.getX(), south.getX()};
        double[] yInd = new double[]{west.getY(), north.getY(), east.getY(), south.getY()};
        StdDraw.polygon(xInd, yInd);
    }

    public static void drawOval(Point p) {
        StdDraw.ellipse(p.getX(), p.getY(), 0.025, 0.075);
    }

    public static void drawSquiggle(Point p) {
        Point northWest = new Point(p.getX() - 0.01, p.getY() + 0.075);
        Point southEast = new Point(p.getX() + 0.01, p.getY() - 0.075);
        Point east = new Point(p.getX() + 0.015, p.getY() + 0.01);
        Point eastSouth = new Point(p.getX() + 0.0025, p.getY() - 0.02);
        Point west = new Point(p.getX() - 0.015, p.getY() - 0.01);
        Point westNorth = new Point(p.getX() - 0.0025, p.getY() + 0.02);
        double[] xInd = new double[]{northWest.getX(), east.getX(), eastSouth.getX(), southEast.getX(), west.getX(), westNorth.getX()};
        double[] yInd = new double[]{northWest.getY(), east.getY(), eastSouth.getY(), southEast.getY(), west.getY(), westNorth.getY()};
        StdDraw.polygon(xInd, yInd);
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

    public static void main(String[] args) {
        /*System.out.println(Math.floor((float) 7 / 3));*/
        StdDraw.setCanvasSize(1200, 600);
        Point p = new Point(0.5, 0.5);
        StdDraw.setPenColor(StdDraw.RED);
        Card.drawSquiggle(p);
    }
}
