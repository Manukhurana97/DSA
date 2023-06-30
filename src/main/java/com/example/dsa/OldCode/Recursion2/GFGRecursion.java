package OldCode.Recursion2;

import java.util.ArrayList;

public class GFGRecursion {


    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

//    https://practice.geeksforgeeks.org/problems/level-order-traversal-in-spiral-form/1?page=1&difficulty[]=0&category[]=OldCode.Recursion&sortBy=submissions
//    static ArrayList<Integer> findSpiral(Node root) {
//
//        if(root==null) return  new ArrayList<>();
//
//        Stack<Node> stack = new Stack<>();
//        Stack<Node> tempQueue = new Stack<>();
//        ArrayList<Integer> result = new ArrayList<>();
//        stack.add(root);
//        int i = 1;
//
//        while (!stack.isEmpty()) {
//            Node temp = stack.pop();
//            result.add(temp.data);
//
//            if ((i & 1) == 0) {
//                if (temp.left != null)
//                    tempQueue.add(temp.left);
//                if (temp.right != null)
//                    tempQueue.add(temp.right);
//
//            } else {
//                if (temp.right != null)
//                    tempQueue.add(temp.right);
//                if (temp.left != null)
//                    tempQueue.add(temp.left);
//            }
//            while (stack.isEmpty() && !tempQueue.isEmpty()) {
//                stack = tempQueue;
//                tempQueue = new Stack<>();
//                i++;
//            }
//        }
//        return result;
//
//    }

    static ArrayList<Integer> levelorderSpriral(Node root, int level, ArrayList<Integer> lst) {
        if (root == null) return lst;
        lst.add(root.data);


        if (((level & 1) == 0)) {
            levelorderSpriral(root.left, level + 1, lst);
            levelorderSpriral(root.right, level + 1, lst);
        } else {
            levelorderSpriral(root.right, level + 1, lst);
            levelorderSpriral(root.left, level + 1, lst);

        }
        return lst;
    }

    static ArrayList<Integer> findSpiral(Node root) {
        return levelorderSpriral(root, 0, new ArrayList<>());

    }


    static long power(int N, int R) {
        int newR = 0;
        while (R != 0) {
            newR = (newR * 10) + (R % 10);
            R /= 10;
        }
        return newR;

    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);


//        ArrayList<Integer> lst = findSpiral(root);
//        for (Integer data : lst)
//            System.out.println(data);

        System.out.println(power(2, 12));
    }
}
