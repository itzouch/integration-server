package com.zouch.algorithm;

/**
 * @author Zouch
 * @date 2021/9/5 19:17
 * @description 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * Input: [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 *              Total amount you can rob = 2 + 9 + 1 = 12.
 */
public class MaxAmount {
    // 动态规划：
    // 先求状态方程 ：设d(p)为最大金额，nums[]为保存金额的数组，例题为[2,7,9,3,1]
    // 如果从0开始，那么有
    // d(0)=nums[0],d(1)=max(nums[0],nums[1])
    // d(2)则有两种情况，
    // 1. d(2) = d(0)+nums[2]
    // 2. d(2) = d(1) 因为不允许相邻。
    // 所以d(2) = max(d(0)+nums[2],d(1))
    // 推出状态转移方程d[i] = max(d(i-2)+nums[i],d(i-1))
    public static int getMaxAmount(int[] nums){
        if (nums.length==0){
            return 0;
        }
        if (nums.length==1){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0],nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[nums.length-1];

    }

    public static void main(String[] args) {
        int[] nums =new int []{2,7,9,3,1};
        System.out.println(getMaxAmount(nums));
    }
}