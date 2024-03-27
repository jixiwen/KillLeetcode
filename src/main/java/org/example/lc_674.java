package org.example;

/**
 * @see <a href="https://leetcode.cn/problems/longest-continuous-increasing-subsequence/description/">674. 最长连续递增序列</a>
 */
public class lc_674 {

    // 动归
//    public int findLengthOfLCIS(int[] nums) {
//        int[] dp = new int[nums.length];
//        int max = 1;
//        dp[0] = 1;
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] > nums[i - 1]){
//                dp[i] = dp[i - 1] + 1;
//            } else {
//                dp[i] = 1;
//            }
//            max = Math.max(dp[i], max);
//        }
//        return max;
//    }

    // 状态压缩动归
    public int findLengthOfLCIS(int[] nums) {
        int preLen = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            int len = 1;
            if (nums[i] > nums[i - 1]){
                len = preLen + 1;
            }
            preLen = len;
            max = Math.max(len, max);
        }
        return max;
    }
}
