package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @see <a href="https://leetcode.cn/problems/find-all-anagrams-in-a-string/">438.找到字符串中所有字母异位词</a>
 * @see <a href="https://leetcode.cn/problems/VabMRr/description/">LCR 015. 找到字符串中所有字母异位词</a>
 */
public class lc_438 {

    public static void main(String[] args) {
        List<Integer> anagrams = findAnagrams("abaacbabc", "abc");
        System.out.println(Arrays.toString(anagrams.toArray()));
    }
    public static List<Integer> findAnagrams(String s, String p) {
        if (p.isEmpty() || p.length() > s.length()){
            return new ArrayList<>();
        }
        int l = 0, r = -1, cnt = p.length();
        int[] pCount = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pCount[p.charAt(i) - 'a'] += 1;
        }
        List<Integer> res = new ArrayList<>();

        while (r < s.length() - 1) {
            r++;
            if (pCount[s.charAt(r) - 'a']-- > 0){
                cnt--;
            }
            if (cnt == 0){
                while (pCount[s.charAt(l) - 'a']++ < 0){
                    l++;
                }
                if (r - l + 1 == p.length()){
                    res.add(l);
                }
                l++;
                cnt++;
            }
        }
        return res;
    }
}
