package org.example;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.cn/problems/ones-and-zeroes/description/">474. 一和零</a>
 */
public class lc_474 {

    public static void main(String[] args) {
        System.out.println(findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
    }

    public static int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i < strs.length; i++) {
            int zero = 0;
            int one = 0;
            for (int j = 0; j < strs[i].length(); j++) {
                if (strs[i].charAt(j) == '0'){
                    zero++;
                } else {
                    one++;
                }
            }
            for (int j = m; j >= zero; j--) {
                for (int k = n; k >= one; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - zero][k - one] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
