package com.demo.assignment5;

public interface SortableList<E extends Comparable<E>> extends  List<E> {
    public void sort() throws  UnderFlowException ;
}
