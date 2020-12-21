package DesignPatternsExr.FactoryPattern.model;

import DesignPatternsExr.FactoryPattern.core.Main;
import DesignPatternsExr.FactoryPattern.shared.Movable;

public class Stone implements GameObject, Movable {
    private int row;
    private int prevRow;
    private int col;

    public Stone() {
        this.row = Main.player.getRow();
        this.prevRow = this.row;
        this.col = Main.player.getCol();
    }

    @Override
    public void update() {
        if (this.row >= 0) {
            this.prevRow = this.row;
            this.row--;
        }
    }

    @Override
    public void draw() {
        if (this.row > -1) {
            Main.field.field[this.prevRow][this.prevRow] = '-';
            Main.field.field[this.row][this.col] = 'S';
        }
    }

    @Override
    public int getRow() {
        return 0;
    }

    @Override
    public int getCol() {
        return 0;
    }

    @Override
    public void decreaseRow() {

    }

    @Override
    public void increaseRow() {

    }

    @Override
    public void decreaseCol() {

    }

    @Override
    public void increaseCol() {

    }
}
