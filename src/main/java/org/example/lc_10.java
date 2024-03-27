package org.example;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.cn/problems/regular-expression-matching/">10. 正则表达式匹配</a>
 */
public class lc_10 {

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a*"));
    }

    public static boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        char[] sc = s.toCharArray();
        char[] pc = p.toCharArray();
        dp[0][0] = true;
        for (int i = 0; i <= sc.length; i++) {
            for (int j = 1; j <= pc.length; j++) {
               if (pc[j - 1] == '*'){
                   dp[i][j] = dp[i][j - 2];
                   if (i > 0 && (sc[i - 1] == pc[j - 2] || pc[j - 2] == '.')){
                       dp[i][j] = dp[i][j] || dp[i - 1][j];
                   }
               } else {
                   if (i > 0 && (sc[i - 1] == pc[j - 1] || pc[j - 1] == '.')){
                       dp[i][j] = dp[i - 1][j - 1];
                   }
               }
            }
        }
        BaseUtil.print(dp);
        return dp[s.length()][p.length()];
    }
}
