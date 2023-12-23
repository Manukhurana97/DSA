package com.example.dsa.NewCode.Tree.BinaryTree;

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

    private static Node deSerializer(String str) {
        if (str == null || str.equals(""))
            return null;

        Node head = buildTreefromString(str);
        return head;
    }

    private static Node buildTreefromString(String str) {

        var charList = str.split(",");

        int index = 0;
        Node head = new Node(Integer.parseInt(charList[index++]));

        Queue<Node> queue = new LinkedList<>();
        queue.add(head);

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (index < charList.length && !charList[index].equals("#")) {
                node.left = new Node(Integer.parseInt(charList[index]));
                queue.add(node.left);
            }
            index++;

            if (index < charList.length && !charList[index].equals("#")) {
                node.right = new Node(Integer.parseInt(charList[index]));
                queue.add(node.right);
            }
            index++;

        }

        return head;
    }

    private static void display(Node head) {
        if (head == null)
            return;

        display(head.left);
        System.out.print(head.val + " ");
        display(head.right);
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(13);
        head.right.left = new Node(4);
        head.right.right = new Node(5);

        var serialized = serializer(head);
        deSerializer(serialized);

    }

}
