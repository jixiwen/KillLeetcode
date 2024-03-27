package org.example;

/**
 * @see <a href="https://leetcode.cn/problems/single-number-ii/description/?envType=daily-question&envId=2023-10-15">137. 只出现一次的数字 II</a>
 */
public class lc_137 {

    public int singleNumber(int[] nums) {
        int res = 0;

        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] >> i & 1) == 1){
                    count++;
                }
            }
            if ((count % 3) != 0){
                res |= 1 << i;
            }
        }

        return res;
    }
}
