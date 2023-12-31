package com.example.dsa.NewCode.Tree.BinaryTree;

import java.util.*;

public class ParentNode {

    private static List<Integer> findAncestors(Node head, int num) {
        List<Integer> list = new ArrayList<>();
        findAncestorsHelper(head, num, list);
        // findAncestorsHelper1(head, num, list);

        // PreOrder, to get the lowerest common ansistor print , last element of list
        return list;
    }

    // add to list in top
    private static boolean findAncestorsHelper(Node head, int num, List<Integer> list) {
        if (head == null)
            return false;

        if (head.val == num) {
            return true;
        }
        list.add(head.val);

        if (findAncestorsHelper(head.left, num, list) || findAncestorsHelper(head.right, num, list)) {
            return true;
        }

        list.remove(list.size() - 1);

        return false;

    }

    // post order, add to list in last after we found the destination
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
        node.left.right.right.left = new Node(10);
        node.left.right.right.left.left = new Node(11);
        node.right.left = new Node(8);
        node.right.right = new Node(9);

        System.out.println(findAncestors(node, 11));
    }
}