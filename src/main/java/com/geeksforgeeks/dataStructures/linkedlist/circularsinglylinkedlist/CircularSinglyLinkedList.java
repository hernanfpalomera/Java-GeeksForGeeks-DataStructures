package com.geeksforgeeks.dataStructures.linkedlist.circularsinglylinkedlist;

public class CircularSinglyLinkedList {

    public static Node insertAtBeginning(Node head, int newData) {

        Node newNode = new Node(newData);

        if (head == null) {
            head = newNode;
            head.next = head;
        } else {

            Node tail = head;

            while (tail.next != head) {
                tail = tail.next;
            }

            newNode.next = head;
            tail.next = newNode;
            head = newNode;
        }

        return head;
    }


    public static Node insertAtEnd(Node head, int newData) {
        Node newNode = new Node(newData);

        if (head == null) {

            head = newNode;
            newNode.next = head;

        } else {

            Node tail = head;

            while (tail.next != head) {
                tail = tail.next;
            }

            tail.next = newNode;
            newNode.next = head;
        }

        return head;
    }

    public static Node insertAtPosition(int position, Node head, int newData) {

        if (position < 1 || position > getListSize(head) + 1) {
            System.out.println("Invalid position!");
            return head;
        }

        Node newNode = new Node(newData);
        if (position == 1) {
            insertAtBeginning(head, newData);
        } else if (position == getListSize(head) + 1) {
            insertAtEnd(head, newData);
        } else {
            Node current = head;
            for (int i = 1; i < position-1; i++){
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }

        return head;
    }

    public static Node deleteAtTheBeginning(Node head){

        if(head == null){
            System.out.println("The head is null");
            return head;
        }

        Node current = head;
        while(current.next != head){
            current = current.next;
        }
        current.next = head.next;
        head =  head.next;
        return head;

        //Head = 5
        //5 4 3 2 1 10
    }

    public static Node deleteAtTheEnd(Node head){

        if(head == null){
            System.out.println("The head is null");
            return head;
        }

        Node current = head;
        while(current.next.next != head){
            current = current.next;
        }
        current.next = head;

        //Head = 5
        //5 4 3 2 1 10
        return head;

    }

    public static Node deleteAtPosition(Node head){

        return head;
    }


    public static int getListSize(Node head) {

        int listSize = 0;
        if (head == null) {
            return listSize;
        } else {
            Node tail = head;
            while (tail.next != head) {
                tail = tail.next;
                listSize++;
            }
        }
        return listSize;
    }

    /* Function to print nodes in a given
circular linked list */
    static void printList(Node head) {
        Node temp = head;
        if (head != null) {
            do {
                System.out.printf("%d ", temp.data);
                temp = temp.next;
            } while (temp != head);
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        /* Initialize lists as empty */
        Node head = null;

        /* Created linked list will be 2.5.7.8.10 */
        head = insertAtBeginning(head, 1);
        head = insertAtBeginning(head, 2);
        head = insertAtBeginning(head, 3);
        head = insertAtBeginning(head, 4);
        head = insertAtBeginning(head, 5);
        head = insertAtEnd(head, 10);

        System.out.println("Printing Head value: " + head.data);
        System.out.println("Printing List Data: ");
        printList(head);
        System.out.println("List size: " + Integer.valueOf(getListSize(head)+1));

        System.out.println("Deleting from the begging: ");
        head = deleteAtTheBeginning(head);
        System.out.println("Printing List Data: ");
        printList(head);
        System.out.println("List size: " + Integer.valueOf(getListSize(head)+1));

        System.out.println("Deleting from the End: ");
        head = deleteAtTheEnd(head);
        System.out.println("Printing List Data: ");
        printList(head);
        System.out.println("List size: " + Integer.valueOf(getListSize(head)+1));




    }


}
