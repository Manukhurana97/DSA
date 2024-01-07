package com.example.dsa.NewCode.Tree.BinaryTree;

public class RobberHouse3 {

    public int rob(TreeNode root) {

        int[] result = helper(root);

        return Math.max(result[0], result[1]);
    }

    private int[] helper(TreeNode root) {
        if (root == null)
            // with root, without root
            return new int[] { 0, 0 };

        var l = helper(root.left);
        var r = helper(root.right);

        int[] arr = new int[2];
        arr[0] = (root.val + l[1] + r[1]); // with root, we can take child root
        // max b/w with and without root (left, right)
        arr[1] = (Math.max(l[0], l[1]) + Math.max(r[0], r[1])); // without root we choose to take/dont take the root
                                                                // based on max sum

        return arr;
    }

}
