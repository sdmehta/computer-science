package com.demo.assignment.src;

import BasicIO.ASCIIDataFile;
import BasicIO.ASCIIDisplayer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class TestHarness2 {

    private static LinkedList getReserveWordslist() {
        ASCIIDataFile file = new ASCIIDataFile("C:\\workspaces\\DataStructuresDemo\\src\\com\\demo\\assignment\\resources\\JavaReservewords.txt");
        LinkedList reserveWordslist = new LinkedList();

        while (!file.isEOF()) {
            String word = file.readString();
            reserveWordslist.add(word);
        }

/*
        for (int i = 0; i < reserveWordslist.size(); i++) {
            System.out.println(reserveWordslist.get(i));
        }
*/

        return reserveWordslist;
    }

    private static IdentifiersLinkedList getSetOfIdentifiers(LinkedList reserveWordslist) throws IOException {
        File file = new File("C:\\workspaces\\DataStructuresDemo\\src\\com\\demo\\assignment\\src\\NestedSquares.java");
        IdentifiersLinkedList list = new IdentifiersLinkedList();

        BufferedReader br = new BufferedReader(new FileReader(file));
        int lineNumber = 0;

        while (true) {

            String line = br.readLine();
            lineNumber++;

            if (line == null) {
                br.close();
                break;
            }

            if (line.contains("=")) {
                StringTokenizer stk = new StringTokenizer(line, "=");
                String cur = stk.nextToken();

                for (int i = 0; i < reserveWordslist.size(); i++) {
                    cur = cur.replace(reserveWordslist.get(i), "");
                }

                cur = cur.replace("(", "");
                cur = cur.replace("+", "");
                cur = cur.replace("-", "");

//                System.out.println(cur + " " + lineNumber);

                list.add(cur, lineNumber);
            }

        }
        return list;
    }




    public static void main(String[] args) throws IOException {
        LinkedList reserveWordslist = getReserveWordslist();

        IdentifiersLinkedList list = getSetOfIdentifiers(reserveWordslist);



        ASCIIDisplayer displayer = new ASCIIDisplayer(10, 50);

        for (int i = 0; i < list.size(); i++) {
            displayer.writeLine(list.get(i));
        }


        displayer.show();

    }
}

