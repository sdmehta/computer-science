package com.demo.COSC2P03.assignment3.src.storage;

import java.util.Comparator;
import java.util.Iterator;

public class IndexedHeapTree<E> implements IndexedHeap<E>{
    Node root = null;
    Comparator<E> comparator; //How we'll be defining 'priority'

    class Node {
        E item;
        Node left;
        Node right;

        Node (E item) {
            this.item = item;
        }
    }

    public IndexedHeapTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    @Override
    public void insert(Object item) {

    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E peek() {
        return root != null ? root.item : null;
    }

    @Override
    public boolean isEmpty() {
        return root == null ? true : false;
    }

    @Override
    public Comparator getComparator() {
        return null;
    }

    @Override
    public E getAtIndex(int index) {
        return null;
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
