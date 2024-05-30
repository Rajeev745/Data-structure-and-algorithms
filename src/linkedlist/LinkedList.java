package linkedlist;

public class LinkedList {

    private Node head; // Use private for better encapsulation

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    // **Optimized addFirst**
    public LinkedList addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        return this; // Return the modified list for chaining
    }

    // **Optimized addLast** (iterative approach)
    public LinkedList addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return this;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        return this;
    }

    // **Simplified deleteFirst**
    public LinkedList deleteFirst() {
        if (head != null) {
            head = head.next;
        }
        return this;
    }

    // **Simplified deleteLast** (iterative approach)
    public LinkedList deleteLast() {
        if (head == null || head.next == null) {
            head = null;
            return this;
        }

        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
        return this;
    }

    // **Corrected deleteAtIdx using a single loop**
    public LinkedList deleteAtIdx(int index) {
        if (index < 0 || isEmpty()) {
            return this;
        }

        Node current = head;
        Node prev = null;
        int count = 0;

        while (current != null && count < index) {
            prev = current;
            current = current.next;
            count++;
        }

        if (current == null) { // Handle deletion beyond list size
            return this;
        }

        if (prev == null) { // Delete head node
            head = current.next;
        } else {
            prev.next = current.next;
        }

        return this;
    }

    public void deleteByData(int data) {
        if (isEmpty()) {
            return; // Handle empty list
        }

        Node current = head;
        Node prev = null;

        while (current != null && current.data != data) {
            prev = current;
            current = current.next;
        }

        if (current == null) { // Data not found
            return;
        }

        if (prev == null) { // Delete head node
            head = current.next;
        } else {
            prev.next = current.next;
        }
    }

    public LinkedList addAtIdx(int idx, int data) {
        if (idx < 0 || isEmpty()) {
            return addFirst(data);
        }
        Node newNode = new Node(data);
        Node current = head;
        Node prev = null;
        int count = 0;

        while (current != null && count < idx) {
            prev = current;
            current = current.next;
            count++;
        }

        if (idx == 0) { // Insert at the beginning
            newNode.next = head;
            head = newNode;
        } else if (prev != null) { // Insert in the middle
            newNode.next = current;
            prev.next = newNode;
        } else { // Insert at the end (prev is null)
            addLast(data); // Call the existing addLast method
        }
        return this;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        int size = 0;
        Node current = head;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.addLast(5).addLast(6).addLast(7).addLast(8).addLast(9);
        System.out.println("LinkedList Size => " + list.getSize());
        list.addLast(10).addLast(11).addLast(12).addLast(13).addLast(14);
        System.out.println("LinkedList Size => " + list.getSize());

        list.deleteLast().deleteLast().deleteLast();
        System.out.println("LinkedList Size => " + list.getSize());

        list.addFirst(100).addFirst(101).deleteFirst();

        list.deleteAtIdx(2); // Delete element at index 2 (removing 7)
        list.addAtIdx(2, 10001);
        list.deleteByData(10001);
        list.printList();
    }
}