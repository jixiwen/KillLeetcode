package org.example;

/**
 * @see <a href="https://leetcode.cn/problems/last-stone-weight-ii/description/">1049. 最后一块石头的重量 II</a>
 */
public class lc_1049 {

    public static void main(String[] args) {
        System.out.println(lastStoneWeightII(new int[]{2, 7, 4, 1, 8, 1}));
    }

    public static int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int sum1 = sum / 2;
        int[] dp = new int[sum1 + 1];
        for (int stone : stones) {
            for (int j = sum1; j >= stone; j--) {
                int weight = dp[j - stone] + stone;
                if (weight <= sum1) {
                    dp[j] = Math.max(dp[j], weight);
                }
                if (dp[j] == sum1){
                    return sum - (dp[j] << 1);
                }
            }
        }
        return sum - (dp[sum1] << 1);
    }
}
