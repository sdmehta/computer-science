package com.demo.semesterIII.assignment2.src;

public class ReserveWordsLinkedList {
    private Node head;
    private int size;

    private class Node implements  Comparable{
        String data;
        Node next;

        Node(String data){
            this.data = data;
        }

        Node(String data, int lineNumber){
            this.data = data;
        }

        @Override
        public int compareTo(Object o) {
            return this.data.compareTo(((Node)o).data);
        }
    }

    public void add(String data){
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

    public void add(int index, String data) {
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

    public boolean remove(String data){
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

    public boolean contains(String data){
        Node curr = head;

        if(data == null) return false;

        while(curr != null){
            if (data.equalsIgnoreCase(curr.data)) return true;
            curr = curr.next;
        }

        return false;
    }

    public void set(int index, String data){
        Node curr = head;

        if(!(index >= 0 && index  < this.size)) {
            System.err.println("Index out of bounds");
            return;
        }

        for(int i=0; i < index; i++){
            curr = curr.next;
        }

       curr.data = data;
    }

    public String get(int index){
        Node curr = head;

        if(!(index >= 0 && index  < this.size)) {
            System.err.println("Index out of bounds");
            return null;
        }

        for(int i=0; i < index; i++){
            curr = curr.next;
        }

        return curr.data;
    }

    public String removeFromIndex(int index){
        Node prev = null;
        Node curr = head;

        if(!(index >= 0 && index  < this.size)) {
            System.err.println("Index out of bounds");
            return null;
        }

        for(int i=0; i < index; i++){
            prev = curr;
            curr = curr.next;
        }

        String removedData = curr.data;
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

    public void sort() {
        for(int i = 1; i < this.size(); i++){
            for(int j = i; j > 0; j--) {
                if(less(this.get(j), this.get(j - 1))) {
                    exch(this, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    public boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public void exch(ReserveWordsLinkedList a, int i, int j) {
        String swap = a.get(i);
        a.set(i, a.get(j));
        a.set(j, swap);

    }
}
