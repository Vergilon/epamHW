package com.epam.BattleShip;

import java.util.Arrays;
import java.util.Random;

class Board {

    private int[][] insideBoard = new int[12][12];
    private char[][] ninjaBoard = new char[12][12];
    private int[][] stabilityInsideBoard = new int[12][12];

    public int[][] getStabilityInsideBoard() {
        return stabilityInsideBoard;
    }

    public void setStabilityInsideBoard(int[][] stabilityInsideBoard) {
        this.stabilityInsideBoard = stabilityInsideBoard;
    }

    public int[][] getInsideBoard() {
        return insideBoard;
    }

    public char[][] getNinjaBoard() {
        return ninjaBoard;
    }

    /**
     * Board constructor. Generate special edge for board (letters and number axis).
     */
    Board() {
        for (int i = 1; i < getInsideBoard().length - 1; i++) {
            for (int j = 1; j < getInsideBoard().length - 1; j++) {
                getInsideBoard()[i][j] = 0;
                getNinjaBoard()[i][j] = '.';
            }
        }
        generateShips();
        for (int i = 0; i < 11; i++) {
            getNinjaBoard()[0][i + 1] = Character.forDigit(i, 10);
        }
        char[] c = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};
        int ini = 1;
        for (char sy : c) {
            getNinjaBoard()[ini][0] = sy;
            ini++;
        }
    }

    /**
     * Display ninjaBoard for players.
     */
    void showNinjaBoard() {
        for (int i = 0; i < getNinjaBoard().length - 1; i++) {
            for (int j = 0; j < getNinjaBoard().length - 1; j++) {
                System.out.print(getNinjaBoard()[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    /**
     * Checker for freedom cells around hypothetically ships cells.
     *
     * @param x   is X axis cells value
     * @param y   is Y axis cells value
     * @param brd board
     * @return boolean result
     */
    private boolean isFreedom(int x, int y, int[][] brd) {
        int[][] field = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}};
        int dx, dy;
        if ((x >= 1) && (x < 11) && (y >= 1) && (y < 11) && (brd[x][y] == 0)) {
            for (int i = 0; i < 8; i++) {
                dx = x + field[i][0];
                dy = y + field[i][1];
                if ((dx >= 1) && (dx < 11) && (dy >= 1) && (dy < 11) && (brd[dx][dy] > 0)) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method reduces the values of the cells in which the ship is located,
     * which allows to determine the degree of damage to the ship.
     *
     * @param x is X axis cells value
     * @param y is Y axis cells value
     */
    void degradableShip(int x, int y) {
        if (getInsideBoard()[x][y] != 0) {
            getInsideBoard()[x][y]--;
            if (getInsideBoard()[x][y + 1] != 0) {
                getInsideBoard()[x][y + 1]--;
                if (getInsideBoard()[x][y + 2] != 0) {
                    getInsideBoard()[x][y + 2]--;
                    if (getInsideBoard()[x][y + 3] != 0) {
                        getInsideBoard()[x][y + 3]--;
                        return;
                    }
                }
            }
            if (getInsideBoard()[x][y - 1] != 0) {
                getInsideBoard()[x][y - 1]--;
                if (getInsideBoard()[x][y - 2] != 0) {
                    getInsideBoard()[x][y - 2]--;
                    if (getInsideBoard()[x][y - 3] != 0) {
                        getInsideBoard()[x][y - 3]--;
                        return;
                    }
                }
            }

            if (getInsideBoard()[x + 1][y] != 0) {
                getInsideBoard()[x + 1][y]--;
                if (getInsideBoard()[x + 2][y] != 0) {
                    getInsideBoard()[x + 2][y]--;
                    if (getInsideBoard()[x + 3][y] != 0) {
                        getInsideBoard()[x + 3][y]--;
                        return;
                    }
                }
            }

            if (getInsideBoard()[x - 1][y] != 0) {
                getInsideBoard()[x - 1][y]--;
                if (getInsideBoard()[x - 2][y] != 0) {
                    getInsideBoard()[x - 2][y]--;
                    if (getInsideBoard()[x - 3][y] != 0) {
                        getInsideBoard()[x - 3][y]--;
                    }
                }
            }
        }

    }

    /**
     * Method generate random number in input limit.
     *
     * @param min value of minimal number
     * @param max value of maximal number
     * @return number in range of min and max
     */
    int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    /**
     * Methods for random ships generating.
     */
    private void generateShips() {
        boolean b;
        int kx, ky;
        for (int n = 3; n >= 0; n--) {
            for (int m = 0; m <= 3 - n; m++) {
                do {
                    Random random = new Random();
                    int x = getRandomNumberInRange(1, 11);
                    int y = getRandomNumberInRange(1, 11);
                    kx = random.nextInt(2);
                    if (kx == 0) {
                        ky = 1;
                    } else {
                        ky = 0;
                    }
                    b = true;
                    for (int i = 0; i <= n; i++) {
                        if (!isFreedom(x + kx * i, y + ky * i, getInsideBoard())) {
                            b = false;
                        }
                    }
                    if (b) {
                        for (int j = 0; j <= n; j++) {
                            getInsideBoard()[x + kx * j][y + ky * j] = n + 1;
                        }
                    }
                } while (!b);
            }
        }
        setStabilityInsideBoard(copyInsideArray());
    }

    /**
     * Method for to copy matrix.
     *
     * @return copy of matrix
     */
    private int[][] copyInsideArray() {
        int[][] arr = Arrays.copyOf(getInsideBoard(), getInsideBoard().length);
        for (int i = 0; i < getInsideBoard().length; i++) {
            arr[i] = Arrays.copyOf(getInsideBoard()[i], getInsideBoard()[i].length);
        }
        return arr;
    }
}
