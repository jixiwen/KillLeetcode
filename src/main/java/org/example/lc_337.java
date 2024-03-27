package org.example;

/**
 * @see <a href="https://leetcode.cn/problems/house-robber-iii/description/">337. 打家劫舍 III</a>
 */
public class lc_337 {

    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    public int[] dfs(TreeNode node){
        if (node == null){
            return new int[]{0,0};
        }
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        int m = node.val + left[1] + right[1];
        int n = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{m, n};
    }


    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
