package org.example;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/">3. 无重复字符的最长子串</a>
 */
public class lc_3 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(" 1"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int l = 0, r = -1, maxLen = -1;
        int[] index = new int[128];
        Arrays.fill(index, -1);
        while (r < s.length() - 1){
            r++;
            if (index[s.charAt(r)] > -1){
                l = Math.max(l, index[s.charAt(r)] + 1);
            }
            index[s.charAt(r)] = r;
            if (r - l > maxLen){
                maxLen = r - l;
            }
        }
        return maxLen + 1;
    }
}
