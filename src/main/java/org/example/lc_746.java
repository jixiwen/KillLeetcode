package org.example;

/**
 * @see <a href="https://leetcode.cn/problems/min-cost-climbing-stairs/description/">746. 使用最小花费爬楼梯</a>
 *
 * @see <a href="https://leetcode.cn/problems/GzCJIP/description/">LCR 088. 使用最小花费爬楼梯</a>
 */
public class lc_746 {

    public int minCostClimbingStairs(int[] cost) {
        int pre  = 0;
        int pPre = 0;
        for (int i = 2; i <= cost.length; i++) {
            int t = Math.min(cost[i - 1] + pre, cost[i - 2] + pPre);
            pPre = pre;
            pre = t;
        }
        return pre;
    }
}
