package org.example;

/**
 * @see <a href="https://leetcode.cn/problems/unique-paths/description/">62. 不同路径</a>
 * @see <a href="https://leetcode.cn/problems/2AoeFn/">LCR 098. 不同路径</a>
 */
public class lc_62 {

    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i - 1 < 0 || j - 1 < 0){
                    dp[j] = 1;
                } else {
                    dp[j] = dp[j - 1] + dp[j];
                }
            }
        }
        return dp[n - 1];
    }
}
