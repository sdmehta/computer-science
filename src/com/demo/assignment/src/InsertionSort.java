package com.demo.assignment.src;

public class InsertionSort {
    public void sort(LinkedList list) {
        for(int i = 0; i < list.size(); i++){
            for(int j = i+1; j > 0; j--) {
                if(less(list.get(j), list.get(j - 1))) {
                    exch(list, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    public boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public void exch(LinkedList a, int i, int j) {
        String swap = a.get(i);
        a.add(i, a.get(j));
        a.add(j, swap);

    }
}
