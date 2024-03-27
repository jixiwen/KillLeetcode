package org.example;

/**
 * @see <a href="https://leetcode.cn/problems/distinct-subsequences/description/">115. 不同的子序列</a>
 */
public class lc_115 {

    public static void main(String[] args) {
        System.out.println(numDistinct("babgbag", "bag"));
    }

    public static int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                if (sChars[i] == tChars[j]){
                    dp[i + 1][j + 1] = dp[i][j] + dp[i][j + 1];
                } else {
                    dp[i + 1][j + 1] = dp[i][j + 1];
                }
            }
            BaseUtil.print(dp);
        }
        return dp[s.length()][t.length()];
    }
}
