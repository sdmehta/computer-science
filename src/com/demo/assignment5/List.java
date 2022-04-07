package com.demo.assignment5;

public interface List<E extends Comparable<E>> extends Iterable<E> {
    /**
     * Returns the length (number of valid 2 nodes) in the linkedlist. It initially starts with 0 nodes
     * @return int
     */
    public int length();

    /**
     * Returns true if the linkedlist doesn’t have any valid nodes, false otherwise.
     * @return boolean
     */
    public boolean empty();

    /**
     * Returns true if cursor is pointing to null, false otherwise.
     * @return boolean
     */
    public boolean offEnd();

    /**
     * Makes cursor point to the beginning of the linkedlist.
     */
    public void toFront();

    /**
     * Makes cursor points to the next node.
     * If cursor already at the end of the linkedlist, skip the operation
     */
    public void advance();

    /**
     * Returns the item of the node cursor is pointing to.
     * In the case where cursor is null, then throw NoItemException
     * @return E
     * @throws NoItemException
     */
    public E get();

    /**
     * It will try to find the element specified. After this, cursor is pointing to the node of that element.
     * @param element
     */
    public void find(E element);

    /**
     * It will insert item into a new node and will insert new node into list
     * @param item
     */
    public void add(E item);

    /**
     * delete the node and return the stored item.
     * throws NoItemException if cursor is null
     * @return E
     * @throws NoItemException
     */
    public E remove();
}
