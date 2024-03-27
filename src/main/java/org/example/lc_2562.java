package org.example;

/**
 * @see <a href="https://leetcode.cn/problems/find-the-array-concatenation-value/description/?envType=daily-question&envId=2023-10-12">2562. 找出数组的串联值</a>
 */
public class lc_2562 {

    public static void main(String[] args) {
        System.out.println(findTheArrayConcVal(new int[]{}));
    }

    public static long findTheArrayConcVal(int[] nums) {
        long res = 0;
        int i = 0, j = nums.length  - 1;
        for (; i < j; i++, j--) {
            res += mergeNum(nums[i], nums[j]);
        }
        if (i == j){
            res += nums[i];
        }
        return res;
    }

    public static int mergeNum(int x, int y){
        int k = 1;
        while (y / k > 0){
            k *= 10;
        }
        return x * k + y;
    }
}
