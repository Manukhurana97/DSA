package com.example.dsa.NewCode.Tree.BinaryTree;

import java.util.*;

public class ZigZag {

    private static List<Integer> display(Node head) {
        Queue<Node> queue = new LinkedList<>();
        List<Node> aux = new LinkedList<>();
        List<Integer> result = new LinkedList<>();
        queue.add(head);
        result.add(head.val);
        int level = 0;

        while (!queue.isEmpty()) {
            Node temp = queue.remove();

            if (temp.left != null)
                aux.add(temp.left);
            if (temp.right != null)
                aux.add(temp.right);

            if (queue.isEmpty() && !aux.isEmpty()) {
                queue.addAll(aux);

                if (level % 2 == 0)
                    Collections.reverse(aux);
                for (var n : aux)
                    result.add(n.val);
                aux.clear();
                level++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        System.out.println(display(head));
    }

}

// 1
// 2 3
// 4 5 6 7
// 1 3 2 4 5 6 7
// 1 3 2 5 4 7 6