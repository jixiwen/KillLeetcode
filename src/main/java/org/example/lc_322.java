package org.example;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.cn/problems/coin-change/description/">322. 零钱兑换</a>
 * @see <a href="https://leetcode.cn/problems/gaM7Ch/">LCR 103. 零钱兑换</a>
 */
public class lc_322 {

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1,2,5}, 11));
    }

    public static int coinChange(int[] coins, int amount) {
        if (amount == 0){
            return 0;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] = Math.min(dp[j - coins[i]] + 1, dp[j]);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
