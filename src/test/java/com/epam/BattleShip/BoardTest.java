package com.epam.BattleShip;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BoardTest {
    private Board board;

    @Before
    public void setup() {
        board = new Board();
    }
    @Test
    public void generateShipsTest() {

        int fourth = 4;
        int third = 6;
        int second = 6;
        int first = 4;

        for (int i = 0; i < board.getInsideBoard().length; i++) {
            for (int j = 0; j < board.getInsideBoard().length; j++) {
                if (board.getInsideBoard()[i][j] == 4) {
                    fourth--;
                }
                if (board.getInsideBoard()[i][j] == 3) {
                    third--;
                }
                if (board.getInsideBoard()[i][j] == 2) {
                    second--;
                }
                if (board.getInsideBoard()[i][j] == 1) {
                    first--;
                }
            }
        }
        Assert.assertEquals(0, first);
        Assert.assertEquals(0, second);
        Assert.assertEquals(0, third);
        Assert.assertEquals(0, fourth);

    }

    @Test
    public void copyInsideArrayTest() {
        int[][] arr = board.copyInsideArray();
        for (int i = 0; i < board.getInsideBoard().length; i++) {
            for (int j = 0; j < board.getInsideBoard().length; j++) {
                Assert.assertEquals(arr[i][j], board.getInsideBoard()[i][j]);
            }
        }
        Assert.assertEquals(arr, board.getInsideBoard());
    }
    @Test
    public void degradableShipTest() {
        int cell = 100;
        for (int i = 0; i < board.getInsideBoard().length; i++) {
            for (int j = 0; j < board.getInsideBoard().length; j++) {
                if (board.getInsideBoard()[i][j] == 4) {
                    board.degradableShip(i, j);
                    cell =  board.getInsideBoard()[i][j];
                }
            }
        }
        Assert.assertEquals(3, cell);
    }
}
