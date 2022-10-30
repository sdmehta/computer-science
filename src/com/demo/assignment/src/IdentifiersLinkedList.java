package com.demo.assignment.src;

public class IdentifiersLinkedList {
    private Node head;
    private int size;

    private class Node implements  Comparable{
        String data;
        int lineNumber;
        Node next;

        Node(String data){
            this.data = data;
        }

        Node(String data, int lineNumber){
            this.data = data;
            this.lineNumber = lineNumber;
        }

        @Override
        public int compareTo(Object o) {
            return this.data.compareTo(((Node)o).data);
        }
    }

    public void add(String data, int line){
        Node prev = null;
        Node curr = head;

        while(curr != null) {
            prev = curr;
            curr = curr.next;
        }

        if(prev == null){
            head = new Node(data, line);
        } else {
            prev.next = new Node(data, line);
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

    public boolean contains(String data){
        Node curr = head;

        if(data == null) return false;

        while(curr != null){
            if (data.equalsIgnoreCase(curr.data)) return true;
            curr = curr.next;
        }

        return false;
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

    public String getData(int index){
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

        return curr.data;
    }

    public int getLine(int index){
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

        return curr.lineNumber;
    }

    public String get(int index){
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

        String str = curr.data;
        for (int i = curr.data.length(); i < 30; i++) {
            str = str.concat(" ");
        }

        String removedData = str + " " + curr.lineNumber;


        return removedData;
    }

    public Node getNode(int index){
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

        return curr;
    }

    public void set(int index, String data, int line){
        Node curr = head;

        if(!(index >= 0 && index  < this.size)) {
            System.err.println("Index out of bounds");
            return;
        }

        for(int i=0; i < index; i++){
            curr = curr.next;
        }

        curr.data = data;
        curr.lineNumber = line;
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

    public void sort() {
        for(int i = 1; i < this.size(); i++){
            for(int j = i; j > 0; j--) {
                if(less(this.getNode(j).data, this.getNode(j - 1).data)) {
                    exch(j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    public boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public void exch(int i, int j) {
        String swapS = this.getNode(i).data;
        int swapL = this.getNode(i).lineNumber;

        this.set(i, this.getNode(j).data, this.getNode(j).lineNumber);
        this.set(j, swapS, swapL);

    }

    public int size(){
        return size;
    }
}
