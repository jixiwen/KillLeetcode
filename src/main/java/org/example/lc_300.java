package org.example;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.cn/problems/longest-increasing-subsequence/description/">300. 最长递增子序列</a>
 */
public class lc_300 {

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
                if (dp[i] == i + 1){
                    break;
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
