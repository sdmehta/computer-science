package com.demo.assignment5;

import java.util.Iterator;

public class DynamicList<E extends Comparable<E>> implements List<E> {
    private Node head;
    private Node tail;
    private Node cursor;
    private int length;

    private class Node {
        E data;
        Node next;

        Node(E data){
            this.data = data;
        }
    }

    @Override
    public int length() {
        return this.length;
    }

    @Override
    public boolean empty() {
        return this.length() == 0;
    }

    @Override
    public boolean offEnd() {
        return this.cursor == null;
    }

    @Override
    public void toFront() {
        this.cursor = this.head;
    }

    @Override
    public void advance() {
        if(this.cursor != null && this.cursor.next != null)
            this.cursor = this.cursor.next;
    }

    @Override
    public E get() throws NoItemException {
        if (this.cursor == null)
            throw new NoItemException();

        return this.cursor.data;
    }

    @Override
    public void find(E element) {
        while(this.cursor != null) {
            if (this.cursor.data.compareTo(element) == 0)
                break;
        }
    }

    @Override
    public void add(E item){
        Node node = new Node(item);

        if(this.empty()) {                     // 1. head == cur == null
            this.head = node;
            this.tail = node;
        } else if (this.head == this.cursor) { // 2. head == cur != null
            node.next = this.head;
            this.head = node;
        } else if(this.offEnd()) {              // 3. head != null, cur == null
            this.tail = node;
        } else {                                // 4. head != cur != null
            Node prev = head;
            while (prev.next != this.cursor) {
                prev = prev.next;
            }
            node.next = prev.next;
            prev.next = node;
        }

        this.cursor = node;
        this.length++;
    }

    @Override
    public E remove() throws NoItemException {
        if(this.offEnd()) {              // 1. and 3. head == cur == null and head != cur == null
            throw new NoItemException();
        }

        E result = this.cursor.data;

        if(this.head == this.cursor) {    // 2. head == cur != null
            this.head = this.head.next;
            this.cursor = this.head;
        } else {                          // 4. head != cur != null
            Node prev = this.head;
            while(prev.next != this.cursor){
                prev = prev.next;
            }
            prev.next = this.cursor.next;
            this.cursor = prev.next;
        }

        this.length--;
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node curr = head;

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
}