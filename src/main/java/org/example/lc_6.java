package org.example;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.cn/problems/zigzag-conversion/">6. N 字形变换</a>
 */
public class lc_6 {

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 4));
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1){
            return s;
        }
        int[] step = new int[numRows];
        for (int i = 0; i < numRows - 1; i++) {
            step[i] = (numRows - 1 - i) * 2;
        }
        step[numRows - 1] = step[0];
        char[] chars = new char[s.length()];

        for (int i = 0, j = 0; i < step.length && i < s.length(); i++) {
            int idx = i;
            while (idx < s.length()){
                chars[j] =  s.charAt(idx);
                j++;
                idx += step[i];
                if (i > 0 && i < step.length - 1){
                    step[i] = step[0] - step[i];
                }
            }
        }
        return new String(chars);
    }
}
