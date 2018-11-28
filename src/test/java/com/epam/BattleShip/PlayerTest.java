package com.epam.BattleShip;

import org.junit.Assert;
import org.junit.Test;

public class PlayerTest {

    Player player = new Player("Test");

    @Test
    public void shotTest() {
        int[][] arr = (player.getBoard().copyInsideArray());
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == 4) {
                    Assert.assertTrue(player.isDamage(i, j));
                }
                if (arr[i][j] == 1) {
                    player.getBoard().degradableShip(i, j);
                    Assert.assertTrue(player.isKill(i, j));
                }
                if (arr[i][j] == 0) {
                    Assert.assertTrue(player.isMiss(i, j));
                }
            }
        }
    }

    @Test
    public void isWinTest() {
        Assert.assertFalse(player.isWin());
        player.setPoint(0);
        Assert.assertTrue(player.isWin());
    }

}
