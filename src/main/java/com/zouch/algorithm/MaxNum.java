package com.zouch.algorithm;

/**
 * @author Zouch
 * @date 2021/10/11 17:41
 * @description [-1,9,-8,10,19]求和最大的连续子序列
 */
public class MaxNum {


    public static int[] getMax(int[] targetArray){

        int start = 0;
        int end = 0;
        int max = 0;
        for (int i = 0; i < targetArray.length; i++) {
            if (max+targetArray[i]>0){
                end=i;
            }else {
                start = i+1;
            }
        }
        System.out.println(start+"---"+end);
        return null;

    }


    public static void main(String[] args) {
        getMax(new int[]{-1,9,-8,10,19});
    }
}