package setgame;

public class Util {
    // Computes point on vertical ellipse (given x-coordinate)
    // with semimajor axis of 0.075 and semiminor axis of 0.025, centered at (h, k)
    public static Point ellipseEquationPos(double x, double h, double k) {
        double y = (Math.sqrt(Math.pow(0.075, 2.0) * (1 - (Math.pow(x, 2) / (Math.pow(0.025, 2.0))))));
        return new Point(x + h, y + k);
    }

    public static Point ellipseEquationNeg(double x, double h, double k) {
        double y = (Math.sqrt(Math.pow(0.075, 2.0) * (1 - (Math.pow(x, 2) / (Math.pow(0.025, 2.0))))));
        return new Point(x + h, k - y);
    }
}
