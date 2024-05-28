package linkedlist;

public class LinkedList {

    Node head;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public static LinkedList addFirst(int data, LinkedList list) {
        Node temp = new Node(data);
        if (list.head == null) {
            list.head = temp;
        } else {
            Node tempNode = list.head;
            temp.next = tempNode;
            list.head = temp;
        }
        return list;
    }

    public static LinkedList deleteFirst(LinkedList list) {
        if (list.head.next == null) {
            return null;
        } else {
            Node temp = list.head.next;
            list.head = temp;
        }

        return list;
    }

    public static LinkedList additionLast(int data, LinkedList list) {
        Node temp = new Node(data);
        if (list.head == null) {
            list.head = temp;
        } else {
            Node tempNode = list.head;
            while (tempNode.next != null) {
                tempNode = tempNode.next;
            }
            tempNode.next = temp;
        }

        return list;
    }

    public static void printList(LinkedList list) {
        Node temp = list.head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static int getSize(LinkedList list) {
        if (list.head == null) {
            return 0;
        } else {
            Node temp = list.head;
            int size = 0;
            while (temp != null) {
                size++;
                temp = temp.next;
            }
            return size;
        }
    }

    public static LinkedList deletionLast(LinkedList list) {
        Node temp = list.head;
        if (temp.next == null) {
            temp = null;
        } else {
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
        }
        return list;
    }

    // Tried but wasn't able to implement yet
    public static LinkedList deleteAtIdx(LinkedList list, int data) {
        Node temp = list.head;
        Node prev = null;
        if (temp.data == data) {
            if (temp.next == null) {
                return null;
            } else {
                list.head = temp.next;
            }
        }
        while (temp != null && temp.data != data) {
            prev = temp;
            temp = temp.next;
        }

        while (temp != null) {
            prev.next = temp.next;
        }

        return list;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list = additionLast(5, list);
        list = additionLast(6, list);
        list = additionLast(7, list);
        list = additionLast(8, list);
        list = additionLast(9, list);
        System.out.println("LinkedList Size => " + getSize(list));
        list = additionLast(10, list);
        list = additionLast(11, list);
        list = additionLast(12, list);
        list = additionLast(13, list);
        list = additionLast(14, list);
        System.out.println("LinkedList Size => " + getSize(list));

        list = deletionLast(list);
        System.out.println("LinkedList Size => " + getSize(list));
        list = deletionLast(list);
        list = deletionLast(list);
        System.out.println("LinkedList Size => " + getSize(list));

        list = addFirst(100, list);
        list = addFirst(101, list);
        list = deleteFirst(list);

//        list = deleteAtIdx(list, 9);

        printList(list);
    }
}
