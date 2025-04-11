package org.example;

public class Size {
    private final double length;
    private final double width;
    private final double height;

    public Size(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public boolean canFit(Size other) {
        return this.length >= other.length &&
                this.width >= other.width &&
                this.height >= other.height;
    }

    @Override
    public String toString() {
        return "(" + length + " x " + width + " x " + height + ")";
    }
}
