package com.epam.BattleShip;

public class Computer extends Gamer {

    private int x;
    private int y;

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

    Computer(String name) {
        super(name);
        setX(0);
        setY(0);

    }

    void autoShot() {
        setX(getBoard().getRandomNumberInRange(1, 11));
        setY(getBoard().getRandomNumberInRange(1, 11));

        if (!isRepeat(getX(), getY())) {
            shot(getX(), getY());
            if (isDamage(getX(), getY()) || isKill(getX(), getY())) {
                autoShot();
            }
        }

    }
}
