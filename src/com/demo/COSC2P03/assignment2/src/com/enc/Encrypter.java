package com.demo.COSC2P03.assignment2.src.com.enc;

import java.io.IOException;

public class Encrypter {
    private final String filePath = "C:\\workspaces\\DataStructuresDemo\\src\\com\\demo\\COSC2P03\\assignment2\\resources";

    public static void main(String[] args) throws IOException {
        String inputFileName = args.length > 0 ? args[0] : "testing.txt";
        String outputFileName = args.length > 1 ? args[1] : "encrypted.txt";

        Encrypter encryptor = new Encrypter();
        encryptor.encrypt(inputFileName, outputFileName);
    }

    public void encrypt(String inputFileName, String outputFileName) throws IOException {
        // Step 1 - read input file and create char array
        FileService inputFileService =  new FileService(filePath, inputFileName);
        char[] inputCharacters = inputFileService.readFile();

        // Step 2 - create frequency table array
        int[] freqtable = getFrequencyTable(inputCharacters);

        // step 3 - create min Heap of Nodes
        MinHeap minHeap = getHeapOfNodes(freqtable);

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

    private int[] getFrequencyTable(char[] input) {
        int[] frequencyTable = new int[256];
        for (int i = 0; i < input.length; i++) {
           frequencyTable[input[i]]++;
        }
        return frequencyTable;
    }

    private MinHeap getHeapOfNodes(int[] freqTable) {
        MinHeap heap = new MinHeap();

        for(int i = 0; i < 256; i++) {
            if(freqTable[i] > 0)
                heap.add(new Node(String.valueOf((char)i), freqTable[i]));
        }

        return heap;
    }

    private Node getCodeBookTree(MinHeap minHeap) {
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

    private String[] inorderTraversal(Node node, String path, String[] codeBook) {
        if (node == null) return codeBook;

        if (node.left == null && node.right == null) {
            codeBook[node.label.charAt(0)] = path;
            return codeBook;
        }

        inorderTraversal(node.left, path.concat("0"), codeBook);
        inorderTraversal(node.right, path.concat("1"), codeBook);

        return codeBook;
    }

    private String getEncryptedMessage(char[] input, String[] codes) {
        StringBuilder encryptedStrBuilder = new StringBuilder("");

        for (char c: input) {
            encryptedStrBuilder.append(codes[c]).append("\t");
        }

        return encryptedStrBuilder.toString();
    }
}
