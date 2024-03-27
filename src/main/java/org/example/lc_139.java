package org.example;

import java.util.*;

/**
 * @see <a href="https://leetcode.cn/problems/word-break/">139. 单词拆分</a>
 */
public class lc_139 {

    public static void main(String[] args) {
        System.out.println(wordBreak("leetcode", Arrays.asList("leet", "code")));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j < wordDict.size(); j++) {
                if (dp[i]){
                    break;
                }
                String s1 = wordDict.get(j);
                if (s1.length() > i){
                    continue;
                }
                dp[i] = dp [i - s1.length()] & equalsStr(s, i - s1.length(), s1);
            }
        }
        return dp[s.length()];
    }

    public static boolean equalsStr(String s, int start, String word) {
        for (int i = start, j = 0; j < word.length(); i++, j++) {
            if (s.charAt(i) != word.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
