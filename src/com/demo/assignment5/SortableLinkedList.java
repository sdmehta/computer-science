package com.demo.assignment5;

import java.util.Iterator;

public class SortableLinkedList<E extends Comparable<E>> implements SortableList<E> {
    private Node first;
    private Node last;
    private int length;

    private class Node {
        E data;
        Node next;

        Node(E data){
            this.data = data;
        }
    }

    public void add(E data){
        Node node = new Node(data);

        if(last == null) {
            first = node;
        } else {
            last.next = node;
        }
        last = node;

        this.length++;
    }


    public E remove() throws  UnderFlowException {
        Node prev = null;
        Node curr = first;

        if(this.isEmpty()) {
            throw new UnderFlowException("List is Empty");
        }

        while(curr.next != null){
            prev = curr;
            curr = curr.next;
        }

        if(prev == null) {
            first = first.next;
        } else {
            prev.next = null;
            last = prev;
        }
        this.length--;
        return curr.data;
    }

    public E get() throws UnderFlowException {
        if(this.isEmpty()) {
            throw new UnderFlowException("List is Empty");
        }

        return last.data;
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    public int length(){
        return length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node curr = first;

            @Override
            public boolean hasNext() {
                return curr != null;
            }

            @Override
            public E next() {
                E tmp = curr.data;
                curr = curr.next;
                return tmp;
            }
        };
    }

    @Override
    public int sort() throws  UnderFlowException {
        if(this.isEmpty()) {
            throw new UnderFlowException("List is Empty");
        }

        int result = 0;
        Node prev = null, curr = first, next = first.next;

        for (int i = length-1; i >= 1 ; i--){
            prev = null; curr = first; next = first.next;

            for (int j = 0; j < i; j++){
                result++;
                if (greater(curr, next)) {
                    exch(prev, curr, next);
                    prev = next;
                    curr = curr;
                    next = curr.next;
                } else {
                    prev = curr;
                    curr = next;
                    next = next.next;
                }
            }
        }
        return  result;
    }

    private boolean greater(Node curr, Node next) {
        return curr.data.compareTo(next.data) > 0;
    }

    private void exch(Node prev, Node curr, Node next) {
        if(prev == null) {
            first = next;
        } else {
            prev.next = next;
        }

        curr.next = next.next;
        next.next = curr;
    }
}
