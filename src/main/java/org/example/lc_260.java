package org.example;

import java.util.Arrays;

public class lc_260 {

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(singleNumber(new int[]{1,2,1,3,2,5})));

        for (int i = 0; i < 20; i++) {
            System.out.println(Integer.toBinaryString(i));
            System.out.println(Integer.toBinaryString(-i));
            System.out.println("===============");
        }

    }

    public static int[] singleNumber(int[] nums) {
        int xorsum = 0;
        for (int num : nums) {
            xorsum ^= num;
        }

        System.out.println(Integer.toBinaryString(xorsum));
        System.out.println(Integer.toBinaryString(-xorsum));
        // 防止溢出
        int lsb = (xorsum == Integer.MIN_VALUE ? xorsum : xorsum & (-xorsum));
        int type1 = 0, type2 = 0;
        for (int num : nums) {
            if ((num & lsb) != 0) {
                type1 ^= num;
            } else {
                type2 ^= num;
            }
        }
        return new int[]{type1, type2};
    }
}
