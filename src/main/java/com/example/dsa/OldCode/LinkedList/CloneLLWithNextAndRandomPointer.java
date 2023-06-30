package OldCode.LinkedList;

public class CloneLLWithNextAndRandomPointer {

    Node head;

    private class Node {
        int data;
        Node next;
        Node random;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.random = null;
        }

    }

    public Node deduplicateLL(Node node) {
        // 1  2  3  4  5
        //   1  2  3  4  5


        Node curr = head;
        while (curr != null) {
            Node temp = curr.next;
            curr.next = new Node(curr.data);
            curr.next.next = temp;
            curr = temp;
        }
        curr = head;

        // setting the random value
        while (curr != null) {
            if (curr.next != null)
                curr.next.next = (curr.random != null) ? curr.random.next : null;

            curr = curr.next.next;
        }

        // separating both the ll
        Node orig = head;
        Node copy = head.next;
        Node temp = copy;

        while (orig != null) {
            orig.next = orig.next.next;
            copy.next = copy.next.next;
            orig = orig.next;
            copy = copy.next;

        }

        return temp;

    }

    public static void main(String[] args) {
        CloneLLWithNextAndRandomPointer cloneLLWithNextAndRandomPointer = new CloneLLWithNextAndRandomPointer();
        cloneLLWithNextAndRandomPointer.head = cloneLLWithNextAndRandomPointer.new Node(10);
        cloneLLWithNextAndRandomPointer.head.next = cloneLLWithNextAndRandomPointer.new Node(20);
        cloneLLWithNextAndRandomPointer.head.next.random = cloneLLWithNextAndRandomPointer.head;
        cloneLLWithNextAndRandomPointer.head.next.next = cloneLLWithNextAndRandomPointer.new Node(30);
        cloneLLWithNextAndRandomPointer.head.random = cloneLLWithNextAndRandomPointer.head.next.next;
        cloneLLWithNextAndRandomPointer.head.next.next.next = cloneLLWithNextAndRandomPointer.new Node(40);
        cloneLLWithNextAndRandomPointer.head.next.next.random = cloneLLWithNextAndRandomPointer.head.next.next;
        cloneLLWithNextAndRandomPointer.head.next.next.next.next = cloneLLWithNextAndRandomPointer.new Node(50);
    }
}
