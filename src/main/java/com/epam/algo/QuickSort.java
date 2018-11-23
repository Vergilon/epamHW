package com.epam.algo;

/**
 * Implementation of array sorting by quicksort method
 *
 * @author Roman Moderatov
 * @version 1.0
 * @since 1.8
 */
public class QuickSort {

    /**
     * Divide and sort part of array relative pivot
     * @param arr input array
     * @param low minimal index in input array
     * @param high maximal index in input array
     */
    private void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int div = divide(arr, low, high);
            quickSort(arr, low, div - 1);
            quickSort(arr, div + 1, high);
        }
    }

    /**
     * Pick last element as pivot
     * @param arr input array
     * @param low minimal index in input array
     * @param high maximal index in input array
     * @return pivot element
     */
    private int divide(int arr[], int low, int high) {
        int point = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] <= point) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void main(String args[]) {
        int arr[] = {3, 40, 18, 25, 14, 20, 21};
        QuickSort qs = new QuickSort();
        qs.quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }

    }
}
