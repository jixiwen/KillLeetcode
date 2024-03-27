package org.example;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/description/">123. 买卖股票的最佳时机 III</a>
 */
public class lc_123 {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
    }
    public static int maxProfit(int[] prices) {
        // 持有与未持有股票时手中的最大金额
        int[][] dp = new int[prices.length][4];
        dp[0][0] = -prices[0]; // 第一次持有
        dp[0][1] = 0;          // 第一次未持有
        dp[0][2] = -prices[0]; // 第二次持有
        dp[0][3] = 0;          // 第二次未持有
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(-prices[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1]);
            dp[i][2] = Math.max(dp[i - 1][1] - prices[i], dp[i - 1][2]);
            dp[i][3] = Math.max(dp[i - 1][2] + prices[i], dp[i - 1][3]);

        }
        return dp[prices.length - 1][3];
    }
}
