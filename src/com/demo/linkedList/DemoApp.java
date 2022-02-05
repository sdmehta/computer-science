package com.demo.linkedList;

public class DemoApp {

    private static void iterate(Node head){
        Node currNode = head;

        while(currNode != null){
            System.out.println(currNode.data);

            currNode = currNode.next;
        }

    }

    private static Node insertAtFront(Node head, int data){
        //1. create new node with data
        Node node = new Node(data);

        //2. point node to current head
        node.next = head;

        //3. change head to point to the new node
        head = node;

        return head;
    }

    private static void insertAtEnd(Node head, int data){
        //1. create new node with data
        Node node = new Node(data);

        //2. traverse to the last node
        while(head.next != null){
            head = head.next;
        }

        //3. point last node to new node
        head.next = node;
    }


    private  static Node deleteFromFront(Node head){
        if(head == null) return head;

        head = head.next;

        return head;

    }

    private  static void deleteFromEnd(Node head){
        //1. traverse to the second last node
        while(head.next.next != null){
            head = head.next;
        }

        //2. delink last node
        head.next = null;
    }

    public static void main(String[] args) {
        Node head = null;

        Node node1 = new Node(15);
        Node node2 = new Node(17);
        Node node3 = new Node(19);
        Node node4 = new Node(21);
        Node node5 = new Node(23);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        head = node1;

        head = insertAtFront(head, 13);
        head = insertAtFront(head, 11);
        head = insertAtFront(head, 9);

        head = deleteFromFront(head);

        insertAtEnd(head, 25);
        insertAtEnd(head, 27);
        insertAtEnd(head, 29);

        deleteFromEnd(head);

        iterate(head);


    }

}
