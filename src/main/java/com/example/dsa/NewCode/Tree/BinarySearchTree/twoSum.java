package com.example.dsa.NewCode.Tree.BinarySearchTree;

import java.util.*;

// use the next element triversal of binary tree for both left and right and get the next element and calculate the result, time complexity: O(n) + O(n) and space complexty :O(height of tree)
//  using inorder , time complexity will be same but the space complexity will be O(2n) 
class BSTIterator {
    Stack<Node> stack = new Stack<>();
    boolean reverse = true;

    BSTIterator(Node node, boolean isReverse) {
        reverse = isReverse;
        pushAll(node);
    }

    public void pushAll(Node node) {
        while (node != null) {
            stack.push(node);
            node = (reverse) ? node.right : node.left;
        }
    }

    public int next() {
        Node node = stack.pop();
        pushAll(!reverse ? node.right : node.left);
        return node.value;
    }

}

public class twoSum {

    private static boolean findTarget(Node node, int k) {
        if (node == null)
            return false;

        BSTIterator l = new BSTIterator(node, false);
        BSTIterator r = new BSTIterator(node, true);

        int i = l.next();
        int j = r.next();

        while (i < j) {
            if (i + j == k)
                return true;
            else if (i + j < k) {
                i = l.next();
            } else {
                j = r.next();
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Node node = new Node(7);
        node.left = new Node(3);
        node.right = new Node(10);
        node.left.left = new Node(2);
        node.left.right = new Node(6);
        node.right.left = new Node(9);
        node.right.right = new Node(11);
        node.left.left.left = new Node(1);
        node.left.right.left = new Node(5);
        node.right.left.left = new Node(8);
        node.left.right.left.left = new Node(4);

        System.out.println(findTarget(node, 1));

    }

}
