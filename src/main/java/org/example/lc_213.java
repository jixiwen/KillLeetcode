package org.example;

/**
 * @see <a href="https://leetcode.cn/problems/house-robber-ii/description/">213. 打家劫舍 II</a>
 * @see <a href="https://leetcode.cn/problems/PzWKhm/">LCR 090. 打家劫舍 II</a>
 */
public class lc_213 {

    public int rob(int[] nums) {
        int m = rob1(nums, 0, nums.length - 2);
        int n = rob1(nums, 1, nums.length - 1);
        return Math.max(m, n);
    }

    public int rob1(int[] nums, int start, int end){
        if (start >= nums.length){
            return 0;
        }
        int pp = 0;
        int p = nums[start];
        for (int i = start + 1; i <= end; i++) {
            int cur = Math.max(p, pp + nums[i]);
            pp = p;
            p  = cur;
        }
        return p;
    }
}
