package org.example;

/**
 * @see <a href="https://leetcode.cn/problems/integer-break/">343. 整数拆分</a>
 */
public class lc_343 {

    public static void main(String[] args) {
        System.out.println(integerBreak(5));
    }

    public static int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = Math.max(Math.max(dp[i - 2] * 2, 2 * (i - 2)), Math.max(3 * (i - 3), dp[i - 3] * 3));
        }
        return dp[n];
    }

//    public static int integerBreak(int n) {
//        int[] dp = new int[n + 1];
//        dp[1] = 1;
//        dp[2] = 1;
//        for (int i = 3; i < dp.length; i++) {
//            for (int j = i; j >= i - j; j--) {
//                dp[i] = Math.max(dp[j] * (i - j), Math.max(j * (i - j), dp[i]));
//            }
//        }
//        return dp[n];
//    }
}
