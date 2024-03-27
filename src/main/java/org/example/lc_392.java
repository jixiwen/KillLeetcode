package org.example;

/**
 * @see <a href="https://leetcode.cn/problems/is-subsequence/description/">392. 判断子序列</a>
 */
public class lc_392 {

    // 双指针
//    public boolean isSubsequence(String s, String t) {
//        char[] sChars = s.toCharArray();
//        char[] tChars = t.toCharArray();
//        int i = 0, j = 0;
//        while (i < s.length() && j < t.length()){
//            if (sChars[i] == tChars[j]){
//                i++;
//            }
//            j++;
//        }
//        return i == s.length();
//    }

    // dp
    public boolean isSubsequence(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                if (sChars[i] == tChars[j]){
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[s.length()][t.length()] == s.length();
    }
}
