package com.demo.COSC2P03.assignment2.src.com.enc;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileService {
    File file;

    public FileService(String filePath, String fileName) {
        file = new File(filePath + "\\"+ fileName);
    }

    public char[] readFile() throws FileNotFoundException {
        Scanner s = new Scanner(file);
        String input = s.nextLine();
        s.close();
        return input.toCharArray();
    }

    public void writeEncryptedFile(String[] codes, String msg) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));

        for(int i = 0; i < 256; i++) {
            if (codes[i] != null) {
                String codeString = String.valueOf((char) i) + "\t" + codes[i];
                writer.write(codeString);
                writer.newLine();
            }
        }

        writer.write("---");
        writer.newLine();
        writer.write(msg);

        writer.close();
    }

    public List<String> getCodeBook() throws FileNotFoundException {
        List<String> codeBook = new ArrayList<>();
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("---")) break;
            codeBook.add(line);
        }

        return codeBook;
    }

    public String readEncryptedMessage() throws FileNotFoundException {
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("---")) break;
        }

        return scanner.nextLine();
    }

    public void writeRecoveredFile(String decryptedMessage) throws  IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(decryptedMessage);
        writer.close();
    }
}
