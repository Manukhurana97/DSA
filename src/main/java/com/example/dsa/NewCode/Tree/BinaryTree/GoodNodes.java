package com.example.dsa.NewCode.Tree.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class GoodNodes {
    public int goodNodes(TreeNode root) {
        if (root == null)
            return 0;

        int[] arr = { 0 };
        getGoodNodes(root, arr, Integer.MIN_VALUE);

        return arr[0];
    }

    private void getGoodNodes(TreeNode root, int[] arr, int maxTillNow) {
        if (root == null)
            return;

        if (root.val >= maxTillNow) {
            arr[0] += 1;
            maxTillNow = root.val;
        }
        getGoodNodes(root.left, arr, maxTillNow);
        getGoodNodes(root.right, arr, maxTillNow);
    }

    private int getGoodNodes1(TreeNode root, int max) {
        if (root == null)
            return 0;

        int res = (root.val >= max) ? 1 : 0;
        max = Math.max(max, root.val);

        res += getGoodNodes1(root.left, max);
        res += getGoodNodes1(root.right, max);

        return max;
    }

    public static void main(String[] args) {

    }
}
