package org.example;

/**
 * @see <a href="https://leetcode.cn/problems/count-the-number-of-vowel-strings-in-range/?envType=daily-question&envId=Invalid%20Date">2586. 统计范围内的元音字符串数</a>
 */
public class lc_2586 {

    static boolean[] chars = new boolean[26];
    static {
        chars[0] = true;
        chars['e' - 'a'] = true;
        chars['i' - 'a'] = true;
        chars['o' - 'a'] = true;
        chars['u' - 'a'] = true;
    }
    public int vowelStrings(String[] words, int left, int right) {
        int res = 0;
        for (int i = left; i <= right; i++) {
            String word = words[i];
            if (chars[word.charAt(0) - 'a'] && chars[word.charAt(word.length() - 1) - 'a']){
                res++;
            }
        }
        return res;
    }
}
