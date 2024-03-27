package org.example;

import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://leetcode.cn/problems/subarray-sum-equals-k/">560. 和为 K 的子数组</a>
 */
public class lc_560 {

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1,-1, -1, 1}, 1));
    }
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> sumCount = new HashMap<>();
        sumCount.put(0, 1);
        int pre = 0, res = 0;
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            int key = pre - k;
            if (sumCount.containsKey(key)){
                res += sumCount.get(key);
            }
            sumCount.put(pre, sumCount.getOrDefault(pre, 0) + 1);
        }
        return res;
    }
}
