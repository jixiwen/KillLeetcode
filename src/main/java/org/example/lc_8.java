package org.example;

/**
 * @see <a href="https://leetcode.cn/problems/string-to-integer-atoi/">8. 字符串转换整数 (atoi)</a>
 */
public class lc_8 {

    public static void main(String[] args) {
        System.out.println(myAtoi(String.valueOf(Integer.MIN_VALUE)));
    }

    public static int myAtoi(String s) {
        if (s == null || s.isEmpty()){
            return 0;
        }
        long res = 0;
        int i = 0;
        char c = s.charAt(i);
        while (i < s.length() && (c = s.charAt(i)) == ' '){
            i++;
        }
        int pre = 1;
        if (c == '-' || c == '+'){
            pre = c == '-' ? -1 : 1;
            i++;
        }
        while (i < s.length() && (c = s.charAt(i)) >= '0' && c <= '9'){
            res = res * 10 + (c - '0');
            if (res > Integer.MAX_VALUE){
                return pre == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            i++;
        }
        return (int)res * pre;
    }
}
