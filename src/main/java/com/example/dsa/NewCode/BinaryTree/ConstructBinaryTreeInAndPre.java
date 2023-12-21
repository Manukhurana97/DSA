package com.example.dsa.NewCode.BinaryTree;

import java.util.*;

public class ConstructBinaryTreeInAndPre {

    private static Node constructTree(int[] inOrder, int[] preOrder) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inOrder.length; i++)
            map.put(inOrder[i], i);

        Node head = constructTree(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1, map);

        return head;
    }

    private static Node constructTree(int[] preOrder, int preOrderStart, int preOrderEnd, int[] inOrder,
            int inOrderStart, int inOrderEnd, Map<Integer, Integer> map) {
        if (preOrderStart > preOrderStart || inOrderStart > inOrderEnd)
            return null;

        Node node = new Node(preOrder[preOrderStart]);

        var inOrderIndex = map.get(node.val);
        int preEnd = inOrderIndex - inOrderStart;

        node.left = constructTree(preOrder, preOrderStart + 1, preOrderStart + preEnd, inOrder, inOrderStart,
                inOrderIndex - 1, map);
        node.right = constructTree(preOrder, preOrderStart + preEnd + 1, preOrderEnd, inOrder, inOrderIndex + 1,
                inOrderEnd, map);

        return node;

    }

    public static void main(String[] args) {
        Node head = constructTree(new int[] { 40, 20, 50, 10, 60, 30 }, new int[] { 10, 20, 40, 50, 30, 60 });
    }
}
