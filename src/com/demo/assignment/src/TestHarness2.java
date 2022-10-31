package com.demo.assignment.src;

import BasicIO.ASCIIDataFile;
import BasicIO.ASCIIDisplayer;

import java.io.IOException;
import java.util.StringTokenizer;

public class TestHarness2 {

    private static ReserveWordsLinkedList getReserveWordslist() {
        ASCIIDataFile file = new ASCIIDataFile();
        ReserveWordsLinkedList reserveWordslist = new ReserveWordsLinkedList();

        while (!file.isEOF()) {
            String line = file.readLine();
            if(line == null || "".equals(line)) continue;

            StringTokenizer strTkn = new StringTokenizer(line);
            while(strTkn.hasMoreTokens()) {
                reserveWordslist.add(strTkn.nextToken().replaceAll(" ", ""));
            }
        }

        reserveWordslist.sort();
        return reserveWordslist;
    }

    private static IdentifiersLinkedList getSetOfIdentifiers(ReserveWordsLinkedList reserveWordslist) throws IOException {
        ASCIIDataFile file = new ASCIIDataFile();
        IdentifiersLinkedList list = new IdentifiersLinkedList();
        int lineNumber = 0;

        while (!file.isEOF()) {
            String line = file.readLine();
            lineNumber++;
            if(line == null || "".equals(line)) continue;

            StringTokenizer strTkn = new StringTokenizer(line, "[ ;=+-/*%<>,.]");

            while(strTkn.hasMoreTokens()) {
                String cur = strTkn.nextToken();
                if ("package".equalsIgnoreCase(cur)) break;
                cur = cur.replaceAll(" ", "");
                cur = cur.replaceAll("[0-9]", "");
                cur = cur.replaceAll(".*[(].*[)]", "");
                cur = cur.replaceAll("[{}()]", "");
                cur = cur.replaceAll("[A-Z].*", "");
                cur = cur.replaceAll("\r", "");

                if(cur != null && !"".equals(cur) && !reserveWordslist.contains(cur) && !list.contains(cur, lineNumber)) {
                    list.add(cur, lineNumber);
                }
            }
        }

        return list;
    }

    public static void main(String[] args) throws IOException {
        // step 1
        ReserveWordsLinkedList reserveWordslist = getReserveWordslist();

        // step 2
        IdentifiersLinkedList identifiersList = getSetOfIdentifiers(reserveWordslist);
        IdentifiersLinkedList outputList = new IdentifiersLinkedList();

        for (int i = 0; i < identifiersList.size(); i++)
            System.out.println(identifiersList.get(i));

        // step 3
        ASCIIDisplayer displayer = new ASCIIDisplayer(10, 50);

        for (int i = 0; i < identifiersList.size(); i++) {
            if (!outputList.contains(identifiersList.getData(i))) {
                outputList.add(identifiersList.getData(i), -1);

            }
        }

        outputList.sort();

        for (int i = 0; i < outputList.size(); i++) {
            String lineNumbers = "";

            for (int j = 0; j < identifiersList.size(); j++) {
                if (outputList.getData(i).equalsIgnoreCase(identifiersList.getData(j))) {
                    lineNumbers = lineNumbers.concat(String.valueOf(identifiersList.getLine(j)));
                    lineNumbers = lineNumbers.concat(", ");
                }
            }

            lineNumbers = lineNumbers.substring(0, lineNumbers.length() - 2);

            String str = outputList.getData(i);
            for (int k = str.length(); k < 30; k++) {
                str = str.concat(" ");
            }

            displayer.writeLine(str + "" + lineNumbers);
        }

        displayer.show();
    }
}
