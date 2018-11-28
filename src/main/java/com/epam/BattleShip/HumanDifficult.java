package com.epam.BattleShip;

public class HumanDifficult implements DifficultStrategy {

    private int u, d, w, e;
    private boolean savepoint = true;
    private Computer computer;

    /**
     * Method for normal difficult shooting. In usual case generate random shot.
     * However, if shot damage ships, method start using "hunt" shooting system.
     * For that, methods have special crosswise algorithm.
     *
     * @param computer is object of Computer class.
     * @return boolean value depending on whether shooting is allowed on this step again.
     */
    @Override
    public boolean shot(Computer computer) {
        this.computer = computer;
        if (savepoint) {
            computer.setX(computer.getBoard().getRandomNumberInRange(1, 10));
            computer.setY(computer.getBoard().getRandomNumberInRange(1, 10));

            int[] a = new int[]{computer.getX(), computer.getY()};
            if (computer.isRepeat(computer.getX(), computer.getY())) {
                shot(computer);
                return false;
            } else {
                computer.shot(a);
                if (computer.isKill(computer.getX(), computer.getY())) {
                    savepoint = true;
                    shot(computer);
                    return false;
                }
                if (computer.isDamage(computer.getX(), computer.getY())) {
                    savepoint = false;
                    upShot(computer.getX(), computer.getY());
                    return false;
                }
                if (computer.isMiss(computer.getX(), computer.getY())) {
                    return false;
                }
            }
            return false;
        } else {
            upShot(computer.getX(), computer.getY());
            return false;
        }
    }

    /**
     * Method created to highlight a common part of the methods of shooting on the sides
     * @param x is X axis cells value
     * @param y is Y axis cells value
     * @param t local counter
     */
    private void specShot(int x, int y, int t)
    {
        int[] a = new int[]{x, y};
        computer.shot(a);
        if (computer.isDamage(x, y - 1)) {
            upShot(x, y - 1);
            t = 0;
        } else {
            t++;
        }
        if (computer.isKill(computer.getX(), computer.getY())) {
            savepoint = true;
            shot(computer);
        }
        if (computer.isMiss(computer.getX(), computer.getY())) {
            return;
        }
    }
    /**
     * Methods for shooting from down to up. Part of crosswise algorithm.
     *
     * @param x is X axis cells value
     * @param y is Y axis cells value
     */
    private void upShot(int x, int y) {
        if (y > 1 && !computer.isRepeat(x, y - 1) && u == 0) {
            specShot(x, y - 1, u);
        } else {
            downShot(x, y + u);
        }
    }

    /**
     * Methods for shooting from up to down. Part of crosswise algorithm.
     *
     * @param x is X axis cells value
     * @param y is Y axis cells value
     */
    private void downShot(int x, int y) {
        if (y < 10 && !computer.isRepeat(x, y + 1) && d == 0) {
            specShot(x, y + 1, d);
        } else {
            rightShot(x, y - d);
        }
    }

    /**
     * Methods for shooting from left to right. Part of crosswise algorithm.
     *
     * @param x is X axis cells value
     * @param y is Y axis cells value
     */
    private void rightShot(int x, int y) {
        if (x < 10 && !computer.isRepeat(x + 1, y) && w == 0) {
            specShot(x + 1, y, w);
        } else {
            leftShot(x - w, y);
        }
    }

    /**
     * Methods for shooting from right to left. Part of crosswise algorithm.
     *
     * @param x is X axis cells value
     * @param y is Y axis cells value
     */
    private void leftShot(int x, int y) {
        if (x > 1 && !computer.isRepeat(x - 1, y) && e == 0) {
            specShot(x - 1, y, e);
        } else {
            savepoint = true;
            shot(computer);
        }
    }
}