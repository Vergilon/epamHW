package com.epam.BattleShip;

import java.util.Random;

public class Board {

    private int[][] insideBoard = new int[12][12];
    private char[][] ninjaBoard = new char[12][12];

    public int[][] getInsideBoard() {
        return insideBoard;
    }

    public char[][] getNinjaBoard() {
        return ninjaBoard;
    }

    Board() {
        for (int i = 1; i < getInsideBoard().length - 1; i++) {
            for (int j = 1; j < getInsideBoard().length - 1; j++) {
                getInsideBoard()[i][j] = 0;
                getNinjaBoard()[i][j] = '.';
            }
        }
        generateShips();

        String[] str = new String[]{};
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

    void showBoard() {
        for (int i = 1; i < getInsideBoard().length - 1; i++) {
            for (int j = 1; j < getInsideBoard().length - 1; j++) {
                System.out.print(getInsideBoard()[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    void showNinjaBoard() {
        for (int i = 0; i < getNinjaBoard().length - 1; i++) {
            for (int j = 0; j < getNinjaBoard().length - 1; j++) {
                System.out.print(getNinjaBoard()[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    boolean isFreedom(int x, int y, int[][] brd) {
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

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    void generateShips() {
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
    }
}
