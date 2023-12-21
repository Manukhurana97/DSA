package com.example.dsa.NewCode.BinaryTree;

import java.util.*;

public class SerializeDeserialize {

    private static String serializer(Node head) {
        StringBuilder result = new StringBuilder();

        if (head == null)
            return result.toString();

        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        result.append(head.val).append(",");

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.left != null) {
                queue.add(node.left);
                result.append(node.left.val).append(",");
            } else {
                result.append("#").append(",");
            }
            if (node.right != null) {
                queue.add(node.right);
                result.append(node.right.val).append(",");
            } else {
                result.append("#").append(",");
            }
        }

        return result.toString();
    }

    // private static Node deSerializer(String str) {
    // return null;
    // }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(13);
        head.right.left = new Node(4);
        head.right.right = new Node(5);

        System.out.println(serializer(head));

    }

}
