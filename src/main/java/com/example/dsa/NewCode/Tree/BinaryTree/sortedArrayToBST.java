package com.example.dsa.NewCode.Tree.BinaryTree;

public class sortedArrayToBST {

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;

        return helper(nums, 0, nums.length - 1);
    }

    private static TreeNode helper(int[] arr, int start, int end) {

        if (start > end)
            return null;

        int mid = (start + end) / 2;
        int val = arr[mid];

        TreeNode node = new TreeNode(val);

        node.left = helper(arr, start, mid - 1);
        node.right = helper(arr, mid + 1, end);

        return node;
    }

    private static void inOrder(TreeNode node) {
        if (node == null)
            return;

        inOrder(node.left);
        System.out.println(node.val);
        inOrder(node.right);
    }

    public static void main(String[] args) {

        inOrder(sortedArrayToBST(new int[] { -10, -3, 0, 5, 9 }));
    }
}