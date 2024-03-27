package org.example;

import java.util.Map;

/**
 * @see <a href="https://leetcode.cn/problems/partition-equal-subset-sum/description/">416. 分割等和子集</a>
 */
public class lc_416 {

    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{2, 2, 1, 1}));
    }

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(nums[i], max);
        }
        if ((sum & 1) == 1){
            return false;
        }
        sum /= 2;
        if (max > sum){
            return false;
        }
        int[] dp = new int[sum + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = sum; j >= nums[i]; j--) {
                if (nums[i] <= j && dp[j - nums[i]] + nums[i] <= j){
                    dp[j] = Math.max(dp[j - nums[i]] + nums[i], dp[j]);
                }
            }
            if (dp[sum] == sum){
                return true;
            }
        }
        return dp[sum] == sum;
    }
}
