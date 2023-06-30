package OldCode.LinkedList;

import java.util.NoSuchElementException;

public class LinkedList<E> {

    private Node head;
    private Node last;

   private int size = 0;

    private class Node {
        E element;
        Node next;

        Node(E element) {
            this.element = element;
            this.next = null;
        }
    }

    public boolean add(E element) {
        return addLast(element);
    }

    /**
     * add the element at the specific place
     */

    public boolean add(int index, E element) {
        checkPoint(index);

        if (index == size) add(element);
        else addMid(index, element);
        return true;
    }


    public boolean addFirst(E element) {
        if (head == null) add(element);

        final Node node = new Node(element);

        node.next = head;
        head = node;

        return true;
    }

    private boolean addMid(int index, E element) {
        final Node node = new Node(element);

        Node temp = head;
        while (--index != 0)
            temp = node.next;

        node.next = temp.next;
        temp.next = node;

        return true;

    }

    public boolean addLast(E element) {
        final Node node = new Node(element);

        if (last == null)
            head = node;
        else
            last.next = node;
        last = node;

        size++;
        return true;
    }

    public E remove() {
        removeCheckPoint();
        return unlinkElement();

    }

    public E remove(int index) {
        checkPoint(index);
        return unlinkMid(index);
    }


    public E removeFirst() {
        return remove();
    }

    public E removeLast() {
        removeCheckPoint();
        return unlinkLast();
    }

    private E unlinkElement() {
        final Node node = head;
        final E element = node.element;

        if (head.next == null) {
            head = last = null;
        } else {
            head = head.next;
        }

        node.element = null;
        node.next = null;
        size--;
        return element;
    }

    private E unlinkMid(int index) {
        Node node = head;
        while (--index != 0)
            node = node.next;

        final Node node1 = node;
        final E element = node1.element;
        node1.next = null;
        node1.element = null;

        size--;

        return element;
    }

    private E unlinkLast() {
        Node node = head;
        final E element = last.element;

        while (node.next != null) {
            node = node.next;
        }

        last.element = null;
        last = node;
        last.next = null;


        return element;
    }


    private void removeCheckPoint() {
        if (head == null) throw new NoSuchElementException();
    }


    private void checkPoint(int index) {
        if (index > size) throw new IndexOutOfBoundsException(outOfBound(index));
    }

    private String outOfBound(int index) {
        return "size: " + size + " index: " + index;
    }

    public boolean isEmpty() {
        return size <= 0;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        LinkedList<Integer> lst = new LinkedList<Integer>();

        for (int i = 0; i < 5; i++)
            lst.add(i);

        System.out.println("size "+lst.size());

        System.out.println(lst.remove(2));

    }


}


