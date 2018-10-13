package com.epam.lesson1;

/**
 * Simulation traffic light signal for a determined minute
 * Rule traffic light:
 * first 2 minutes - red light
 * after 3 minutes - yellow light
 * after 5 minutes - green light
 *
 * @author Roman Moderatov
 * @version 1.0
 * @since 1.8
 */
public class TrafficLight {
    private int timePerMinutes;

    /**
     * @param timePerMinutes need more than zero
     * @throws IllegalArgumentException if x is less then 0
     */
    public void setLight(int timePerMinutes) {
        if (timePerMinutes < 0) {
            throw new IllegalArgumentException("Number must be positive");
        }
        this.timePerMinutes = timePerMinutes % 10;
    }

    /**
     * Check color using condition
     *
     * @return color traffic light in determined minute
     */
    public String getLight() {
        if (timePerMinutes == 0 || timePerMinutes == 1) {
            return "Red";
        }
        return timePerMinutes <= 4 ? "Yellow" : "Green";
    }

    public TrafficLight(int timePerMinutes) {
        setLight(timePerMinutes);
    }
}

