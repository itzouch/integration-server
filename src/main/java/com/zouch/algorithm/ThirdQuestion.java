package com.zouch.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zouch
 * @date 2021/5/26 20:33
 * @description 找出字符串的不重复的最长子串
 */
public class ThirdQuestion {
    public static void main(String[] args) {
        String str = "abcabcbb";
        int i = lengthOfLongestSubstring(str);
        System.out.println(i);
    }
    private static int lengthOfLongestSubstring(String string){
        int length = 0;
        List<Character> strings = new ArrayList<>(string.length());
        char[] chars = string.toCharArray();
        int loop = 0;
        int max = 0;
        while (length<chars.length){
            if (!strings.contains(chars[length])){
                strings.add(chars[length]);
                length++;
            }else {
                strings.clear();
                loop++;
                length = loop;
            }
            max = Math.max(strings.size(), max);
        }
        return max;
    }


}