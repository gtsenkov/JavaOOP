package EncapsulationExr.ClassBoxDataValidation;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    private void setLength(double length) {
        if (!isValidDimension(length)) {
            throw new IllegalArgumentException
                    ("Length cannot be zero or negative.");
        }
        this.length = length;
    }

    private void setWidth(double width) {
        if (!isValidDimension(width)) {
            throw new IllegalArgumentException
                    ("Width cannot be zero or negative.");
        }
        this.width = width;
    }

    private void setHeight(double height) {
        if (!isValidDimension(height)) {
            throw new IllegalArgumentException
                    ("Height cannot be zero or negative.");
        }
        this.height = height;
    }

    private boolean isValidDimension(double dimension) {
        if (dimension <= 0) {
            return false;
        }
        return true;
    }

    public double calculateVolume() {
        return length * width * height;
    }

    public double calculateLateralSurfaceArea() {
        return 2 * length * height + 2 * width * height;
    }

    public double calculateSurfaceArea() {
        return this.calculateLateralSurfaceArea() + 2 * length * width;
    }
}
