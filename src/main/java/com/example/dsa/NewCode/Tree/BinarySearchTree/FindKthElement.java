package com.example.dsa.NewCode.Tree.BinarySearchTree;

// in case of finding larger element , user any triversal algo (inorder,preOrder,PostOrder, moris) to count the number of element in tree and the k = NUmOfNOdes-k+1
public class FindKthElement {

    private static int findKthSmallestElement(Node node, int k) {
        int[] result = { k, 0 };
        // findKthSmallestElement(node, result);
        findKthSmallestElementMorisTraversal(node, result);
        return result[0];
    }

    private static void findKthSmallestElement(Node node, int[] result) {

        if (node == null)
            return;

        findKthSmallestElement(node.left, result);
        if (--result[0] > 0)
            return;
        result[1] = node.value;
        findKthSmallestElement(node.right, result);

    }

    private static void findKthSmallestElementMorisTraversal(Node node, int[] result) {

        Node current = node;

        while (current != null) {

            if (current.left == null) {
                if (result[0] <= 0) {
                    result[1] = current.value;
                    break;
                }
                current = current.right;
            } else {
                Node rightNode = current.left;
                while (rightNode.right != null && rightNode.right != current)
                    rightNode = rightNode.right;

                if (rightNode.right == null) {
                    rightNode.right = current;
                    current = current.left;
                } else {
                    rightNode.right = null;
                    if (result[0] <= 0) {
                        result[1] = current.value;
                        break;
                    }
                    current = current.right;
                }
            }
        }
    }

    public static void main(String[] args) {
        Node node = new Node(5);
        node.left = new Node(3);
        node.left.left = new Node(1);
        node.left.left.right = new Node(2);
        node.left.right = new Node(4);
        node.right = new Node(7);
        node.right.left = new Node(6);
        node.right.right = new Node(8);

        System.out.println(findKthSmallestElement(node, 3));
    }
}
