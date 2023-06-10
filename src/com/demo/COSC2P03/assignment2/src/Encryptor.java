package com.demo.COSC2P03.assignment2.src;

import java.io.IOException;
import java.util.PriorityQueue;

public class Encryptor {
    public static void main(String[] args) throws IOException {
        // Step 1 - read input file and create char array
        FileService inputFileService =  new FileService("C:\\workspaces\\DataStructuresDemo\\src\\com\\demo\\COSC2P03\\assignment2", "input.txt");
        char[] inputCharacters = inputFileService.readFile();

        // Step 2 - create frequency table array
        int[] freqtable = getFrequencyTable(inputCharacters);

        // step 3 - create min Heap of Nodes
        PriorityQueue<Node> minHeap = getHeapOfNodes(freqtable);

        // step 4 - create Tree
        Node root = getCodeBookTree(minHeap);

        // step 5- write code book in output file
        String[] codes = inorderTraversal(root, new String(""), new String[128]);

        for(int i = 0; i < 128; i++) {
            if(codes[i] != null)
                System.out.println(String.valueOf((char)i) + "\t" + codes[i]);
        }

        FileService outputFileService =  new FileService("C:\\workspaces\\DataStructuresDemo\\src\\com\\demo\\COSC2P03\\assignment2", "output.txt");
        outputFileService.writeCodeBookFile(codes);

        // step 6 - create encrypted message
       // StringBuilder encryptedMessage = getEncryptedMessage(inputCharacters, codes);

    }

    public static int[] getFrequencyTable(char[] input) {
        int[] frequencyTable = new int[128];
        for (int i = 0; i < input.length; i++) {
           frequencyTable[input[i]]++;
        }
        return frequencyTable;
    }

    private static PriorityQueue<Node> getHeapOfNodes(int[] freqTable) {
        PriorityQueue<Node> heap = new PriorityQueue<>();

        for(int i = 0; i < 128; i++) {
            if(freqTable[i] > 0)
                heap.add(new Node(String.valueOf((char)i), freqTable[i]));
        }

        return heap;
    }

    private static Node getCodeBookTree(PriorityQueue<Node> minHeap) {
        while(!minHeap.isEmpty()) {
            Node child1 = minHeap.poll();

            if (minHeap.isEmpty())
                return child1;

            Node child2 = minHeap.poll();

            Node parent = new Node(child1.label.concat(child2.label),
                    child1.frequency + child2.frequency,
                    child1,
                    child2);

            minHeap.add(parent);
        }
        return  null;
    }

    private static String[] inorderTraversal(Node node, String path, String[] codeBook) {
        if (node == null) return codeBook;

        if (node.left == null && node.right == null) {
            codeBook[node.label.charAt(0)] = path;
            return codeBook;
        }

        inorderTraversal(node.left, path.concat("0"), codeBook);
        inorderTraversal(node.right, path.concat("1"), codeBook);

        return codeBook;
    }

//    private static StringBuilder getEncryptedMessage(char[] input, List<St>)
}

