package com.example.dsa.NewCode.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWithOfBinaryTree {

    public static int widthOfBinaryTree(Node node) {
        Queue<NodeDetails> queue = new LinkedList<>();
        queue.add(new NodeDetails(0, 1, node));
        int result = 0, preLevel = 1, preNum = 0;

        while (!queue.isEmpty()) {
            var nodeDtls = queue.poll();
            var nde = nodeDtls.node;
            var num = nodeDtls.order;
            var level = nodeDtls.level;

            if (level > preLevel) {
                preLevel = level;
                preNum = num;
            }
            result = Math.max(result, num - preNum + 1);

            if (nodeDtls.node.left != null)
                queue.add(new NodeDetails(2 * num, level++, nde.left));

            if (nodeDtls.node.right != null)
                queue.add(new NodeDetails(2 * num + 1, level++, nde.right));

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
        // head.left.right.left = new Node(8);
        // head.left.right.right = new Node(9);

        System.out.println(widthOfBinaryTree(head));
    }

}
