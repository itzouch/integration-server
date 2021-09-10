package com.zouch.algorithm;

/**
 * @author Zouch
 * @date 2021/8/25 8:14
 * @description
 */
public class IntegerRevise {

    public static int revise(int x) {
        if (x == 0) {
            return x;
        }
        String s = String.valueOf(x);
        while (s.endsWith("0")) {
            s = s.substring(0, s.length() - 1);
        }
        char[] chars = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            stringBuilder.append(chars[i]);
        }
        String result = new String(stringBuilder);
        boolean flag = false;
        if (result.endsWith("-")) {
            result = result.substring(0, s.length() - 1);
            flag = true;
        }
        result.trim();
        return flag == true ? (-Integer.parseInt(result)) : Integer.parseInt(result);
    }

    public static String delete0(String s) {
        if (s.endsWith("0")) {
            s = s.substring(0, s.length() - 2);
            delete0(s);
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(revise(123));
    }
}