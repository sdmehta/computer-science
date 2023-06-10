package com.demo.COSC2P03.assignment2.src;

import java.io.*;
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
}
