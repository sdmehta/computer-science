package com.demo.COSC2P03.assignment2.src.com.enc;

public class Node implements Comparable<Node>{
    public String label;
    public int frequency;
    Node left;
    Node right;

    public Node(String label, int frequency) {
        this.label = label;
        this.frequency = frequency;
    }

    public Node(String label, int frequency, Node left, Node right) {
        this.label = label;
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }

    @Override
    public int compareTo(Node other) {
        return this.frequency - other.frequency;
    }
}
