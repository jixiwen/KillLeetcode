package org.example;

import java.util.HashMap;
import java.util.Map;

public class Main8 {
    public static void main(String[] args) {
        TailTree tailTree = new TailTree(new Node(null, false));
        tailTree.add("hello");
        System.out.println(tailTree.find("hello"));
        System.out.println(tailTree.findPrefix("h"));
        System.out.println(tailTree.findPrefix(""));
        System.out.println(tailTree.findPrefix(null));
    }

    static class TailTree{
        Node root;

        public TailTree(Node root) {
            this.root = root;
        }

        public void add(String val){
            if (val == null || val.isEmpty()){
                return;
            }
            Map<Character, Node> nexts = root.nexts;
            Node endNode = null;
            char[] charArray = val.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                char c = charArray[i];
                if (!nexts.containsKey(c)) {
                    nexts.put(c, new Node(c, false));
                }
                endNode = nexts.get(c);
                nexts = nexts.get(c).nexts;
            }
            endNode.end = true;
        }


        public boolean find(String val){
            if (val == null || val.isEmpty()){
                return false;
            }
            Map<Character, Node> nexts = root.nexts;
            Node endNode = null;
            char[] charArray = val.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                char c = charArray[i];
                if (!nexts.containsKey(c)) {
                    return false;
                }
                endNode = nexts.get(c);
                nexts = nexts.get(c).nexts;
            }
            return endNode.end;
        }
        public boolean findPrefix(String val){
            if (val == null || val.isEmpty()){
                return false;
            }
            Map<Character, Node> nexts = root.nexts;
            char[] charArray = val.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                char c = charArray[i];
                if (!nexts.containsKey(c)) {
                    return false;
                }
                nexts = nexts.get(c).nexts;
            }
            return true;
        }
    }

    static class Node{
        private Map<Character, Node> nexts;

        private Character val;

        private boolean end;

        Node(Character val, boolean end){
            this.val = val;
            this.end = end;
            this.nexts = new HashMap<>();
        }
    }
}
