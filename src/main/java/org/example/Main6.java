package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main6 {

    public static void main(String[] args) {
        Node a = new Node("a", null, "a");
        Node b = new Node("b", "a", "b");
        Node c = new Node("c", "a", "c");
        Node d = new Node("d", "c", "d");
        List<Node> nodes = new ArrayList<>();
        nodes.add(a);
        nodes.add(b);
        nodes.add(c);
        nodes.add(d);
        Node tree = toTree(nodes);
    }
    public static Node toTree(List<Node> nodes){
        Node root = new Node();
        for (Node node : nodes) {
            if (node.parent == null){
                root = node;
                break;
            }
        }
        setChild(nodes, root);
        return root;
    }

    public static void setChild(List<Node> nodes, Node root){
        List<Node> child = new ArrayList<>();
        root.children = child;
        for (Node node : nodes) {
            if (root.code.equals(node.parent)){
                root.children.add(node);
            }
        }
        for (Node node : child) {
            setChild(nodes, node);
        }
    }

    static class Node{
        public String code;
        public String parent;
        public String name;
        public List<Node> children;

        public Node(String code, String parent, String name) {
            this.code = code;
            this.parent = parent;
            this.name = name;
        }

        public Node() {
        }
    }
}
