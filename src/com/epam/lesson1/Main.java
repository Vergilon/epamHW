package com.epam.lesson1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Main class for working with traffic light
 *
 * @author Roman Moderatov
 * @version 1.0
 * @since 1.8
 */
public class Main {

    public static void main(String[] args) throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int x = Integer.parseInt(reader.readLine());
            TrafficLight trafficLight = new TrafficLight(x);
            System.out.println(trafficLight.getLight());
        } catch (NumberFormatException ex) {
            System.out.println("Not a number");
        }
    }
}
