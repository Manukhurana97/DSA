package com.example.dsa.NewCode.BinaryTree;

class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
    }
}

public class MaxPathSum {

    public static int getMaxSum(Node head, int max) {

        if (head == null)
            return 0;

        var ls = getChildSum(head.left);
        var rs = getChildSum(head.right);

        max = Math.max(max, (ls + rs + head.val)); // leftSum + rightSum + currentHead.val

        return Math.max(max, Math.max(getMaxSum(head.left, max), getMaxSum(head.right, max))); // max of (currentMax,
                                                                                               // leftMax, rightMax)
    }

    public static int getChildSum(Node head) {
        if (head == null)
            return 0;

        return head.val + getChildSum(head.left) + getChildSum(head.right);
    }

    public static int getMaxSum1(Node head, int[] max) {
        if (head == null)
            return 0;

        int ls = Math.max(0, getMaxSum1(head.left, max));
        int rs = Math.max(0, getMaxSum1(head.right, max));

        max[0] = Math.max(max[0], (ls + rs + head.val));

        return head.val + Math.max(ls, rs);
    }

    public static void main(String[] args) {
        Node head = new Node(-10);
        head.left = new Node(9);
        head.right = new Node(20);
        head.right.left = new Node(15);
        head.right.right = new Node(7);

        System.out.println(getMaxSum(head, 0));
        int[] arr = new int[1];
        getMaxSum1(head, arr);
        System.out.println(arr[0]);
    }

}
