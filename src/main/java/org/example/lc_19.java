package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.cn/problems/remove-nth-node-from-end-of-list/description/">19. 删除链表的倒数第 N 个结点</a>
 */
public class lc_19 {

//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        List<ListNode> list = new ArrayList<>();
//        ListNode node = head;
//        while (node != null){
//            list.add(node);
//            node = node.next;
//        }
//        int delete = list.size() - n;
//        ListNode node1 = list.get(delete);
//        if (delete == 0){
//            return node1.next;
//        }
//        ListNode node2 = list.get(delete - 1);
//        node2.next = node1.next;
//        return head;
//    }

    public ListNode removeNthFromEnd(ListNode head, int n){
        int fast = 1;
        ListNode node = head;
        while (fast < n){
            fast++;
            node = node.next;
        }
        if (node == null){
            return null;
        }
        ListNode pre = null;
        ListNode slowNode = head;
        while (node.next != null){
            pre = slowNode;
            slowNode = slowNode.next;
            node = node.next;
        }
        if (pre == null){
            return head.next;
        }
        pre.next = slowNode.next;
        return head;
    }


    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
