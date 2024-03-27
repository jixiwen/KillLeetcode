package org.example;

import java.util.concurrent.Executors;

/**
 * @see <a href="https://leetcode.cn/problems/integer-to-roman/">12. 整数转罗马数字</a>
 */
public class lc_12 {

    static int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    static String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static void main(String[] args) {
//        System.out.println(intToRoman(58));
        System.out.println(Integer.toBinaryString(-1));
    }

    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int t = 100;
        int i = 0;
        while (num > 0){

        }

        Executors.newFixedThreadPool(5);
        return sb.toString();
    }
}
