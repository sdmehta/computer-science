package com.demo.COSC2P03.assignment2.src;

import java.io.FileNotFoundException;
import java.util.Arrays;

public class Encryptor {
    private static int[] freqtable;

    public static void main(String[] args) throws FileNotFoundException {
        FileService fileService =  new FileService("C:\\workspaces\\DataStructuresDemo\\src\\com\\demo\\COSC2P03\\assignment2", "input.txt");
        char[] inputCharacters = fileService.readFile();
        freqtable = getFrequencyTable(inputCharacters);
        System.out.println(Arrays.toString(freqtable));
    }

    public static int[] getFrequencyTable(char[] input) {
        int[] frequencyTable = new int[128];
        for (int i = 0; i < input.length; i++) {
           frequencyTable[input[i]]++;
        }
        return frequencyTable;
    }
}

