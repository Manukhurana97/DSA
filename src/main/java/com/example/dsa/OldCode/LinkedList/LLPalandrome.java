package OldCode.LinkedList;


/**
 * Find the mid element (fast and slow technique)
 * reverse the list from mid element
 * compare each element, if not match return false
 * */

public class LLPalandrome {

    static Node head;

    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }


    public static Node findMid(Node node) {
        Node fast = node;
        Node slow = node;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node reverse(Node node) {
        Node top = node;
        Node sec = node.next;
        while (sec != null) {
            node.next = sec.next; // 1 3 4 5
            sec.next = top;
            top = sec;
            sec = node.next;
        }

        return top;
    }


    public static boolean checkPalandrome() {
        if (head == null) return false;
        Node temp = head;

        Node mid = findMid(temp); // get mid element

        Node tail = reverse(mid);  // get the last element

        while (head != tail) {

            if (head.data != tail.data) return false;

            tail = tail.next;
            head = head.next;
        }

        return true;
    }


    public static void main(String[] args) {
        Node node = new Node('a');
        head = node;
        head.next = new Node('b');
        head.next.next = new Node('a');

        boolean flag = checkPalandrome();
        System.out.println("palandrome :" + flag);

    }
}
