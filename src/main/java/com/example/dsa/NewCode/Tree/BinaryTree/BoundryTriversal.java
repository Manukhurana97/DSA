package com.example.dsa.NewCode.Tree.BinaryTree;

import java.util.ArrayList;
import java.util.*;

public class BoundryTriversal {

    private static List<Integer> getBoundry(Node head) {
        List<Integer> result = new ArrayList<>();
        if (!isLeaf(head))
            result.add(head.val);
        addLeft(head, result);
        addLeaf(head, result);
        addRight(head, result);

        return result;
    }

    private static void addLeft(Node head, List<Integer> list) {
        Node current = head.left;

        while (current != null) {
            if (!isLeaf(current))
                list.add(current.val);
            current = (current.left != null) ? current.left : current.right;
        }
    }

    private static void addRight(Node head, List<Integer> list) {
        Node current = head.right;
        ArrayList<Integer> temp = new ArrayList<>();

        while (current != null) {
            if (!isLeaf(current))
                temp.add(current.val);
            current = (current.right != null) ? current.right : current.left;
        }

        for (int i = temp.size() - 1; i >= 0; i--)
            list.add(temp.get(i));
    }

    private static void addLeaf(Node head, List<Integer> list) {
        if (isLeaf(head)) {
            list.add(head.val);
            return;
        }
        if (head.left != null)
            addLeaf(head.left, list);
        if (head.right != null)
            addLeaf(head.right, list);
    }

    private static boolean isLeaf(Node head) {
        return (head.left == null && head.right == null);
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        System.out.println(getBoundry(head));
    }

}

// 1
// 2 3
// 4 5 6 7
