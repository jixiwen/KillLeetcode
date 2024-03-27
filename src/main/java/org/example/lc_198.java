package org.example;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.cn/problems/house-robber/description/">198. 打家劫舍</a>
 * @see <a href="https://leetcode.cn/problems/Gu0c2T/submissions/472879167/">LCR 089. 打家劫舍</a>
 */
public class lc_198 {

    public static void main(String[] args) {
        System.out.println(rob(new int[]{2, 7, 9, 3, 1}));
    }

    public static int rob(int[] nums) {
        int pp = 0;
        int p = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int cur = Math.max(p, pp + nums[i]);
            pp = p;
            p = cur;
        }
        return p;
    }
}
