package com.epam.algo;

import java.util.Arrays;

/**
 * Implementation of array sorting by mergesort method
 *
 * @author Roman Moderatov
 * @version 1.0
 * @since 1.8
 */
public class MergeSort {

    /**
     * Method divide array to two part
     * @param massive input array
     * @return sort array
     */
    private int[] mergeSort(int[] massive) {
        if (massive.length == 1) {
            return massive;
        }
        int mid_point = massive.length / 2;
        return merge(mergeSort(Arrays.copyOfRange(massive, 0, mid_point)), mergeSort(Arrays.copyOfRange(massive, mid_point, massive.length)));
    }

    /**
     * Method combines two arrays in such a way that the result is a single sort array
     * @param left first array
     * @param right second array
     * @return sort result array
     */
    private int[] merge(int[] left, int[] right) {
        int a = 0, b = 0;
        int[] merged = new int[left.length + right.length];
        for (int i = 0; i < left.length + right.length; i++) {
            if (b < right.length && a < left.length) {
                if (left[a] > right[b]) {
                    merged[i] = right[b++];
                } else {
                    merged[i] = left[a++];
                }
            } else if (b < right.length) {
                merged[i] = right[b++];
            } else {
                merged[i] = left[a++];
            }
        }
        return merged;
    }

    public static void main(String args[]) {
        int arr[] = {3, 40, 18, 25, 14, 20, 21};
        MergeSort ms = new MergeSort();
        arr = ms.mergeSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
