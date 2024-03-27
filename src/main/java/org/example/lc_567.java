package org.example;

/**
 * @see <a href="https://leetcode.cn/problems/permutation-in-string/">567. 字符串的排列</a>
 */
public class lc_567 {

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidboaooo"));
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() >  s2.length()){
            return false;
        }
        int l = 0, r = -1, cnt = s1.length();
        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
        }
        while (r < s2.length() - 1){
            ++r;
            if (count[s2.charAt(r) - 'a']-- > 0){
                cnt--;
            }
            if (cnt == 0){
                while (count[s2.charAt(l) - 'a']++ < 0){
                    l++;
                }
                if (r - l + 1 == s1.length()){
                    return true;
                }
                l++;
                cnt++;
            }
        }
        return false;
    }
}
