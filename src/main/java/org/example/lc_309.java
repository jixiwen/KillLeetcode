package org.example;

/**
 * @see <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/">309. 买卖股票的最佳时机含冷冻期</a>
 */
public class lc_309 {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (i > 1) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 2][1] - prices[i]);
            } else {
                dp[i][0] = Math.max(dp[i - 1][0], - prices[i]);
            }
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1]);
        }
        return dp[prices.length - 1][1];
    }
}
