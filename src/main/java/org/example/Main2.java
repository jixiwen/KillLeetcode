package org.example;

public class Main2 {

    public static void main(String[] args) {
        Node node = new Node(1, null);
        Node node2 = new Node(2, node);
        Node node3 = new Node(3, node2);
        Node node4 = new Node(4, node3);
        Node node5 = new Node(5, node4);
        Node p = node5;
        while (p != null){
            System.out.println(p.val);
            p = p.next;
        }
        System.out.println("==================");
        Node reverse = reverse(node5);
        while (reverse != null){
            System.out.println(reverse.val);
            reverse = reverse.next;
        }
    }


    public static Node reverse(Node head){
        Node res = head;
        while (res.next != null){
            res = res.next;
        }
        Node pre = head;
        Node t = pre.next;
        pre.next = null;
        while (t != null){
            Node next = t.next;
            t.next = pre;
            pre = t;
            t = next;
        }
        return res;
    }

    static class Node{
        private int val;
        private Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}
