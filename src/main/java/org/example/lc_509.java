package org.example;

/**
 * @see <a href="https://leetcode.cn/problems/fei-bo-na-qi-shu-lie-lcof/description/">LCR 126. 斐波那契数</a>
 * <p>
 * 第509范围小不需要取模
 * @see <a href="https://leetcode.cn/problems/fibonacci-number/description/">509. 斐波那契数</a>
 */
public class lc_509 {

    public int fib(int n) {
        if (n == 0) return 0;
        int pre = 1;
        int pPre = 1;
        for (int i = 2; i < n; i++) {
            int t = pre % 1000000007 + pPre % 1000000007;
            pPre = pre;
            pre = t;
        }
        return pre % 1000000007;
    }
}
