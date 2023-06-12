package com.demo.COSC2P03.assignment2.src.heap;

import com.demo.COSC2P03.assignment2.src.Node;

import java.io.IOException;
import java.util.Arrays;

public class TestClient {
    public static void main(String[] args) throws IOException {
        MinHeap minHeap = new MinHeap();
        minHeap.add(new Node("e", 3));
        minHeap.add(new Node("a", 13));
        minHeap.add(new Node("c", 6));
        minHeap.add(new Node("i", 20));
        minHeap.add(new Node("b", 9));
        minHeap.add(new Node("f", 17));

        Arrays.stream(minHeap.heap)
                .filter(item -> item != null)
                .forEach(item -> System.out.println(item.label + " - " + item.frequency));

        System.out.println(minHeap.isEmpty());

        while(!minHeap.isEmpty()) {
            Node tmp = minHeap.poll();
            System.out.println(tmp.label + "-" + tmp.frequency);
        }
    }
}
