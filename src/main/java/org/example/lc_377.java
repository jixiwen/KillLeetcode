package org.example;

/**
 * @see <a href="https://leetcode.cn/problems/combination-sum-iv/description/">377. 组合总和 Ⅳ</a>
 * @see <a href="https://leetcode.cn/problems/D0F0SV/description/">LCR 104. 组合总和 Ⅳ</a>
 */
public class lc_377 {

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target +1];
        dp[0] = 1;
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] <= i){
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
}
