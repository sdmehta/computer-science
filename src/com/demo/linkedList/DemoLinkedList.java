package com.demo.linkedList;

public class DemoLinkedList {
    private Node head;
    private int size;

    private class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
        }
    }

    public void add(int data){
        Node prev = null;
        Node curr = head;

        while(curr != null) {
            prev = curr;
            curr = curr.next;
        }

        if(prev == null){
            head = new Node(data);
        } else {
            prev.next = new Node(data);
        }

        this.size++;
    }

    public void add(int index, int data) {
        Node prev = null;
        Node curr = head;

        if(!(index >= 0 && index  <= this.size)) {
            System.err.println("Index out of bounds");
            return;
        }

       for(int i=0; i < index; i++){
             prev = curr;
             curr = curr.next;
        }

        if(prev == null){
            head = new Node(data);
        } else {
            Node newNode = new Node(data);
            newNode.next = prev.next;
            prev.next = newNode;
        }

        this.size++;
    }

    public boolean remove(int data){
        Node prev = null;
        Node curr = head;

        if(head == null)
            return false;

        while(curr.data != data){
            prev = curr;
            curr = curr.next;
        }

        if(prev == null){
            head = head.next;
        } else {
            prev.next = curr.next;
            size--;
        }
        return true;
    }

    public int removeFromIndex(int index){
        Node prev = null;
        Node curr = head;

        if(!(index >= 0 && index  < this.size)) {
            System.err.println("Index out of bounds");
            return -1;
        }

        for(int i=0; i < index; i++){
            prev = curr;
            curr = curr.next;
        }

        int removedData = curr.data;
        prev.next = curr.next;
        size--;

        return removedData;
    }

    public void iterate(){
        Node currNode = head;
        while(currNode != null){
            System.out.println(currNode.data);

            currNode = currNode.next;
        }

    }

    public int size(){
        return size;
    }
}
