package com.epam.lesson4;

/**
 * Recursion description.
 *
 * @author Roman Moderatov
 * @version 1.0
 * @since 1.8
 */
public class Recursion {

    /**
     * Method get factorial predetermined number
     * @param number is the number parameter
     * @return factorial of a number
     */
    public int getFactorial(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number must be positive");
        }
        if (number < 2) {
            return 1;
        }
        return number * getFactorial(number - 1);
    }

    /**
     * The method returns number power
     * @param number is the number parameter
     * @param power is the power parameter
     * @return result of raising a number to a power
     */
    public double getPow(double number, int power) {
        if (power < 0) {
            throw new IllegalArgumentException("Number must be positive");
        }
        if (power == 1) {
            return number;
        }
        return number * getPow(number, power - 1);
    }

    /**
     * The method returns sum of digits of the number
     * @param number is the number parameter
     * @return sum of digits of the number
     */
    public int digitOrderNumberSum(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number must be positive");
        }
        if (number / 10 != 0) {
            return number % 10 + digitOrderNumberSum(number / 10);
        }
        return number;
    }

    /**
     * The method returns count of digits of the number
     * @param number is the number parameter
     * @return count of digits of the number
     */
    public int digitOrderNumberCount(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number must be positive");
        }
        if (number / 10 != 0) {
            return 1 + digitOrderNumberCount(number / 10);
        } else {
            return 1;
        }
    }
}
