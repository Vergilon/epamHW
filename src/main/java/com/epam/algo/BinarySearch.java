package com.epam.algo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Implementation of searching element in array using binary search
 *
 * @author Roman Moderatov
 * @version 1.0
 * @since 1.8
 */
public class BinarySearch {

    /**
     * This is method that searches for an element in an array.
     * It divides the array in the middle and determines in which
     * of the parts the necessary element is hypothetically locate.
     * @param arr array where this method search element
     * @param firstElement first index of array
     * @param lastElement last index of array
     * @param searchElement
     * @return
     */
    private int binarySearch(int arr[], int firstElement, int lastElement, int searchElement) {
        if (lastElement >= firstElement) {
            int middleElement = firstElement + (lastElement - firstElement) / 2;

            if (arr[middleElement] == searchElement) {
                return middleElement;
            }
            if (arr[middleElement] > searchElement) {
                return binarySearch(arr, firstElement, middleElement - 1, searchElement);
            } else {
                return binarySearch(arr, middleElement + 1, lastElement, searchElement);
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("src.txt"))) {

            String str = reader.readLine();
            String[] str1 = str.split(" ");
            int[] array = new int[str1.length];
            for (int i = 0; i < str1.length; i++) {
                array[i] = Integer.parseInt(str1[i]);
            }
            BinarySearch bb = new BinarySearch();
            int first = 0;
            int last = array.length - 1;
            int t = bb.binarySearch(array, first, last, 8);
            System.out.println(t);
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
