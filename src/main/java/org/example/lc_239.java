package org.example;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @see <a href="https://leetcode.cn/problems/sliding-window-maximum/description/">239. 滑动窗口最大值</a>
 */
public class lc_239 {

    public static void main(String[] args) {
        int[] ints = maxSlidingWindow(new int[]{1}, 1);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[deque.getLast()] <= nums[i]){
                deque.removeLast();
            }
            deque.addLast(i);
            if (i >= k - 1){
                res[i - k + 1] = nums[deque.getFirst()];
            }
            if (i - k + 1 == deque.getFirst()){
                deque.removeFirst();
            }
        }
        return res;
    }
}
