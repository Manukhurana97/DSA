package com.example.dsa.NewCode.Tree.BinaryTree;

public class MaxPathSum {

    private static int getMaxSum(Node head, int max) {

        if (head == null)
            return 0;

        var ls = getChildSum(head.left);
        var rs = getChildSum(head.right);

        max = Math.max(max, (ls + rs + head.val)); // leftSum + rightSum + currentHead.val

        return Math.max(max, Math.max(getMaxSum(head.left, max), getMaxSum(head.right, max))); // max of (currentMax,
                                                                                               // leftMax, rightMax)
    }

    private static int getChildSum(Node head) {
        if (head == null)
            return 0;

        return head.val + getChildSum(head.left) + getChildSum(head.right);
    }

    private static int maxPathSum(TreeNode root, int[] max) {

        if (root == null)
            return Integer.MIN_VALUE;

        int ls = Math.max(0, maxPathSum(root.left, max));
        int rs = Math.max(0, maxPathSum(root.right, max));

        max[0] = Math.max(max[0], root.val + ls + rs);

        return Math.max(root.val, root.val + Math.max(ls, rs));

    }

    public static void main(String[] args) {
        Node head = new Node(-10);
        head.left = new Node(9);
        head.right = new Node(20);
        head.right.left = new Node(15);
        head.right.right = new Node(7);

        System.out.println(getMaxSum(head, 0));
        int[] arr = new int[1];
        maxPathSum(head, arr);
        System.out.println(arr[0]);
    }

}
