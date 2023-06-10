package com.demo.COSC2P03.assignment2.src;

import java.io.IOException;
import java.util.PriorityQueue;

public class Encryptor {
    private static String filePath = "C:\\workspaces\\DataStructuresDemo\\src\\com\\demo\\\\COSC2P03\\assignment2\\resources";
    private static String inputFileName = "testing.txt";
    private static String outputFileName = "encrypted.txt";

    public static void main(String[] args) throws IOException {
        // Step 1 - read input file and create char array
        FileService inputFileService =  new FileService(filePath, inputFileName);
        char[] inputCharacters = inputFileService.readFile();

        // Step 2 - create frequency table array
        int[] freqtable = getFrequencyTable(inputCharacters);

        // step 3 - create min Heap of Nodes
        PriorityQueue<Node> minHeap = getHeapOfNodes(freqtable);

        // step 4 - create Tree
        Node root = getCodeBookTree(minHeap);

        // step 5- generate codes
        String[] codes = inorderTraversal(root, new String(""), new String[256]);

        // step 6 - create encrypted message
        String encryptedMessage = getEncryptedMessage(inputCharacters, codes);

        // step 7 - write encrypted file
        FileService outputFileService =  new FileService(filePath, outputFileName);
        outputFileService.writeEncryptedFile(codes, encryptedMessage);
    }

    public static int[] getFrequencyTable(char[] input) {
        int[] frequencyTable = new int[256];
        for (int i = 0; i < input.length; i++) {
           frequencyTable[input[i]]++;
        }
        return frequencyTable;
    }

    private static PriorityQueue<Node> getHeapOfNodes(int[] freqTable) {
        PriorityQueue<Node> heap = new PriorityQueue<>();

        for(int i = 0; i < 256; i++) {
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

    private static String getEncryptedMessage(char[] input, String[] codes) {
        StringBuilder encryptedStrBuilder = new StringBuilder("");

        for (char c: input) {
            encryptedStrBuilder.append(codes[c]).append(" ");
        }

        return encryptedStrBuilder.toString();
    }
}

