package DesignPatternsLab.PrototypePattern;

public class Chair implements Prototype{
    private int height;
    private int width;
    private String color;

    public Chair(int height, int width, String color) {
        this.height = height;
        this.width = width;
        this.color = color;
    }

    private Chair(Chair chair) {
        this.height = chair.height;
        this.width = chair.width;
        this.color = chair.color;
        //this is called copy construction
    }

    @Override
    public Chair clone() {
        return new Chair(this);
    }
}
