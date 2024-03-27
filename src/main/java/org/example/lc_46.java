package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.cn/problems/permutations/">46. 全排列</a>
 */
public class lc_46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, res, new boolean[21], new ArrayList<>(), 0);
        return res;
    }

    void dfs(int[] nums, List<List<Integer>> res, boolean[] used, List<Integer> path, int count){
        if (count == nums.length){
            res.add(new ArrayList<>(path));
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[nums[i] + 10]){
                continue;
            }
            path.add(nums[i]);
            used[nums[i] + 10] = true;
            count++;
            dfs(nums, res, used, path, count);
            count--;
            used[nums[i] + 10] = false;
            path.remove(path.size() - 1);
        }
    }
}
