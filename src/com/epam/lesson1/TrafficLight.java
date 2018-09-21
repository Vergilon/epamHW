package com.epam.lesson1;

/**
 * Simulation traffic light signal for a determined minute
 *
 * @author Roman Moderatov
 * @version 1.0
 * @since 1.8
 */
public class TrafficLight {
    private int light;

    /**
     * @param x need more than zero
     * @throws IllegalArgumentException
     *         if x is less then 0
     */
    public void setLight(int x) {
        if (x < 0) {
            throw new IllegalArgumentException("Number must is not less then 0");
        }
        this.light = x % 10;
    }

    public TrafficLight(int x) {
        setLight(x);
    }

    /**
     * Check color using condition
     * @return color traffic light in deteminated minute
     */
    public String getLight() {
        if (light == 0 || light == 1) {
            return "Red";
        }
        return light <= 4 ? "Yellow" : "Green";
    }
}

