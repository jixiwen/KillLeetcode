package org.example;

/**
 * @see <a href="https://leetcode.cn/problems/maximum-length-of-repeated-subarray/description/">718. 最长重复子数组</a>
 */
public class lc_718 {

    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        int max = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]){
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                }
                max = Math.max(dp[i + 1][j + 1], max);
            }
        }
        return max;
    }

}
