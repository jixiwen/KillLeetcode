package org.example;

import java.util.*;

/**
 * @see <a href="https://leetcode.cn/problems/avoid-flood-in-the-city/description/?envType=daily-question&envId=2023-10-13">1488. 避免洪水泛滥</a>
 */
public class lc_1488 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(avoidFlood(new int[]{1,2,0,1,2})));
    }

    static Node head = new Node();
    static Node tail = head;

    public static int[] avoidFlood(int[] rains) {
        int[] res = new int[rains.length];
        Map<Integer, Integer> lakeRainDay = new HashMap<>();
        for (int i = 0; i < rains.length; i++) {
            // 1. 晴天，直接加一个晴天，跳过
            if (rains[i] == 0){
                add(i);
                continue;
            }
            // 2. 雨天，先处理必须处理的逻辑
            res[i] = -1;
            // 3. 获取上次该湖下雨是哪一天
            Integer rainDay = lakeRainDay.remove(rains[i]);
            // 4. 将本次该湖下雨的记录保存
            lakeRainDay.put(rains[i], i);
            // 5. 上次没下过雨，没有其他逻辑了
            if (rainDay == null){
                continue;
            }

            // 6. 获取上次该湖下雨之后的第一个晴天，用于抽取该湖
            int nextSunnyDay = findTargetNext(rainDay);
            if (nextSunnyDay < rainDay){
                // 7. 上次该湖下雨之后没有可用晴天，或者之后的晴天都被使用完了，返回失败结果
                return new int[]{};
            }
            // 8. 使用找到的晴天抽取该湖上次下的雨，记录该晴天抽取的湖为该湖
            res[nextSunnyDay] = rains[i];
        }
        // 9. 剩余未使用的晴天都随便抽一个湖
        Node node = head.next;
        while (node != null){
            res[node.val] = 1;
            node = node.next;
        }
        // 10. 返回结果
        return res;
    }

    static class Node{
        int val;
        Node next;
        Node pre;
    }

    static int findTargetNext(int target){
        if (head == tail || tail.val < target){
            return -1;
        }
        Node node = head.next;
        while (node.val < target){
            node = node.next;
        }
        if (node.next == null){
            node.pre.next = null;
            tail = node.pre;
        } else {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        return node.val;
    }

    static void add(int val){
        Node node = new Node();
        node.val = val;
        node.pre = tail;
        node.next = null;
        tail.next = node;
        tail = node;
    }


}
