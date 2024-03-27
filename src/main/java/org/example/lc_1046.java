package org.example;

/**
 * @see <a href="https://leetcode.cn/problems/last-stone-weight/description/">1046. 最后一块石头的重量</a>
 */
public class lc_1046 {

    public static void main(String[] args) {
        System.out.println(lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
    }

    static int count = 0;
    public static int lastStoneWeight(int[] stones) {
        count = stones.length;
        reBalance(stones, 0);
        while (count > 1){
            int n1 = poll(stones);
            int n2 = poll(stones);
            if (n1 > n2){
                offer(stones, n1 - n2);
            }
        }
        return count > 0 ? poll(stones) : 0;
    }

    public static void offer(int[] stones, int x) {
        stones[count++] = x;
        reBalance(stones, 0);
    }

    public static int poll(int[] stones) {
        int t = stones[0];
        stones[0] = stones[--count];
        stones[count] = t;
        reBalance(stones, 0);
        return t;
    }

    public static void reBalance(int[] stones, int idx) {
        if (idx >= count) {
            return;
        }
        int l = 2 * idx + 1;
        reBalance(stones, l);
        int r = 2 * idx + 2;
        reBalance(stones, r);
        if (l < count && stones[l] > stones[idx]) {
            swap(stones, l, idx);
        }
        if (r < count && stones[r] > stones[idx]) {
            swap(stones, r, idx);
        }
    }

    public static void swap(int[] stones, int i1, int i2) {
        int t = stones[i1];
        stones[i1] = stones[i2];
        stones[i2] = t;
    }
}
