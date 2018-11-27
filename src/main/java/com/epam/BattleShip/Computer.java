package com.epam.BattleShip;

public class Computer extends Player {

    private int x;
    private int y;
    private DifficultStrategy dif;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    Computer(String name, DifficultStrategy dif) {
        super(name);
        this.dif = dif;

    }

    boolean computerShot() {
        return dif.shot(this);
    }
}
