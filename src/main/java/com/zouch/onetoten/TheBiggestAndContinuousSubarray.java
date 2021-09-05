package com.zouch.onetoten;

/**
 * @author Zouch
 * @date 2021/9/5 19:36
 * @description 连续子数组的最大和
 * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组  成一个子数组。求所有子数组的和的最大值。
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 *   输出: 6
 *   解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class TheBiggestAndContinuousSubarray {

    // 动态规划
    // 设dp[i]为当前为nums i下标时的最大和 max为连续子数组的最大和
    // 则dp[0] = nums[0] max = dp[0]
    // dp[1] = nums[1] 或dp[1] = dp[0]+nums[1]   注意这里变量是nums[1] 随着当前下标的值发生改变
    // dp[i] = max(nums[i],dp[i-1]+nums[i])
    public static int getBiggest(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(getBiggest(nums));
    }
}