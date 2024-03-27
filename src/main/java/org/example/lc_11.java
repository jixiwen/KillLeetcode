package org.example;

/**
 * @see <a href="https://leetcode.cn/problems/container-with-most-water/description/">11. 盛最多水的容器</a>
 */
public class lc_11 {

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
    public static int maxArea(int[] height) {
        int res = 0;
        for (int i = 0, j = height.length - 1; i < j;) {
            int len = j - i;
            int area = 0;
            if (height[i] > height[j]){
                area = height[j] * len;
                j--;
            } else {
                area = height[i] * len;
                i++;
            }
            res = Math.max(res, area);
        }
        return res;
    }
}
