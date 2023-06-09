package com.geeksforgeeks.dataStructures.linkedlist.doublylinkedlist;

// Class for Doubly Linked List
public class DoublyLinkedList {

    static Node head = null; // head of list

    // Adding a node at the front of the list
    public static void push(int new_data){

        /* 1. allocate node
         * 2. put in the data */
        Node new_Node = new Node(new_data);

        /* 3. Make next of new node as head and previous as
         * NULL */
        new_Node.next = head;
        new_Node.prev = null;

        /* 4. change prev of head node to new node */
        if (head != null)
            head.prev = new_Node;

        /* 5. move the head to point to the new node */
        head = new_Node;


    }


    // Add a node before the given node
    public static void InsertBefore(Node next_node, int new_data)
    {
        /*Check if the given nx_node is NULL*/
        if (next_node == null) {
            System.out.println(
                    "The given next node can not be NULL");
            return;
        }

        // Allocate node, put in the data
        Node new_node = new Node(new_data);

        // Making prev of new node as prev of next node
        new_node.prev = next_node.prev;

        // Making prev of next node as new node
        next_node.prev = new_node;

        // Making next of new node as next node
        new_node.next = next_node;

        // Check if new node is added as head
        if (new_node.prev != null)
            new_node.prev.next = new_node;
        else
            head = new_node;
    }

    /* Given a node as prev_node, insert a new node after the
     * given node */
    public static void insertAfter(Node prev_Node, int new_data) {
        /*1. check if the given prev_node is NULL */
        if(prev_Node == null){
            System.out.println(
                    "The given previous node cannot be NULL ");
            return;
        }

        /* 2. allocate node
         * 3. put in the data */
        Node new_Node = new Node(new_data);

        /* 4. Make next of new node as next of prev_node */
        new_Node.next = prev_Node.next;
        
        /* 5. Make the next of prev_node as new_node */
        prev_Node.next = new_Node;

        /* 6. Make prev_node as previous of new_node */
        new_Node.prev = prev_Node;

        /* 7. Change previous of new_node's next node */
        if (new_Node.next != null)
            new_Node.next.prev = new_Node;

    }

    // Add a node at the end of the list
    static void append(int new_data)
    {
        /* 1. allocate node
         * 2. put in the data */
        Node new_node = new Node(new_data);

        Node last = head; /* used in step 5*/

        /* 3. This new node is going to be the last node, so
         * make next of it as NULL*/
        new_node.next = null;

        /* 4. If the Linked List is empty, then make the new
         * node as head */
        if (head == null) {
            new_node.prev = null;
            head = new_node;
            return;
        }

        /* 5. Else traverse till the last node */
        while (last.next != null)
            last = last.next;

        /* 6. Change the next of last node */
        last.next = new_node;

        /* 7. Make last node as previous of new node */
        new_node.prev = last;
    }

    // This function prints contents of
    // linked list starting from the given node
    public static void printlist(Node node)
    {
        Node last = null;
        System.out.println(
                "Traversal in forward direction");
        while (node != null) {
            System.out.print(node.data + " ");
            last = node;
            node = node.next;
        }
        System.out.println();
        System.out.println(
                "Traversal in reverse direction");
        while (last != null) {
            System.out.print(last.data + " ");
            last = last.prev;
        }
    }

    // This function prints contents of
    // linked list starting from the given node
    public static void printMemoryLocationlist(Node node)
    {
        Node last = null;
        System.out.println(
                "Traversal in forward direction");
        while (node != null) {
            System.out.print(node + " ");
            last = node;
            node = node.next;
        }
    }

    // Driver code
    public static void main(String[] args)
    {
        /* Start with the empty list */
        DoublyLinkedList dll = new DoublyLinkedList();

        // Insert 6. So linked list becomes 6->NULL
        append(6);

        // Insert 7 at the beginning. So
        // linked list becomes 7->6->NULL
        push(7);

        // Insert 1 at the beginning. So
        // linked list becomes 1->7->6->NULL
        push(1);

        // Insert 4 at the end. So linked
        // list becomes 1->7->6->4->NULL
        append(4);

        // Insert 8, after 7. So linked
        // list becomes 1->7->8->6->4->NULL
        insertAfter(head.next, 8);

        // Insert 5, before 8.So linked
        // list becomes 1->7->5->8->6->4
        // dll.InsertBefore(dll.head.next.next, 5);

        System.out.println("Created DLL is: ");
        printlist(head);
        System.out.println("Printing head memory location: ".concat(head.toString()));
        System.out.println("Printing head.next memory location: ".concat(head.next.toString()));

        printMemoryLocationlist(head);
    }
}
