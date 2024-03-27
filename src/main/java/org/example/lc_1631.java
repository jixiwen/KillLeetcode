package org.example;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.cn/problems/path-with-minimum-effort/description/">1631. 最小体力消耗路径</a>
 */
public class lc_1631 {

    static int times = 0;

    public static void main(String[] args) {
        int[][] ints = {
                {8, 3, 2, 5, 2, 10, 7, 1, 8, 9},
                {1, 4, 9, 1, 10, 2, 4, 10, 3, 5},
                {4, 10, 10, 3, 6, 1, 3, 9, 8, 8},
                {4, 4, 6, 10, 10, 10, 2, 10, 8, 8},
                {9, 10, 2, 4, 1, 2, 2, 6, 5, 7},
                {2, 9, 2, 6, 1, 4, 7, 6, 10, 9},
                {8, 8, 2, 10, 8, 2, 3, 9, 5, 3},
                {2, 10, 9, 3, 5, 1, 7, 4, 5, 6},
                {2, 3, 9, 2, 5, 10, 2, 7, 1, 8},
                {9, 10, 4, 10, 7, 4, 9, 3, 1, 6}};
        System.out.println(minimumEffortPath(new int[][]{
                {1,2,2},
                {3,8,2},
                {5,3,5}}));
    }

    static int[][] direction = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static int minimumEffortPath(int[][] heights) {
        int m = heights.length - 1;
        int n = heights[0].length - 1;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        boolean[][] booleans = new boolean[m + 1][n + 1];
        dijkstra(heights, 0, 0, dp, m, n, 0, booleans);

        BaseUtil.print(dp);
        return dp[m][n];
    }

    public static void dijkstra(int[][] heights, int x, int y, int[][] dp, int m, int n, int max, boolean[][] exists) {
        if (x < 0 || x > m || y < 0 || y > n) {
            return;
        }
        exists[x][y] = true;
        int pre = Integer.MAX_VALUE;
        int eq = 0;

        BaseUtil.print(dp);
        for (int i = 0; i < direction.length; i++) {
            int xx = x + direction[i][0];
            int yy = y + direction[i][1];
            if (xx >= 0 && xx <= m && yy >= 0 && yy <= n && dp[xx][yy] != Integer.MAX_VALUE) {
                int cur = Math.abs(heights[xx][yy] - heights[x][y]);
                dp[x][y] = Math.min(dp[x][y], Math.max(dp[xx][yy], Math.max(cur, max)));
                if (dp[x][y] < max) {
                    max = dp[x][y];
                }
            }
        }
        for (int i = 0; i < direction.length; i++) {
            int xx = x + direction[i][0];
            int yy = y + direction[i][1];
            if (xx >= 0 && xx <= m && yy >= 0 && yy <= n && !exists[xx][yy]) {
                int cur = Math.abs(heights[xx][yy] - heights[x][y]);
                dp[xx][yy] = Math.min(dp[xx][yy], Math.max(cur, max));
                if (dp[xx][yy] < pre) {
                    pre = dp[xx][yy];
                    eq = 1 << i;
                } else if (dp[xx][yy] == pre) {
                    eq |= 1 << i;
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            if ((eq >> i & 1) == 1) {
                dijkstra(heights, x + direction[i][0], y + direction[i][1], dp, m, n, pre, exists);
            }
        }
    }
}
