package org.example;

/**
 * @see <a href="https://leetcode.cn/problems/palindrome-number/description/">9.回文数</a>
 */
public class lc_9 {

    // 反转一半数字
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)){
            return false;
        }
        int rx = 0;
        while (x > rx){
            rx = rx * 10 + x % 10;
            if (rx == x){
                return true;
            }
            x = x / 10;
        }
        return rx == x;
    }
}
