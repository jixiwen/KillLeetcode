package org.example;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.cn/problems/edit-distance/description/">72. 编辑距离</a>
 */
public class lc_72 {

    public static void main(String[] args) {
        System.out.println(minDistance("horse", "ros"));
    }

    public static int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = i;
            for (int j = 1; j < dp[i].length; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1,Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1));
                }
            }
            BaseUtil.print(dp);
        }
        return dp[word1.length()][word2.length()];
    }
}
