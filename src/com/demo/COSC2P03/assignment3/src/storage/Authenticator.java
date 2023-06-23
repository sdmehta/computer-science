package com.demo.COSC2P03.assignment3.src.storage;

public class Authenticator {
    private final IndexedHeap<String> minHeap;
    private final IndexedHeap<String> maxHeap;

    public Authenticator(String[] codes) {
        minHeap = new IndexedHeapArray<>(String.CASE_INSENSITIVE_ORDER);
        maxHeap = new IndexedHeapArray<>(String.CASE_INSENSITIVE_ORDER.reversed());

        for(String code : codes) {
            minHeap.insert(code);
            maxHeap.insert(code);
        }
    }

    public String getCode(int i) {
        return minHeap.getAtIndex(i) + maxHeap.getAtIndex(i);
    }
}
