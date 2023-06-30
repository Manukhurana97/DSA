package OldCode.Heap;

import java.util.PriorityQueue;

/**
 * we will going to create a tree with (min frequency)
 * we will use pQueue for storing the element with the min freq
 * <p>
 * char[] charArr = {'a', 'b', 'c', 'd', 'e', 'f'};
 * int[] arr = {5, 9, 12, 13, 16, 45};
 * <p>
 * 100(fcdabe)
 * 45(f)               55(cdabe)
 * 55(cdabe)           45(f)
 * 25(cd)                30(abe)  45(f) # sort
 * 30(abe)               25(cd)   45(f)
 * 14(ab)          16(e)         25(cd)   45(f)  # sort
 * 14(ab)          25(cd)        16(e)    45(f)
 * a(5)    b(9)    c(12)    d(13)    e(16)    f(45)
 * <p>
 * * left side: 0
 * * right side: 1
 * <p>
 * https://media.geeksforgeeks.org/wp-content/uploads/20220906180456/6.png
 */


public class HuffmanEncoding {

    static class Node {
        int data;
        char c;

        Node left;
        Node right;

        public Node(int data, char c, Node left, Node right) {
            this.data = data;
            this.c = c;
            this.left = left;
            this.right = right;
        }
    }


    public static void printNode(Node root, String s) {
        if (root.left == null || root.right == null && Character.isLetter(root.c)) {
            System.out.println(root.c + " " + s);
            return;
        }
        printNode(root.left, s + "0");
        printNode(root.right, s + "1");
    }

    public static void huffman(int[] arr, char[] charArr) {
        PriorityQueue<Node> queue = new PriorityQueue<>(charArr.length,
                (Node n1, Node n2) -> n1.data - n2.data);


        // all the char and number without any connection (base layer)
        for (int i = 0; i < charArr.length; i++)
            queue.add(new Node(arr[i], charArr[i], null, null));


        // take the 2 minimum element and create a connection until we create top of tree (sum of all the node)
        while (queue.size() > 1) {
            Node n1 = queue.poll();
            Node n2 = queue.poll();

            queue.add(new Node((n1.data + n2.data), '-', n1, n2));
        }

        printNode(queue.peek(), "");
    }


    public static void main(String[] args) {
        char[] charArr = {'a', 'b', 'c', 'd', 'e', 'f'};
        int[] arr = {5, 9, 12, 13, 16, 45};

        huffman(arr, charArr);
    }
}







