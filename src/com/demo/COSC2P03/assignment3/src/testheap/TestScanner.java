package com.demo.COSC2P03.assignment3.src.testheap;

import java.util.Scanner;

public class TestScanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Would you like them sorted Ascending or Descending?");
        System.out.println("1: Ascending");
        System.out.println("2: Descending");

        int choice = scanner.nextInt();
        System.out.println(choice);


        scanner.close();
    }
}
