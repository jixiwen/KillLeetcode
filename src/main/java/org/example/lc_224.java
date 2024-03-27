package org.example;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @see <a href="https://leetcode.cn/problems/basic-calculator/description/">基本计算器</a>
 */
public class lc_224 {

    public static void main(String[] args) {
        System.out.println(calculate("-(1+(4+5+2)-3)+(6+8)+3"));
    }

    public static int calculate(String s){
        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(1);
        int sign = 1;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' '){
            } else if (c == '-'){
                sign = -deque.peek();
            } else if (c == '+'){
                sign = deque.peek();
            } else if (c == '('){
                deque.push(sign);
            } else if (c == ')') {
                deque.pop();
            } else {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))){
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                if (i != s.length()){
                    i--;
                }
                res += sign * num;
            }
        }
        return res;
    }


//
//    static final String ADD_OP = "+";
//    static final String SUB_OP = "-";
//    public static int calculate(String s) {
//        char[] charArray = s.trim().toCharArray();
//        Deque<String> deque = new ArrayDeque<>();
//        for (int i = 0; i < charArray.length; i++) {
//            char c = charArray[i];
//            switch (c) {
//                case '(':
//                case '+':
//                case '-':
//                    deque.addLast(String.valueOf(c));
//                    break;
//                case ')':
//                    String s1;
//                    Deque<String> culDeque = new ArrayDeque<>();
//                    while (!deque.isEmpty() && !"(".equals(s1 = deque.removeLast())) {
//                        culDeque.addFirst(s1);
//                    }
//                    deque.addLast(String.valueOf(calculate(culDeque)));
//                    break;
//                default:
//                    StringBuilder sb = new StringBuilder();
//                    while (i < charArray.length && charArray[i] > '0' && charArray[i] < '9') {
//                        c = charArray[i];
//                        sb.insert(0, c);
//                        i++;
//                    }
//                    deque.addLast(sb.toString());
//                    i--;
//            }
//        }
//        return calculate(deque);
//    }
//
//    private static int calculate(Deque<String> deque){
//        int x = 0;
//        String preOp = ADD_OP;
//        while (!deque.isEmpty()){
//            String s = deque.removeFirst();
//            if (ADD_OP.equals(s) || SUB_OP.equals(s)){
//                preOp = s;
//            } else {
//                if (ADD_OP.equals(preOp)){
//                    x += Integer.parseInt(s);
//                } else {
//                    x -= Integer.parseInt(s);
//                }
//            }
//        }
//        return x;
//    }
}
