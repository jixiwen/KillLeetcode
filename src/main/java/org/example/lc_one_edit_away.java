package org.example;

/**
 * @see <a href="https://leetcode.cn/problems/one-away-lcci/">面试题 01.05. 一次编辑</a>
 */
public class lc_one_edit_away {

    public static void main(String[] args) {
        System.out.println(oneEditAway("teacher", "taches"));
    }

    public static boolean oneEditAway(String first, String second) {
        int away = first.length() - second.length();
        if (away == 1) {
            return check(first, second);
        } else if (away == -1) {
            return check(second, first);
        } else if (away == 0){
            boolean flag = false;
            for (int i = 0; i < first.length(); i++) {
                if (first.charAt(i) != second.charAt(i)){
                    if (flag){
                        return false;
                    }
                    flag = true;
                }
            }
            return true;
        }

        return false;
    }

    public static boolean check(String first, String second){
        for (int i = 0, j = 0; i < first.length() && j < second.length(); ) {
            if (first.charAt(i) != second.charAt(j)){
                i++;
                if (i > j + 1){
                    return false;
                }
                continue;
            }
            i++;
            j++;
        }
        return true;
    }

    // 动态规划
//    public static boolean oneEditAway(String first, String second) {
//        int away = first.length() - second.length();
//        if (away > 1 || away < -1){
//            return false;
//        }
//        int[][] dp = new int[first.length() + 1][second.length() + 1];
//
//        for (int i = 0; i < dp[0].length; i++) {
//            dp[0][i] = i;
//        }
//
//        for (int i = 1; i <= first.length(); i++) {
//            dp[i][0] = i;
//            for (int j = 1; j <= second.length(); j++) {
//                if (first.charAt(i - 1) == second.charAt(j - 1)){
//                    dp[i][j] = dp[i - 1][j - 1];
//                } else {
//                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1));
//                }
//            }
//        }
//        BaseUtil.print(dp);
//        return dp[first.length()][second.length()] < 2;
//    }
}
