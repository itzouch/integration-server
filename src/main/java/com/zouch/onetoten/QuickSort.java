package com.zouch.onetoten;

import java.util.Arrays;

/**
 * @author Zouch
 * @date 2021/7/22 21:44
 * @description
 */
public class QuickSort {


    public static void sort(int[] array, int left, int right) {
        if (left > right) {
            return;
        }
        int index = array[left];
        int l = left;
        int r = right;
        while (l < r) {
            while (l < r && index <= array[r]) {
                r--;
            }
            array[l] = array[r];

            while (l < r && index >= array[l]) {
                l++;
            }
            array[r] = array[l];
        }
        array[l] = index;
        sort(array, left, l - 1);
        sort(array, l + 1, right);
    }


    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] ints = {1, 5, 1, 6, 23, 8, 9};
        sort(ints, 0, 6);
        System.out.println(Arrays.toString(ints));
    }
}