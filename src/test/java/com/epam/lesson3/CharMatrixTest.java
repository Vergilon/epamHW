package com.epam.lesson3;

import org.junit.Assert;
import org.junit.Test;

/**
 * CharMatrixTest description
 *
 * @author Roman Moderatov
 * @version 1.0
 * @since 1.8
 */
public class CharMatrixTest {
    char[][] test = new char[][]{
        {'+', '*', '0', '*', '+'},
        {'*', '0', '*', '0', '*'},
        {'0', '*', '0', '*', '0'},
        {'*', '0', '*', '0', '*'},
        {'-', '*', '0', '*', '-'}
    };
    CharMatrix cm = new CharMatrix(test);

    @Test
    public void getEdgeStringTest() {
        Assert.assertEquals("++--", cm.getEdgeString());
    }

    @Test
    public void getLimitStringTest() {
        Assert.assertEquals("+*0", cm.getLimitString(0, 0, 3));
    }

    @Test
    public void getStringOfRowEvenCharTest() {
        String[] strTest = cm.getStringOfRowEvenChar();
        StringBuilder builder = new StringBuilder();
        for (String s : strTest) {
            builder.append(s);
        }
        String str = new String(builder);
        Assert.assertEquals("+0+***000***-0-", str);
    }

    @Test
    public void getStringOfColumnUnevenCharTest() {
        String[] strTest = cm.getStringOfColumnUnevenChar();
        StringBuilder builder = new StringBuilder();
        for (String s : strTest) {
            builder.append(s);
        }
        String str = new String(builder);
        Assert.assertEquals("**00**00**", str);
    }

    @Test
    public void getCheckerStringTest() {
        Assert.assertEquals("+0+0000000-0-", cm.getCheckerString(true));
        Assert.assertEquals("+0-0000000+0-", cm.getCheckerString(false));
    }

}
