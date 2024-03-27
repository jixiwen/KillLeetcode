package org.example;

/**
 * @see <a href="https://leetcode.cn/problems/M1oyTv/description/">LCR 017. 最小覆盖子串</a>
 * @see <a href="https://leetcode.cn/problems/minimum-window-substring/description/">76. 最小覆盖子串</a>
 */
public class lc_76 {

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }


//    public String minWindow(String s, String t) {
//        if (s.length() < t.length()) {
//            return "";
//        }
//        int[] arr = new int['z' - 'A' + 1];
//        for (char c : t.toCharArray()) {
//            arr[c - 'A']++;
//        }
//        int cnt = t.length();
//        int begin = -1;
//        int count = s.length() + 1;
//        int l = 0;
//        int r = 0;
//        while (r < s.length()) {
//            if (arr[s.charAt(r++) - 'A']-- > 0) {
//                cnt--;
//            }
//            if (cnt == 0) {
//                while (arr[s.charAt(l) - 'A']++ < 0) {
//                    l++;
//                }
//                if (count > r - l) {
//                    begin = l;
//                    count = r - l;
//                }
//                l++;
//                cnt++;
//            }
//        }
//        return begin == -1 ? "" : s.substring(begin, begin + count);
//    }

    public static String minWindow(String s, String t) {
        if (s.length() < t.length()){
            return "";
        }

        int[] tMap = new int[60];
        int[] wMap = new int[60];
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            tMap[c - 'A'] += 1;
        }
        int l = 0, r = -1, minLen = Integer.MAX_VALUE, minL = -1, minR = -1;
        while (r < s.length() -1){
            r++;
            char cur = s.charAt(r);
            wMap[cur - 'A'] += 1;
            while (check(tMap, wMap)){
                if (r - l < minLen){
                    minLen = r - l;
                    minL = l;
                    minR = r;
                }
                char lc = s.charAt(l);
                wMap[lc - 'A'] -= 1;
                l++;
            }

        }
        if (minL < 0){
            return "";
        }
        return s.substring(minL, minR + 1);
    }

    public static boolean check(int[] tMap, int[] wMap){
        for (int i = 0; i < tMap.length; i++) {
            if (wMap[i] < tMap[i]){
                return false;
            }
        }
        return true;
    }
}
