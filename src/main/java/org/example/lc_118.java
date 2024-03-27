package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @see <a href="https://leetcode.cn/problems/pascals-triangle/description/">118. 杨辉三角</a>
 */
public class lc_118 {

    public static void main(String[] args) {
        List<List<Integer>> generate = generate(12);
        for (List<Integer> list : generate) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(List.of(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            List<Integer> pre = res.get(i - 1);
            for (int j = 0; j <= i; j++) {
                if (j - 1 < 0 || j == pre.size()){
                    list.add(1);
                } else {
                    list.add(pre.get(j - 1) + pre.get(j));
                }
            }
            res.add(list);
        }
        return res;
    }
}
