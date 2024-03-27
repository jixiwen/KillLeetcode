package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.cn/problems/words-within-two-edits-of-dictionary/description/">2452. 距离字典两次编辑以内的单词</a>
 */
public class lc_2452 {

    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> res = new ArrayList<>();
        for (String query : queries) {
            for (String s : dictionary) {
                if (check(query, s)) {
                    res.add(query);
                    break;
                }
            }
        }
        return res;
    }

    public boolean check(String s1, String s2){
        int x = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i) && ++x > 2){
                return false;
            }
        }
        return true;
    }
}
