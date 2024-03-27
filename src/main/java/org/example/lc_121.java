package org.example;

/**
 * @see <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/description/">121. 买卖股票的最佳时机</a>
 */
public class lc_121 {


    // 贪心解法
//    public int maxProfit(int[] prices) {
//        int p = Integer.MAX_VALUE;
//        int res = Integer.MIN_VALUE;
//        for (int i = 0; i < prices.length; i++) {
//            res = Math.max(res, prices[i] - p);
//            p = Math.min(p, prices[i]);
//        }
//        return Math.max(res, 0);
//    }

    // 动态规划
    public int maxProfit(int[] prices) {
        // dp[i][0] 表示持有股票时手中的最大金额
        // dp[i][1] 表示未持有股票时手中的最大金额
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(prices[i] + dp[i - 1][0], dp[i -1][1]);
        }

        return dp[dp.length - 1][1];
    }
}
