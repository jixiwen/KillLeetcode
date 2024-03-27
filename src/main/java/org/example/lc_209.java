package org.example;

/**
 * @see <a href="https://leetcode.cn/problems/minimum-size-subarray-sum/">209. 长度最小的子数组</a>
 */
public class lc_209 {

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(15, new int[]{5,1,3,5,10,7,4,9,2,8}));
    }
    public static int minSubArrayLen(int target, int[] nums) {
        int l = 0, r = -1, minLen = Integer.MAX_VALUE, minL = -1, minR = -1, wSum = 0;
        while (r < nums.length - 1) {
            r++;
            wSum += nums[r];
            while (l < nums.length && wSum >= target){
                if (r - l < minLen){
                    minL = l;
                    minR = r;
                    minLen = r - l;
                }
                wSum -= nums[l++];
            }
        }
        return minL == -1 ? 0 : minR - minL + 1;
    }
}
