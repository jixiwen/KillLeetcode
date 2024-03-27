package org.example;

/**
 * @see <a href="https://leetcode.cn/problems/coin-change-ii/description/">518. 零钱兑换 II</a>
 */
public class lc_518 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}
