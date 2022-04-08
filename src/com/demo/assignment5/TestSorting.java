package com.demo.assignment5;

import java.util.Iterator;
import java.util.Random;

public class TestSorting {
    public static void main(String[] args) {
        SortableList<Integer> list = new DynamicSortableList<>();
        int N = 100;
        Iterator<Integer> iter;

        Random random = new Random();
       for(int i = 1; i <= N; i++) {
           list.add(random.nextInt(101));
       }

       System.out.println("Unsorted List: ");
        iter = list.iterator();
        while(iter.hasNext()) {
            System.out.print(iter.next() + " -> ");
        }

        System.out.println("null");

        try {
            int timeUnits = list.sort();
            System.out.println("Sort Time Units: " + timeUnits);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Sorted List: ");
        iter = list.iterator();
        while(iter.hasNext()) {
            System.out.print(iter.next() +  " -> ");
        }
        System.out.println("null");
    }
}
