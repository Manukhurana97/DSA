package OldCode.LinkedList;

public class ReverseALinkedList {

    static Node head;


    static class Node {
        Node next;
        int data;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node reverse(Node node) {
        Node top = node;
        Node sec = node.next;

        while(sec!=null){
            node.next = sec.next;
            sec.next = top;
            top = sec;
            sec = node.next;
        }



        return top;
    }

    public static Node reverseRecursion(Node head){
        if(head==null || head.next==null)
            return head;

        // 1 2 3 4 5

        Node node = reverseRecursion(head.next);  // 5
        Node headNode = head.next;   // 5
        headNode.next = head; //4:  1->2>3->4->5->4
        head.next = null;  // 1->2->3 5->4 || 3->4
        return node;

    }



    public static void display(Node node) {


        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }

    }


    public static void main(String[] args) {
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        Node temp = reverseRecursion(head);
        display(temp);


    }
}



