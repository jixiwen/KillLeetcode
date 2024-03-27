package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @see <a href="https://leetcode.cn/problems/pascals-triangle-ii/description/">119. 杨辉三角 II</a>
 */
public class lc_119 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getRow(3).toArray()));
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i; j > 0; j--) {
                if (j == res.size()) {
                    res.add(1);
                } else {
                    res.set(j, res.get(j - 1) + res.get(j));
                }
            }
        }
        return res;
    }
}
