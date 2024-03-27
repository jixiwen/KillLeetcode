package org.example;


/**
 * @see <a href="https://leetcode.cn/problems/a7VOhD/description/">LCR 020. 回文子串</a>
 * @see <a href="https://leetcode.cn/problems/palindromic-substrings/description/">647. 回文子串</a>
 */
public class
lc_647 {

    public static void main(String[] args) {
        System.out.println(countSubstrings("aaa"));
    }

    static final char PLACEHOLDER = '*';

    /**
     * Manacher 算法
     * @param s
     * @return
     */
    public static int countSubstrings(String s) {
        // 1. 预填充处理
        char[] chars = new char[s.length() * 2 + 1];
        for (int i = 0, j = 0; i < chars.length; i++) {
            if ((i & 1) == 1){
                chars[i] = s.charAt(j);
                j++;
            } else {
                chars[i] = PLACEHOLDER;
            }
        }
        // 2. 半径数组
        int[] radius = new int[chars.length];
        // 3. 上次最右边界、边界对应的中心点、最左边界
        int r = -1;
        int l = -1;
        int p = -1;
        // 4. 处理
        for (int i = 0; i < chars.length; i++) {
            // 4.1 当前位置在最右边界外，中心扩散匹配
            if (i > r){
                int i_radius = radius(chars, i, i);
                radius[i] = i_radius;
                r = i + i_radius - 1;
                l = i - i_radius + 1;
                p = i;
            } else {
                // 4.2 当前位置在最右边界内
                int i2 = p - (i - p);
                int i2_radius = radius[i2];
                // 4.2.1 找到当前位置的对称点
                //       判断对称点回文半径是否完全在对称中心的大回文内
                //       如果在直接取那个点的半径
                if (i2 - i2_radius + 1 > l){
                    radius[i] = i2_radius;
                } else {
                    // 4.2.2 如果不完全在最大回文内
                    //       顺着最右边界开始判断回文
                    int il = i - (r - i);
                    int i_radius = radius(chars, il, r);
                    radius[i] = i_radius;
                    r = i + i_radius - 1;
                    l = i - i_radius + 1;
                    p = i;
                }
            }
        }
        // 5. 计算结果
        int res = 0;
        for (int j : radius) {
            // 5.1 因为有填充所以要除2
            res += j >> 1;
        }
        return res;
    }

    public static int radius(char[] s, int l, int r){
        while (l >= 0 && r < s.length && s[l] == s[r]){
            l--;
            r++;
        }
        return (r - l) / 2;
    }

//    /**
//     * 中心扩散
//     * @param s
//     * @return
//     */
//    public int countSubstrings(String s) {
//        int res = 0;
//        for (int i = 0; i < s.length(); i++) {
//            int c1 = circleCount(s, i, i);
//            int c2 = circleCount(s, i, i + 1);
//            res += c1 + c2;
//        }
//        return res;
//    }
//
//    public int circleCount(String s, int l, int r){
//        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
//            l--;
//            r++;
//        }
//        return l - r / 2;
//    }
}
