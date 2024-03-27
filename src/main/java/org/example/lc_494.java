package org.example;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.cn/problems/target-sum/description/">494. 目标和</a>
 */
public class lc_494 {

    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }

    public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        int tt = sum + target;
        if ((tt & 1) == 1 || tt < 0){
            return 0;
        }
        int plusSum = (tt) / 2;
        int[] dp = new int[plusSum + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = plusSum; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[plusSum];
    }
}
