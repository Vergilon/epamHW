package com.epam.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of array sorting by radixsort (LSD) method
 *
 * @author Roman Moderatov
 * @version 1.0
 * @since 1.8
 */
public class RadixSort {

    /**
     * This method sorts an array comparing the individual digits
     * @param input not sorted array
     */
    private void radixSort(int[] input) {

        List<Integer>[] buckets = new ArrayList[10];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        boolean flag = false;
        int tmp = -1;
        int divisor = 1;
        while (!flag) {
            flag = true;
            for (Integer i : input) {
                tmp = i / divisor;
                buckets[tmp % 10].add(i);
                if (flag && tmp > 0) {
                    flag = false;
                }
            }
            int a = 0;
            for (int b = 0; b < 10; b++) {
                for (Integer i : buckets[b]) {
                    input[a++] = i;
                }
                buckets[b].clear();
            }
            divisor *= 10;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{100, 154, 187, 289, 458, 987, 45};
        RadixSort rs = new RadixSort();
        rs.radixSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
