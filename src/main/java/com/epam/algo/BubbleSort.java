package com.epam.algo;

public class BubbleSort {

    private void bubbleSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] test = new int[]{5, 12, 15, 48, 1};
        BubbleSort bb = new BubbleSort();
        bb.bubbleSort(test);
        for (int aTest : test) {
            System.out.print(aTest + " ");
        }
    }
}
