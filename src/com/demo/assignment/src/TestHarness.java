package com.demo.assignment.src;

import BasicIO.ASCIIDataFile;

public class TestHarness {
    public static void main(String[] args) {
        ASCIIDataFile file = new ASCIIDataFile("C:\\workspaces\\DataStructuresDemo\\src\\com\\demo\\assignment\\resources\\JavaReservewords.txt");
        LinkedList reserveWordslist = new LinkedList();

       while (!file.isEOF()) {
            String word = file.readString();
             reserveWordslist.add(word);
        }

        for(int i = 0; i < reserveWordslist.size(); i++) {
            System.out.println(reserveWordslist.get(i));
        }

    }
}
