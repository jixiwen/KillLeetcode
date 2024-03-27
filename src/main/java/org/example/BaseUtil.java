package org.example;

import java.util.Arrays;

public class BaseUtil {

    public static void print(int[] dp){
        System.out.println(Arrays.toString(dp));
        System.out.println("--------------");
    }

    public static void print(int[][] dp){
        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println("--------------");
    }

    public static void print(boolean[][] dp){
        for (boolean[] booleans : dp) {
            System.out.println(Arrays.toString(booleans));
        }
        System.out.println("--------------");
    }
}
