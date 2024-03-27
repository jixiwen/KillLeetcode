package org.example;

/**
 * @see <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/">122. 买卖股票的最佳时机 II</a>
 */
public class lc_122 {

    // 直接贪心
//    public int maxProfit(int[] prices) {
//        int res = 0;
//        for (int i = 1; i < prices.length; i++) {
//            int price = prices[i] - prices[i - 1];
//            res += Math.max(price, 0);
//        }
//        return res;
//    }

    // 动态规划
    public int maxProfit(int[] prices) {
        // dp[i][0] 表示持有股票时手中的最大金额
        // dp[i][1] 表示未持有股票时手中的最大金额
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(prices[i] + dp[i - 1][0], dp[i -1][1]);
        }

        return dp[dp.length - 1][1];
    }
}
