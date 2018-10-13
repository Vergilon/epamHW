package com.epam.lesson1;

import org.junit.Assert;
import org.junit.Test;

/**
 * TrafficLightTest description.
 *
 * @author Roman Moderatov
 * @version 1.0
 * @since 1.8
 */
public class TrafficLightTest {

    TrafficLight tl = new TrafficLight(1);

    @Test
    public void getLightTest() {
        Assert.assertEquals("Red", tl.getLight());
    }

    @Test
    public void setLightTest() {
        tl.setLight(14);
        Assert.assertEquals("Yellow", tl.getLight());
        tl.setLight(17);
        Assert.assertEquals("Green", tl.getLight());
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentExceptionSetLightTest() {
        TrafficLight test = new TrafficLight(1);
        test.setLight(-4);
    }
}
