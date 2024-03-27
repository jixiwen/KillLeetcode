package org.example;

import java.util.Scanner;

public class Main3 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String patterns = sc.nextLine();
        String word = sc.nextLine();
        String replace = patterns.replace("[", "").replace("]", "");
        String[] split = replace.split(",");
        System.out.println(getChildCount(split, word));
    }
    public static int getChildCount(String[] patterns, String word){
        int res = 0;
        for (int i = 0; i < patterns.length; i++) {

        }
        return res;
    }



}
