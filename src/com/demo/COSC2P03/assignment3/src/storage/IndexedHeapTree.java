package com.demo.COSC2P03.assignment3.src.storage;

import java.util.Comparator;
import java.util.Iterator;

public class IndexedHeapTree<E> implements IndexedHeap<E>{
    Node root = null;
    Comparator<E> comparator; //How we'll be defining 'priority'
    private int index = 0;

    private class Node {
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
    public void insert(E item) {
        ++index;
        Node node = new Node(item);

        if (index == 1) {
            root = node;
            return;
        }

        Node parentNode = root;

        int cnt  = 32, ans  = 0;
        do {
            --cnt;
            ans = index & 1 << cnt;
        } while (ans == 0);

        while (cnt > 1) {
            --cnt;
            parentNode = (index & 1 << cnt) == 0 ? parentNode.left : parentNode.right;
        }

        --cnt;
        if ((index & 1 << cnt) == 0) {
            parentNode.left = node;
        } else {
            parentNode.right = node;
        }

        swim(node, index);
    }

    private void swim(Node node, int index) {
        if (index <= 1) return;

        int parentIndex = index / 2;

        Node parentNode = getNodeAtIndex(parentIndex);

        if (getComparator().compare(node.item, parentNode.item) < 0) {
                swap(node, parentNode);
                swim(parentNode, index / 2);
        }

        return;
    }

    private void swap(Node node1, Node node2) {
        E tmp = node1.item;
        node1.item = node2.item;
        node2.item = tmp;
    }

    @Override
    public E remove() {
       if(isEmpty()) return null;

       if(index == 1) {
           index--;
           return root.item;
       }

       E result = root.item;

       Node lastNode = getNodeAtIndex(index);
       Node parentOfLastNode = getNodeAtIndex(index / 2);
       if(index % 2 == 0) {
           parentOfLastNode.left = null;
       } else {
            parentOfLastNode.right = null;
       }

       swap(root, lastNode);
       index--;

       sink(root, 0, index);

       return result;
    }

    private void sink (Node node, int curIndex, int index) {
        // case 1 = no child node
        if (node == null || (node.left == null && node.right == null)) {
            return;
        }

        // case 2 = only left child is present
        if(node.right == null) {
            if(getComparator().compare(node.item, node.left.item) < 0) {
                return;
            } else {
                swap(node, node.left);
                return;
            }
        }

        // case 3 = both children present
        // case 3.1 = node item is greater than both child
        if((getComparator().compare(node.item, node.left.item) < 0 && getComparator().compare(node.item, node.right.item) < 0) ) {
            return;
        } else if (getComparator().compare(node.left.item, node.right.item) < 0 ) {
            swap(node, node.left);
            sink(node.left, curIndex * 2, index);
        } else if (getComparator().compare(node.left.item, node.right.item) >= 0) {
            swap(node, node.right);
            sink(node.right, curIndex * 2 + 1, index);
        }
    }

    @Override
    public E peek() {
        return isEmpty() ? null : root.item;
    }

    @Override
    public boolean isEmpty() {
        return index == 0 ? true : false;
    }

    @Override
    public Comparator getComparator() {
        return this.comparator;
    }

    private Node getNodeAtIndex(int index) {
        Node node = root;
        int cnt  = 32, ans  = 0;
        do {
            --cnt;
            ans = index & 1 << cnt;
        } while (ans == 0);

        while (cnt > 0) {
            --cnt;

            node = (index & 1 << cnt) == 0 ? node.left : node.right;
        }

        return node;
    }

    @Override
    public E getAtIndex(int index) {
       Node node = root;
       int cnt  = 32, ans  = 0;
       do {
           --cnt;
            ans = index & 1 << cnt;
       } while (ans == 0);

        while (cnt > 0) {
            --cnt;

            node = (index & 1 << cnt) == 0 ? node.left : node.right;
        }

        return node.item;
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
