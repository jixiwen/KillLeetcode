package org.example;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @see <a href="https://leetcode.cn/problems/longest-repeating-character-replacement/description/">424. 替换后的最长重复字符</a>
 */
public class lc_424 {

    public int characterReplacement(String s, int k) {
        if (k >= s.length() - 1){
            return s.length();
        }
        int l = 0, r = 0, maxLen = 0, maxCount = 0;
        char[] chars = s.toCharArray();
        int[] count = new int[26];
        while (r < s.length()){
            int curCount = ++count[chars[r] - 'A'];
            maxCount = Math.max(maxCount, curCount);
            r++;
            while (r - l > maxCount + k){
                --count[chars[l] - 'A'];
                l++;
            }
        }

        return r - l;
    }

}
