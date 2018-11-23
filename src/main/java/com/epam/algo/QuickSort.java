package com.epam.algo;

public class QuickSort {

    private void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int div = divide(arr, low, high);
            quickSort(arr, low, div - 1);
            quickSort(arr, div + 1, high);
        }
    }

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
