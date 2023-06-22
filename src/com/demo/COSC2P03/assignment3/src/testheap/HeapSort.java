package com.demo.COSC2P03.assignment3.src.testheap;

import com.demo.COSC2P03.assignment3.src.storage.HeapOTroubleException;
import com.demo.COSC2P03.assignment3.src.storage.IndexedHeap;
import com.demo.COSC2P03.assignment3.src.storage.IndexedHeapArray;
import com.demo.COSC2P03.assignment3.src.storage.IndexedHeapTree;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HeapSort {

    private static final String DATA_TYPE_INTEGERS = "INTEGERS";
    private static final String DATA_TYPE_STRINGS = "STRINGS";
    private static final String HEAP_TYPE_ARRAY= "ARRAY";
    private static final String HEAP_TYPE_TREE = "TREE";

    private String userDataType = null;
    private int inputNumberOfIntegers = 0;
    private String[] inputStrings = null;
    private String userHeapType = null;

    public HeapSort (){
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        boolean continueFlag = true;
        Scanner scanner = new Scanner(System.in);

        while(continueFlag) {
            heapSort.getUserInput(scanner);

            if (DATA_TYPE_INTEGERS.equals(heapSort.userDataType)){
                int[] unsortedIntegers = new int[heapSort.inputNumberOfIntegers];
                IndexedHeap<Integer> maxHeap = HEAP_TYPE_ARRAY.equals(heapSort.userHeapType) ?
                        new IndexedHeapArray<>((a, b) -> a - b) :
                        new IndexedHeapTree<>((a, b) -> a - b);

                Random rand = new Random();
                for (int i = 0; i < heapSort.inputNumberOfIntegers; i++) {
                    unsortedIntegers[i] = rand.nextInt(1000000000);
                }

                System.out.println("Unsorted Integers : " + Arrays.toString(unsortedIntegers));
                int[] sortedIntegers = heapSort.sortIntegers(unsortedIntegers, maxHeap);
                System.out.println("Sorted Integers : " + Arrays.toString(sortedIntegers));

            } else if (DATA_TYPE_STRINGS.equals(heapSort.userDataType)){
                IndexedHeap<String> maxHeap = HEAP_TYPE_ARRAY.equals(heapSort.userHeapType) ?
                        new IndexedHeapArray<>(String.CASE_INSENSITIVE_ORDER) :
                        new IndexedHeapTree<>(String.CASE_INSENSITIVE_ORDER);

                System.out.println("unsorted Strings : " + Arrays.toString(heapSort.inputStrings));
                String[] sortedArray = heapSort.sortStrings(heapSort.inputStrings, maxHeap);
                System.out.println("Sorted Strings : " + Arrays.toString(sortedArray));

            } else {
                throw new HeapOTroubleException();
            }

            continueFlag = "Y".equalsIgnoreCase(heapSort.checkUserWantstoContinue(scanner)) ? true : false;
        }

        scanner.close();
    }

    private void getUserInput(Scanner scanner) {
        userDataType = getDataTypeFromUser(scanner);
        getDataFromUser(scanner);
        userHeapType = getHeapTypeFromUser(scanner);
    }

    public String getDataTypeFromUser (Scanner scanner){
        System.out.print("Select Data Type - 1.Integers  2.Strings : ");
        int choice = scanner.nextInt();
        System.out.println();
        if (choice == 1){
            return this.DATA_TYPE_INTEGERS;
        } else if (choice == 2) {
            return this.DATA_TYPE_STRINGS;
        }

        return "INVALID";
    }

    public void getDataFromUser (Scanner scanner){
        if (DATA_TYPE_INTEGERS.equals(userDataType)) {
            System.out.print("Enter number of Integers to sort : ");
            this.inputNumberOfIntegers = scanner.nextInt();
        } else if(DATA_TYPE_STRINGS.equals(userDataType)) {
            System.out.print("Enter Strings to sort : ");

            String line = null;
            do {
                line = scanner.nextLine();
            } while (line == null || "".equals(line));

            inputStrings= line.split(" ");
        }
        System.out.println();
        return;
    }

    public String getHeapTypeFromUser(Scanner scanner){
        System.out.print("Select Heap Type - 1.IndexedHeapArray  2.IndexedHeapTree : ");
        int choice = scanner.nextInt();
        System.out.println();
        if (choice == 1){
            return this.HEAP_TYPE_ARRAY;
        } else if (choice == 2) {
            return this.HEAP_TYPE_TREE;
        }

        return "INVALID";
    }

    private int[] sortIntegers(int[] integers, IndexedHeap<Integer> maxHeap){
        for(int x : integers)
            maxHeap.insert(x);

        for (int i = 0; i < integers.length; i++)
            integers[i] = maxHeap.remove();

        return integers;
    }

    private String[] sortStrings(String[] strings, IndexedHeap<String> maxHeap){
        for (String str : strings) {
            maxHeap.insert(str);
        }

        for (int i = 0; i < strings.length; i++) {
            strings[i] = maxHeap.remove();
        }

        return strings;
    }

    private String checkUserWantstoContinue(Scanner scanner) {
        System.out.print("Do you want to try again (y/n) ? : ");
        String userChoice = scanner.next();
        return "y".equalsIgnoreCase(userChoice) ? "Y" : "N";
    }
}
