package com.demo.assignment5;

import java.util.Iterator;

public class DynamicSortableListIterator<E extends Comparable<E>> implements Iterator<E> {
    Node<E> cursor;

    public DynamicSortableListIterator(DynamicListIterator<E> list) {
        this.cursor = list.getFront();
    }

    /**
     *
     * @return boolean
     */
    @Override
    public boolean hasNext() {
        return this.cursor != null;
    }

    /**
     *
     * @return E
     */
    @Override
    public E next() {
        E tmp = this.cursor.data;
        this.cursor = this.cursor.next;
        return tmp;
    }

    /**
     *
     */
    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
