package com.demo.COSC2P03.assignment2.src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileService {
    File file;

    public FileService(String filePath, String fileName) {
        file = new File(filePath + "\\"+ fileName);
    }

    public char[] readFile() throws FileNotFoundException {
        Scanner s = new Scanner(file);
        String input = s.nextLine();
        return input.toCharArray();
    }
}
