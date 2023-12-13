package com.example.dsa.NewCode.BinaryTree;

import java.util.*;

public class LowestCommonAncestor {

    private static List<Integer> findAncestors(Node head, int num) {
        List<Integer> list = new ArrayList<>();
        findAncestorsHelper(head, num, list);
        findAncestorsHelper1(head, num, list);

        // to get the lowerest common ansistor print , last element of list
        return list;
    }

    private static boolean findAncestorsHelper(Node head, int num, List<Integer> list) {
        if (head == null)
            return false;

        if (head.left != null && head.right != null)
            list.add(head.val);

        if (head.val == num) {
            return true;
        }

        if (findAncestorsHelper(head.left, num, list) || findAncestorsHelper(head.right, num, list)) {
            return true;
        }

        if (head.left != null && head.right != null && head.val == list.get(list.size() - 1)) {
            list.remove(list.size() - 1);
        }

        return false;

    }

    private static boolean findAncestorsHelper1(Node head, int num, List<Integer> list) {
        if (head == null)
            return false;

        if (head.val == num) {
            return true;
        }

        if (findAncestorsHelper1(head.left, num, list) || findAncestorsHelper1(head.right, num, list)) {
            list.add(head.val);
            return true;
        }

        return false;

    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.left.right.left = new Node(6);
        node.left.right.right = new Node(7);
        node.right.left = new Node(8);
        node.right.right = new Node(9);

        System.out.println(findAncestors(node, 7));
    }
}