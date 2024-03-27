package org.example;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.cn/problems/split-with-minimum-sum/?envType=daily-question&envId=2023-10-09">2578. 最小和分割</a>
 */
public class lc_2578 {

    public int splitNum(int num) {
        char[] s = String.valueOf(num).toCharArray();
        Arrays.sort(s);
        int num1 = 0, num2 = 0;
        for (int i = 0; i < s.length; i++) {
            if ((i & 1) == 1){
                num1 = num1 * 10 + s[i] - '0';
            } else {
                num2 = num2 * 10 + s[i] - '0';
            }
        }
        return num1 + num2;
    }
}
