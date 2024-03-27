package org.example;

/**
 * @see <a href="https://leetcode.cn/problems/unique-binary-search-trees/">96. 不同的二叉搜索树</a>
 */
public class lc_96 {

    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }

    public static int numTrees(int n) {
        if (n < 3){
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[i - j] * dp[j - 1];
            }
        }
        return dp[n];
    }
}
