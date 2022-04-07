package com.demo.assignment5;

public class Node<E extends Comparable<E>> {
    E data;
    Node next;

    Node(E data){
        this.data = data;
    }
}
