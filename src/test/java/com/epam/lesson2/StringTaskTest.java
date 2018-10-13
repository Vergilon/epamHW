package com.epam.lesson2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * StringTaskTest description.
 *
 * @author Roman Moderatov
 * @version 1.0
 * @since 1.8
 */
public class StringTaskTest {
    StringTask st;

    @Before
    public void initialize(){
        st = new StringTask("Lorem ipsum dolor sit amettret");
    }

    @Test
    public void getThirdCharTest(){
        Assert.assertEquals('r', st.getThirdChar());
    }

    @Test
    public void getLastCharTest() {
        Assert.assertEquals('t', st.getLastChar());
    }

    @Test
    public void getKthCharTest() {
        Assert.assertEquals('d', st.getKthChar(13));
        Assert.assertEquals('o', st.getKthChar(2));
    }

    @Test
    public void getSameNeighborsTest() {
        Assert.assertEquals(1, st.getSameNeighbors());
    }

    @Test
    public void swapSecondAndFifthTest() {
        Assert.assertEquals("Lmreo ipsum dolor sit amettret", st.swapSecondAndFifth());
    }

    @Test
    public void reverseStringTest() {
        Assert.assertEquals("terttema tis rolod muspi meroL", st.reverseString());
    }
}
