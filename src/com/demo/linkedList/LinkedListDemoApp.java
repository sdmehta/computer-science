package com.demo.linkedList;

public class LinkedListDemoApp {
    public static void main(String[] args) {
        DemoLinkedList list = new DemoLinkedList();

        list.add(0,15);
        list.add(17);
        list.add(19);
        list.add(3, 18);

        list.removeFromIndex(2);
        list.remove(18);


        list.iterate();



    }
}
