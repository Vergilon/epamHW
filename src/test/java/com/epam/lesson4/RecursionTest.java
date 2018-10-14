package com.epam.lesson4;

import org.junit.Assert;
import org.junit.Test;

/**
 * RecursionTest description.
 *
 * @author Roman Moderatov
 * @version 1.0
 * @since 1.8
 */
public class RecursionTest {

    Recursion r = new Recursion();

    @Test
    public void getFactorialTest() {
        Assert.assertEquals(120, r.getFactorial(5));
    }

    @Test
    public void getPowTest() {
        Assert.assertEquals(512d, r.getPow(2, 9), 0.000001);
    }

    @Test
    public void digitOrderNumberSumTest() {
        Assert.assertEquals(18, r.digitOrderNumberSum(981));
        Assert.assertEquals(27, r.digitOrderNumberSum(999));
    }

    @Test
    public void digitOrderNumberCountTest() {
        Assert.assertEquals(3, r.digitOrderNumberCount(981));
        Assert.assertEquals(4, r.digitOrderNumberCount(1874));
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentExceptionGetFactorialTest() {
        r.getFactorial(-100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentExceptionGetPowTest() {
        r.getPow(2, -100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentExceptionDigitOrderNumberSumTest() {
        r.digitOrderNumberSum(-100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentExceptionDigitOrderNumberCountTest() {
        r.digitOrderNumberCount(-100);
    }
}
