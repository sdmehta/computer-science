package com.demo.assignment5;

public interface List<E> extends  Iterable<E> {

    public void add(E item);

    public E remove() throws UnderFlowException;

    public E get() throws UnderFlowException;

    public boolean isEmpty();

    public int length();
}
