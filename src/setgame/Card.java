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
    private boolean highlighted = false;

    Card(int c, int f, int s, int num, int b) {
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

    public void drawCard() {
        this.drawCardOutline();
        switch (this.color) {
            case 0: // red
                StdDraw.setPenColor(255, 51, 51);
                break;
            case 1: // green
                StdDraw.setPenColor(29, 176, 88);
                break;
            case 2: // purple
                StdDraw.setPenColor(65, 43, 145);
                break;
            default:
                break;
        }
        switch (this.count) {
            case 0:
                drawOne(loc, shape, fill);
                break;
            case 1:
                drawTwo(loc, shape, fill);
                break;
            case 2:
                drawThree(loc, shape, fill);
                break;
            default:
                break;
        }
    }

    private static Point indexToPoint(int b) {
        int i = (int) Math.floor((float) b / 3);
        int j = b % 3;
        // x-point scales by less than BOARD_X_DIM + 1 to spread cards out.
        // Then subtract 0.1 to shift all cards left.
        return new Point((float) (i + 1) / (Game.BOARD_X_DIM + 0.15) - 0.1025,
                        (float) (j + 1) / (Game.BOARD_Y_DIM + 0.7) + 0.05);
    }

    public void drawCardOutline() {
        double[] xInd = new double[]{northWest.getX(), northEast.getX(),
                southEast.getX(), southWest.getX()};
        double[] yInd = new double[]{northWest.getY(), northEast.getY(),
                southEast.getY(), southWest.getY()};
        StdDraw.polygon(xInd, yInd);
    }

    private static void drawOne(Point p, int shape, int fill) {
        switch (shape) {
            case 0:
                Card.drawOval(p, fill);
                break;
            case 1:
                Card.drawDiamond(p, fill);
                break;
            case 2:
                Card.drawSquiggle(p, fill);
                break;
            default:
                break;
        }
    }

    private static void drawTwo(Point p, int shape, int fill) {
        Point left = new Point(p.getX() - 0.03, p.getY());
        Point right = new Point(p.getX() + 0.03, p.getY());
        switch (shape) {
            case 0:
                Card.drawOval(left, fill);
                Card.drawOval(right, fill);
                break;
            case 1:
                Card.drawDiamond(left, fill);
                Card.drawDiamond(right, fill);
                break;
            case 2:
                Card.drawSquiggle(left, fill);
                Card.drawSquiggle(right, fill);
                break;
            default:
                break;
        }
    }

    private static void drawThree(Point p, int shape, int fill) {
        Point left = new Point(p.getX() - 0.06, p.getY());
        Point right = new Point(p.getX() + 0.06, p.getY());
        switch (shape) {
            case 0:
                Card.drawOval(left, fill);
                Card.drawOval(right, fill);
                Card.drawOval(p, fill);
                break;
            case 1:
                Card.drawDiamond(left, fill);
                Card.drawDiamond(right, fill);
                Card.drawDiamond(p, fill);
                break;
            case 2:
                Card.drawSquiggle(left, fill);
                Card.drawSquiggle(right, fill);
                Card.drawSquiggle(p, fill);
                break;
            default:
                break;
        }
    }

    private static void drawDiamond(Point p, int fill) {
        Point west = new Point(p.getX() - 0.025, p.getY());
        Point north = new Point(p.getX(), p.getY() + 0.075);
        Point east = new Point(p.getX() + 0.025, p.getY());
        Point south = new Point(p.getX(), p.getY() - 0.075);
        double[] xInd = new double[]{west.getX(), north.getX(), east.getX(), south.getX()};
        double[] yInd = new double[]{west.getY(), north.getY(), east.getY(), south.getY()};
        switch (fill) {
            case 0:
                StdDraw.polygon(xInd, yInd);
                break;
            case 1:
                StdDraw.polygon(xInd, yInd);
                Point westNorthNorth = new Point(p.getX() - 0.0083, p.getY() + 0.0501);
                Point westNorth = new Point(p.getX() - 0.0166, p.getY() + 0.0252);
                Point westSouth = new Point(p.getX() - 0.0166, p.getY() - 0.0252);
                Point westSouthSouth = new Point(p.getX() - 0.0083, p.getY() - 0.0501);
                Point eastNorthNorth = new Point(p.getX() + 0.0083, p.getY() + 0.0501);
                Point eastNorth = new Point(p.getX() + 0.0166, p.getY() + 0.0252);
                Point eastSouth = new Point(p.getX() + 0.0166, p.getY() - 0.0252);
                Point eastSouthSouth = new Point(p.getX() + 0.0083, p.getY() - 0.0501);
                StdDraw.line(westNorthNorth.getX(), westNorthNorth.getY(),
                        eastNorthNorth.getX(), eastNorthNorth.getY());
                StdDraw.line(westNorth.getX(), westNorth.getY(),
                        eastNorth.getX(), eastNorth.getY());
                StdDraw.line(west.getX(), west.getY(), east.getX(), east.getY());
                StdDraw.line(westSouth.getX(), westSouth.getY(),
                        eastSouth.getX(), eastSouth.getY());
                StdDraw.line(westSouthSouth.getX(), westSouthSouth.getY(),
                        eastSouthSouth.getX(), eastSouthSouth.getY());
                break;
            case 2:
                StdDraw.filledPolygon(xInd, yInd);
                break;
            default:
                break;
        }
    }

    private static void drawOval(Point p, int fill) {
        switch (fill) {
            case 0:
                StdDraw.ellipse(p.getX(), p.getY(), 0.025, 0.075);
                break;
            case 1:
                Point westNorth = Util.ellipseEquationPos(-0.0166, p.getX(), p.getY());
                Point westKindaNorth = Util.ellipseEquationPos(-0.023, p.getX(), p.getY());
                Point west = Util.ellipseEquationPos(-0.025, p.getX(), p.getY());
                Point westKindaSouth = Util.ellipseEquationNeg(-0.023, p.getX(), p.getY());
                Point westSouth = Util.ellipseEquationNeg(-0.0166, p.getX(), p.getY());
                Point eastNorth = Util.ellipseEquationPos(0.0166, p.getX(), p.getY());
                Point eastKindaNorth = Util.ellipseEquationPos(0.023, p.getX(), p.getY());
                Point east = Util.ellipseEquationNeg(0.025, p.getX(), p.getY());
                Point eastKindaSouth = Util.ellipseEquationNeg(0.023, p.getX(), p.getY());
                Point eastSouth = Util.ellipseEquationNeg(0.0166, p.getX(), p.getY());
                StdDraw.ellipse(p.getX(), p.getY(), 0.025, 0.075);
                StdDraw.line(westNorth.getX(), westNorth.getY(),
                        eastNorth.getX(), eastNorth.getY());
                StdDraw.line(west.getX(), west.getY(), east.getX(), east.getY());
                StdDraw.line(westSouth.getX(), westSouth.getY(),
                        eastSouth.getX(), eastSouth.getY());
                StdDraw.line(westKindaNorth.getX(), westKindaNorth.getY(),
                        eastKindaNorth.getX(), eastKindaNorth.getY());
                StdDraw.line(westKindaSouth.getX(), westKindaSouth.getY(),
                        eastKindaSouth.getX(), eastKindaSouth.getY());
                break;
            case 2:
                StdDraw.filledEllipse(p.getX(), p.getY(), 0.025, 0.075);
                break;
            default:
                break;
        }
    }

    private static void drawSquiggle(Point p, int fill) {
        Point northWest = new Point(p.getX() - 0.01, p.getY() + 0.075);
        Point southEast = new Point(p.getX() + 0.01, p.getY() - 0.075);
        Point east = new Point(p.getX() + 0.015, p.getY() + 0.01);
        Point eastSouth = new Point(p.getX() + 0.0025, p.getY() - 0.02);
        Point west = new Point(p.getX() - 0.015, p.getY() - 0.01);
        Point westNorth = new Point(p.getX() - 0.0025, p.getY() + 0.02);
        double[] xInd = new double[]{northWest.getX(), east.getX(), eastSouth.getX(),
                southEast.getX(), west.getX(), westNorth.getX()};
        double[] yInd = new double[]{northWest.getY(), east.getY(), eastSouth.getY(),
                southEast.getY(), west.getY(), westNorth.getY()};
        switch (fill) {
            case 0:
                StdDraw.polygon(xInd, yInd);
                break;
            case 1:
                StdDraw.polygon(xInd, yInd);
                StdDraw.line(westNorth.getX(), westNorth.getY(), p.getX() + 0.01, westNorth.getY());
                StdDraw.line(p.getX() - 0.01, eastSouth.getY(), eastSouth.getX(), eastSouth.getY());
                StdDraw.line(p.getX() - 0.01, p.getY(), p.getX() + 0.01, p.getY());
                StdDraw.line(p.getX() - 0.005, p.getY() + 0.04, p.getX() + 0.004, p.getY() + 0.04);
                StdDraw.line(p.getX() - 0.003, p.getY() - 0.04, p.getX() + 0.005, p.getY() - 0.04);
                break;
            case 2:
                StdDraw.filledPolygon(xInd, yInd);
                break;
            default:
                break;

        }
    }

    public double getLeftBound() {
        return northWest.getX();
    }

    public double getUpperBound() {
        return northWest.getY();
    }

    public double getLowerBound() {
        return southEast.getY();
    }

    public double getRightBound() {
        return southEast.getX();
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

    public void borderHighlight() {
        if (!highlighted) {
            StdDraw.setPenColor(StdDraw.MAGENTA);
            StdDraw.setPenRadius(0.01);
            this.drawCardOutline();
            highlighted = true;
            StdDraw.show();
        } else {
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.setPenRadius(0.015);
            this.drawCardOutline();
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.setPenRadius(0.005);
            this.drawCardOutline();
            highlighted = false;
            StdDraw.show();
        }
    }

    @Override
    public boolean equals(Object obj) {
        Card a = (Card) obj;
        return  a.color == this.color && a.fill == this.fill
                && a.shape == this.shape && a.count == this.count;
    }

    @Override
    public int hashCode() {
        return (int) ((this.color * Math.pow(3, 4)) + (this.fill * Math.pow(3, 3))
                + (this.shape * Math.pow(3, 2)) + (this.count * 3));
    }

    public static String toString(Card c) {
        return Integer.toString(c.color) + c.fill + c.shape + c.count;
    }

    public static void main(String[] args) {
        StdDraw.setCanvasSize(1200, 600);
        StdDraw.setPenRadius(0.01);
        Game game = new Game();
    }
}
