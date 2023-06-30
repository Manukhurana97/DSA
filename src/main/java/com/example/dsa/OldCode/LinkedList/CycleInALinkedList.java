package OldCode.LinkedList;

/**
 * Find if list is cyclic
 * <p>
 * make all integer negative if we find the negative number the list is cyclic.
 */
public class CycleInALinkedList {

    Node head;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public boolean checkCyclic(Node node) {
        Node temp = node;
        Node prev = temp;
        while (temp != null) {

            if (temp.data < 0) {
                prev.next = null;  // breaking cycle
                System.out.println("Cycle from " + (prev.data * -1) + " to " + (temp.data * -1));
                return true;
            }
            temp.data *= -1;
            prev = temp;
            temp = temp.next;
        }
        return false;
    }


    public Node detectCycle(Node node) {
        Node slow = head;
        Node fast = head;
        while (fast != null && node.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return node;
            }
        }

        return null;
    }

    public void detectNode(Node node) {
        Node temp = detectCycle(node);
        Node start = head;
        while (start != temp) {
            start = start.next;
            temp = temp.next;
        }
        System.out.println(start.data);
    }


    public static void main(String[] args) {
        CycleInALinkedList cycle = new CycleInALinkedList();
        cycle.head = cycle.new Node(10);
        cycle.head.next = cycle.new Node(20);
        cycle.head.next.next = cycle.new Node(30);
        cycle.head.next.next.next = cycle.new Node(40);
        cycle.head.next.next.next.next = cycle.head.next;

//        boolean flag = cycle.checkCyclic(cycle.head);
//        System.out.println("Cyclic " + flag);

//        Node temp = cycle.detectCycle(cycle.head);
//        System.out.println(temp.data);


        cycle.detectNode(cycle.head);
    }

}
