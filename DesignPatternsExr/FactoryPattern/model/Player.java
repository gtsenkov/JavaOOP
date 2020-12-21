package DesignPatternsExr.FactoryPattern.model;

import DesignPatternsExr.FactoryPattern.core.Main;
import DesignPatternsExr.FactoryPattern.shared.Factory;
import DesignPatternsExr.FactoryPattern.shared.Movable;

import java.util.concurrent.ThreadLocalRandom;

public class Player implements GameObject, Movable {
    private int healthPoints;
    private int damage;
    private int row;
    private int col;
    private int prevRow;
    private int prevCol;
    private Factory stoneFactory;

    public Player(int healthPoints, int damage) {
        this.healthPoints = healthPoints;
        this.damage = damage;
        this.row = 15;
        this.col = 7;
        this.prevRow = 15;
        this.prevCol = 7;
        this.stoneFactory = new StoneFactory();
    }


    @Override
    public void update() {
//        int nextInt = ThreadLocalRandom.current().nextInt(1000);
//
//        if (nextInt % 3 == 0) {
//            Main.gameObjects.add(this.factory.produce());
//        } else if (nextInt % 7 == 0) {
//            Main.gameObjects.removeIf(g -> g.getClass().getSimpleName().equals("Stone"));
//        }

    }

    @Override
    public void draw() {
        Main.field.field[this.prevRow][this.prevCol] = '-';
        Main.field.field[this.row][this.col] = 'P';
    }

    @Override
    public int getRow() {
        return this.row;
    }

    @Override
    public int getCol() {
        return this.col;
    }

    @Override
    public void decreaseRow() {
        if (this.row > 0) {
            prevRow = this.row;
            prevCol = this.col;
            this.row--;
        }
    }

    @Override
    public void increaseRow() {
        if (this.row < 15) {
            prevRow = this.row;
            prevCol = this.col;
            this.row++;
        }
    }

    @Override
    public void decreaseCol() {
        if (this.col > 0) {
            prevRow = this.row;
            prevCol = this.col;
            this.col--;
        }

    }

    @Override
    public void increaseCol() {
        if (this.col < 15) {
            prevRow = this.row;
            prevCol = this.col;
            this.col++;
        }
    }


    public void throwStone() {
        Main.gameObjects.add(stoneFactory.produce());
    }
}
