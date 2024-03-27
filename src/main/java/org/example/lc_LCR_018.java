package org.example;

/**
 * @see <a href="https://leetcode.cn/problems/XltzEq/description/">LCR 018. 验证回文串</a>
 */
public class lc_LCR_018 {

    public static void main(String[] args) {
        System.out.println(isPalindrome("0P"));
    }

    public static boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r){
            while (l < s.length() && !Character.isDigit(s.charAt(l)) && !Character.isLetter(s.charAt(l))){
                l++;
            }
            while (r >= 0 && !Character.isDigit(s.charAt(r)) && !Character.isLetter(s.charAt(r))){
                r--;
            }
            if (r >= 0 && l < s.length() && !equals(s.charAt(l), s.charAt(r))){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static boolean equals(char c1, char c2){
        if (!Character.isDigit(c1) && !Character.isDigit(c2)){
            return c1 == c2 || c1 - 'a' == c2 - 'A' || c1 - 'A' == c2 - 'a';
        }
        return c1 == c2;
    }
}
