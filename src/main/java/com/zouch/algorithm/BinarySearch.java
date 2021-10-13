package com.zouch.algorithm;

/**
 * @author Zouch
 * @date 2021/10/13 22:33
 * @description 折半查找
 */
public class BinarySearch {

    public static int getElement(int[] array, int l,int r, int i) {
        if (l>r){
            return -1;
        }
        int index = (l+r)/2;
        if (array[index]==i){
            return index;
        }else {
            if (array[index]>i){
                return getElement(array,l,index-1, i);
            }else {
                return getElement(array,index+1,r,i );
            }
        }

    }

    public static void main(String[] args) {
        int[] array = new int[]{2,4,6,8,20};
        System.out.println(getElement(array,0,4,4));
    }
}