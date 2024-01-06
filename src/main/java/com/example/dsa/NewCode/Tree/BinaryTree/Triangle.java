package com.example.dsa.NewCode.Tree.BinaryTree;

import java.util.List;

public class Triangle {

    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }

        return findPathWithSum(createTree(triangle, 0, 0));
    }

    private static TreeNode createTree(List<List<Integer>> triangle, int index, int level) {
        if (level == triangle.size()) {
            return null;
        }

        TreeNode node = new TreeNode(triangle.get(level).get(index));

        node.left = createTree(triangle, index, level + 1);
        node.right = createTree(triangle, index + 1, level + 1);

        return node;
    }

    public static int findPathWithSum(TreeNode node) {
        if (node == null)
            return 0;

        int left = findPathWithSum(node.left);
        int right = findPathWithSum(node.right);

        return node.val + Math.min(left, right);

    }

    // ----------------------------------------------------------------------- case
    // 2
    // ------------------------------------------------------------------------------------

    public int minimumTotal1(List<List<Integer>> triangle) {
        if (triangle.size() == 1)
            return triangle.get(0).get(0);

        int[] arr = new int[triangle.get(triangle.size() - 1).size() + 1];

        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                arr[j] = triangle.get(i).get(j) + Math.min(arr[j], arr[j + 1]);
            }

        }
        return arr[0];
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle1 = List.of(
                List.of(2),
                List.of(3, 4),
                List.of(6, 5, 7),
                List.of(4, 1, 8, 3));

        createTree(triangle1, 0, 0);
    }

}
