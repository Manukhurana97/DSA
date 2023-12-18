package com.example.dsa.NewCode.BinaryTree;

import java.util.*;

public class LowerCommonAncestor {

    public static int findAncestors(Node head, int l, int r) {
        if (head == null)
            return -1;

        List<Integer> lst1 = new ArrayList<>();
        getParent(head, lst1, l);
        List<Integer> lst2 = new ArrayList<>();
        getParent(head, lst2, r);

        int i = 0, j = 0, lowerAncestor = -1;
        while (i < lst1.size() && j < lst2.size()) {
            if (lst1.get(i) == lst2.get(j))
                lowerAncestor = lst1.get(i);
            i++;
            j++;

        }
        return lowerAncestor;
    }

    public static boolean getParent(Node head, List<Integer> lst, int val) {
        if (head == null)
            return false;

        lst.add(head.val);

        if (head.val == val)
            return true;
        if (getParent(head.left, lst, val) || getParent(head.right, lst, val))
            return true;

        lst.remove(lst.size() - 1);

        return false;
    }

    public static Node findLowerCommonStatus(Node head, int p, int q) {
        if (head == null || head.val == p || head.val == q)
            return head;

        Node left = findLowerCommonStatus(head.left, p, q);
        Node right = findLowerCommonStatus(head.right, p, q);

        if (left == null)
            return right;
        else if (right == null)
            return left;
        else
            return head;
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

        System.out.println(findAncestors(node, 4, 7));
        System.out.println(findLowerCommonStatus(node, 4, 7).val);
    }
}
