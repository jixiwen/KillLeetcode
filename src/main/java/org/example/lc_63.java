package org.example;

/**
 * @see <a href="https://leetcode.cn/problems/unique-paths-ii/description/">63. 不同路径 II</a>
 */
public class lc_63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[] dp = new int[obstacleGrid[0].length];
        dp[0] = 1;
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[i].length; j++) {
                if (obstacleGrid[i][j] == 1){
                    dp[j] = 0;
                } else if (i > 0 && j > 0){
                    dp[j] = dp[j - 1] + dp[j];
                } else if (i - 1 < 0 && j > 0) {
                    dp[j] = dp[j - 1];
                }
            }
        }
        return dp[dp.length - 1];
    }
}
