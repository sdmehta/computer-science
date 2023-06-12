package com.demo.COSC2P03.assignment2.src.com.enc;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Decrypter {
    private final String filePath = "C:\\workspaces\\DataStructuresDemo\\src\\com\\demo\\COSC2P03\\assignment2\\resources";

    public static void main(String[] args) throws IOException {
        String inputFileName = args.length > 0 ? args[0] : "encrypted.txt";
        String outputFileName = args.length > 1 ? args[1] : "recovered.txt";

        Decrypter decrypter = new Decrypter();
        decrypter.decrypt(inputFileName, outputFileName);
    }

    public void decrypt(String inputFileName, String outputFileName) throws IOException {
        FileService inputFileService = new FileService(filePath, inputFileName);

        String[] codes = getCodes(inputFileService);
        System.out.println(Arrays.toString(codes));

        String[] encryptedChars =  getEncryptedChars(inputFileService);
        System.out.println(Arrays.toString(encryptedChars));

        String decryptedMessage = decryptMessage(encryptedChars, codes);
        System.out.println(decryptedMessage);

        FileService outputFileService = new FileService(filePath, outputFileName);
        outputFileService.writeRecoveredFile(decryptedMessage);

    }

    public String[] getCodes(FileService fileService) throws FileNotFoundException {
        List<String> codeBook = fileService.getCodeBook();
        String[] codes = new String[256];
        for (String codeLine : codeBook) {
            String[] codemap = codeLine.split("\t");
            codes[(int) codemap[0].charAt(0)] = codemap[1];
        }
        return codes;
    }

    private String[] getEncryptedChars(FileService fileService) throws FileNotFoundException {
        String encryptedMessage = fileService.readEncryptedMessage();
        return encryptedMessage.split("\t");
    }

    private String decryptMessage(String[] encryptedChars, String[] codes) {
        StringBuilder decryptedMessage = new StringBuilder("");

        for (String encryptedChar : encryptedChars) {
            for (int i = 0; i < codes.length; i++) {
                if (encryptedChar.equals(codes[i])) {
                    decryptedMessage.append((char) i);
                }
            }
        }

        return decryptedMessage.toString();
    }
}
