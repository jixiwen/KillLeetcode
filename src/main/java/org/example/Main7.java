package org.example;

public class Main7 {

    public static void main(String[] args) {
//        Integer[] ints = new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5};
//        TreeNode root = new TreeNode()
//        for (int i = 0; i < ints.length; i++) {
//
//        }
    }


//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        while ((long) (root.val - p.val) * (root.val - q.val) > 0) {
//            root = root.val > p.val ? root.left : root.right;
//        }
//        return root;
//    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null){
            return right;
        }
        if (right == null){
            return left;
        }
        return root;
    }


    // Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
