package org.example;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @see <a href="https://leetcode.cn/problems/basic-calculator-ii/description/">基本计算器2</a>
 */
public class lc_227 {

    public static void main(String[] args) {
        System.out.println(calculate(" 3+5 / 2 "));
    }

    public static int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int num = 0;
        char preOp = '+';
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))){
                num = num * 10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == s.length() - 1){
                switch (preOp) {
                    case '+' -> stack.push(num);
                    case '-' -> stack.push(-num);
                    case '*' -> stack.push(stack.pop() * num);
                    case '/' -> stack.push(stack.pop() / num);
                }
                preOp = s.charAt(i);
                num = 0;
            }
        }
        int res = 0;
        while (!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }
}
