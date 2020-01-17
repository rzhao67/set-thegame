package setgame;

public class ClickObject {
    private double x;
    private double y;
    private double halfWidth;
    private double halfHeight;

    ClickObject(double x, double y, double halfWidth, double halfHeight) {
        this.x = x;
        this.y = y;
        this.halfWidth = halfWidth;
        this.halfHeight = halfHeight;
    }

    public boolean isClickedOn(double a, double b) {
        return (a > (x - halfWidth) && (a < (x + halfWidth)))
                && ((b > (y - halfHeight)) && (b < (y + halfHeight)));
    }
}
