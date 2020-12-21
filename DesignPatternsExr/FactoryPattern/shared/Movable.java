package DesignPatternsExr.FactoryPattern.shared;

public interface Movable {

    int getRow();

    int getCol();

    void decreaseRow();
    void increaseRow();
    void decreaseCol();
    void increaseCol();
}
