package com.example.dsa.NewCode.Tree.BinaryTree;

import java.util.*;

public class NodeToRoot {

    public static List<Integer> findPath(Node head, int destination) {
        List<Integer> path = new ArrayList<>();

        if (head == null)
            return path;
        findPathHelper(head, destination, path);

        return path;
    }

    private static boolean findPathHelper(Node head, int destination, List<Integer> path) {
        if (head == null) {
            return false;
        }

        path.add(head.val);

        if (head.val == destination)
            return true;

        if (findPathHelper(head.left, destination, path) || findPathHelper(head.right, destination, path))
            return true;

        path.remove(path.size() - 1);
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

        System.out.println(findPath(node, 7));
    }
}
