package com.zouch.algorithm;

/**
 * @author Zouch
 * @date 2021/10/8 21:35
 * @description 最长回文字串
 */
public class LongestReturnTextString {
    // 思路: 把每个字符都当作中心点 像两边扩散，保留最长的。    借助辅助方法来寻找当前点的最大回文串

    public static String getMaxString(String str) {
        String s = "";

        for (int i = 0; i < str.length(); i++) {
            String currentMaxString = getCurrentMaxString(str, i, i);
            String currentMaxString1 = getCurrentMaxString(str, i, i + 1);
            s = s.length() > currentMaxString.length() ? s : currentMaxString;
            s = s.length() > currentMaxString1.length() ? s : currentMaxString1;
        }
        return s;
    }

    private static String getCurrentMaxString(String s, int left, int right) {
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            } else {
                break;
            }
        }
        return s.substring(left + 1, right);
    }

    public static void main(String[] args) {
        String str = "qingqinghappy";
        String maxString = getMaxString(str);
        System.out.println(maxString);

    }
}