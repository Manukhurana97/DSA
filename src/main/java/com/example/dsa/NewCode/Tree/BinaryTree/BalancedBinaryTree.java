package com.example.dsa.NewCode.Tree.BinaryTree;

public class BalancedBinaryTree {

    public static boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        var l = isBalancedHelper(root.left);
        var r = isBalancedHelper(root.right);

        if (Math.abs(l - r) >= 1)
            return false;

        return (isBalanced(root.left) && isBalanced(root.right));
    }

    private static int isBalancedHelper(TreeNode root) {

        if (root == null)
            return 0;

        return 1 + Math.max(isBalancedHelper(root.left), isBalancedHelper(root.right));
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);

        // TreeNode node = new TreeNode(1);
        // node.left = new TreeNode(2);
        // node.right = new TreeNode(2);
        // node.left.left = new TreeNode(3);
        // node.left.right = new TreeNode(3);
        // node.left.left.right = new TreeNode(4);
        // node.left.left.left = new TreeNode(4);

        System.out.println(isBalanced(node));
    }
}
