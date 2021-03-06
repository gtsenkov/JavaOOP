package WorkingWithAbstractionLab.PointInRectangle;

public class Rectangle {
    private Point bottomLeft;
    private Point topRight;

    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public Point getBottomLeft() {
        return bottomLeft;
    }

    public Point getTopRight() {
        return topRight;
    }

    public boolean Contains(Point pointToCheck) {
        return this.bottomLeft.isGreaterOrEqual(pointToCheck)
                && this.topRight.isLessOrEqual(pointToCheck);
    }

}
