package com.example.dsa.NewCode.BinaryTree;

import java.util.*;

public class SerializeDeserialize {

    private static String serializer(Node head) {
        StringBuilder result = new StringBuilder();

        if (head == null)
            return result.toString();

        Queue<Node> queue = new LinkedList<>();
        queue.add(head);

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node != null) {
                result.append(node.val).append(",");
                queue.add(node.left);
                queue.add(node.right);
            } else {
                result.append("#,");
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
