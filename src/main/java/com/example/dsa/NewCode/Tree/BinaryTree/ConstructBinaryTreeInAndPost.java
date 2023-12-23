package com.example.dsa.NewCode.Tree.BinaryTree;

import java.util.*;

public class ConstructBinaryTreeInAndPost {

    private static Node constructTree(int[] inOrder, int[] postOrder) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inOrder.length; i++) {
            map.put(inOrder[i], i);
        }

        return constructTree(inOrder, 0, inOrder.length - 1, postOrder, 0, postOrder.length - 1, map);

    }

    private static Node constructTree(int[] inOrder, int inOrderStart, int inOrderEnd, int[] postOrder,
            int postOrderStart, int postOrdEnd, Map<Integer, Integer> map) {

        if (postOrderStart > postOrdEnd || inOrderStart > inOrderEnd)
            return null;

        Node node = new Node(postOrder[postOrdEnd]);

        int index = map.get(postOrder[postOrdEnd]);
        int left = index - inOrderStart; // reason of this is, in next step start will start from in b/w.

        node.left = constructTree(inOrder, inOrderStart, index - 1, postOrder, postOrderStart,
                postOrderStart + left - 1,
                map);
        node.right = constructTree(inOrder, index + 1, inOrderEnd, postOrder, postOrderStart + left, postOrdEnd - 1,
                map);

        return node;
    }

    private static void display(Node head) {
        if (head == null)
            return;

        display(head.left);
        System.out.println(head.val);
        display(head.right);
    }

    public static void main(String[] args) {
        Node head = constructTree(new int[] { 40, 20, 50, 10, 60, 30 }, new int[] { 40, 50, 20, 60, 30, 10 });
        display(head);
    }
}