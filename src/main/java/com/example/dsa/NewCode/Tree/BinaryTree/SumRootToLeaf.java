package com.example.dsa.NewCode.Tree.BinaryTree;

// https://leetcode.com/problems/sum-root-to-leaf-numbers/
public class SumRootToLeaf {

    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;

        long[] totalSum = { 0 };
        helper(root, 0, totalSum, root);
        return (int) (totalSum[0] / 2);
    }

    private void helper(TreeNode root, int val, long[] total, TreeNode prev) {
        if (root == null) {
            if (prev.left == null && prev.right == null)
                total[0] += val;
            return;
        }

        prev = root;
        helper(root.left, val * 10 + root.val, total, prev);
        helper(root.right, val * 10 + root.val, total, prev);
    }

}
