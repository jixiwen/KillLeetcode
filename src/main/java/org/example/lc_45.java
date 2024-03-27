package org.example;

/**
 * @see <a href="https://leetcode.cn/problems/jump-game-ii/">45. 跳跃游戏 II</a>
 */
public class lc_45 {

    public int jump(int[] nums) {
        int res = 0;
        int maxP = 0;
        int end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxP = Math.max(nums[i] + i, maxP);
            if (i == end){
                end = maxP;
                res++;
            }
        }

        return res;
    }
}
