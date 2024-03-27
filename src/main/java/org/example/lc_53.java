package org.example;

/**
 * @see <a href="https://leetcode.cn/problems/maximum-subarray/">53. 最大子数组和</a>
 */
public class lc_53 {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    public static int maxSubArray(int[] nums) {
        int sum = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (sum < 0){
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            max = Math.max(sum, max);
        }
        return max;
    }
}
