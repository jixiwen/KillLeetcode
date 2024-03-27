package org.example;

/**
 * @see <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv/">188. 买卖股票的最佳时机 IV</a>
 */
public class lc_188 {

    public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[prices.length][2 * k];
        for (int i = 0; i < 2 * k; i++) {
            dp[0][i] = (i & 1) == 0 ? -prices[0] : 0;
        }
        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < 2 * k; j += 2) {
                if (j == 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], -prices[i]);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1] - prices[i], dp[i - 1][j]);
                }
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] + prices[i]);
            }
        }
        return dp[prices.length - 1][2 * k - 1];
    }
}
