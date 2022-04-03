package com.demo.assignment5;

import java.util.Iterator;

public class TestClient {
    public static void main(String[] args) {
        SortableList<Integer> list = new SortableLinkedList<>();



        try {


            list.sort();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Iterator<Integer> iter = list.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
