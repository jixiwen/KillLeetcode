package org.example;

/**
 * @see <a href="https://leetcode.cn/problems/single-number/description/?envType=daily-question&envId=2023-10-14">136. 只出现一次的数字</a>
 */
public class lc_136 {

    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
