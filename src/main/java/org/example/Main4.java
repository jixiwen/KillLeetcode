package org.example;

import java.util.*;
import java.util.stream.Collectors;

// 举例：
//[1, 4, 7, 11, 15],
//[2, 5, 8, 12, 19],
//[3, 6, 9, 16, 22],
//[10, 13, 14, 17, 24],
//[18, 21, 23, 26, 30]
//
//target 输入 5,  返回true.
//target 输入 20,  返回false.
public class Main4 {
    public static void main(String[] args) {
        int[][] source = new int[][]{{1, 4, 7, 11, 15},{2, 5, 8, 12, 19},{3, 6, 9, 16, 22},{10, 13, 14, 17, 24},{18, 21, 23, 26, 30}};
        Scanner sc = new Scanner(System.in);
        while (true){
            int target = sc.nextInt();
            System.out.println(contains(source, target));
        }
    }
    public static boolean contains(int[][] source, int target){
        for (int i = 0; i < source.length; i++) {
            if (source[i].length == 0){
                continue;
            }
            if (source[i][0] > target){
                return false;
            }
            if (findTarget(source[i], target, 0, source[i].length - 1) > -1){
                return true;
            }
        }
        return false;
    }
    public static int findTarget(int[] source, int target, int l, int r){
        while (l <= r){
            int mid = l + ((r - l) >> 1);
            if (source[mid] == target){
                return mid;
            }
            if (source[mid] > target){
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }


}
