package com.zouch.algorithm;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Zouch
 * @date 2021/7/14 22:14
 * @description 合并递增数组找中位数
 */
public class Median {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        List<Integer> result = new ArrayList<>(nums1.length+nums2.length);
        for (int i : nums1) {
            result.add(i);
        }
        for (int i:nums2){
            result.add(i);
        }
        Collections.sort(result);
        int medianIndex;
        double median ;
        if (result.size() % 2 == 0) {
            medianIndex = result.size()/ 2;
            median = (result.get(medianIndex)+result.get(medianIndex-1)+0.0)/2;
        } else {
            medianIndex = (result.size()-1) / 2;
            median = result.get(medianIndex);
        }
        return median;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 3};
        int[] b = new int[]{ 2};
        List<Integer> collect = Stream.concat(Arrays.stream(a).boxed(), Arrays.stream(b).boxed()).collect(Collectors.toList());
        System.out.println(collect.toString());


//        Median median = new Median();
//        System.out.println(median.findMedianSortedArrays(a, b));
    }
}