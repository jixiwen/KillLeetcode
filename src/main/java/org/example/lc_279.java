package org.example;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.cn/problems/perfect-squares/description/">279. 完全平方数</a>
 */
public class lc_279 {

    public static void main(String[] args) {
        System.out.println(numSquares(6));
    }
//    public static int numSquares(int n) {
//        int[] dp = new int[n + 1];
//        int k;
//        for (int j = 0; (k = j * j) <= n; j++) {
//            int min = Integer.MAX_VALUE;
//            for (int i = k; i < n + 1; i++) {
//                min = Math.min(min, dp[i - k] + 1);
//            }
//            dp[j] = min;
//        }
//        return dp[n];
//    }

    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            int min = Integer.MAX_VALUE;
            int k;
            for (int j = 1; (k = j * j) <= i; j++) {
                min = Math.min(min, dp[i - k] + 1);
            }
            dp[i] = min;
        }
        return dp[n];
    }
}
