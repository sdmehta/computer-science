package com.demo.COSC2P03.assignment3.src.testheap;

import com.demo.COSC2P03.assignment3.src.storage.HeapOTroubleException;
import com.demo.COSC2P03.assignment3.src.storage.IndexedHeap;
import com.demo.COSC2P03.assignment3.src.storage.IndexedHeapArray;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HeapSort {

    private static final String DATA_TYPE_INTEGERS = "INTEGERS";
    private static final String DATA_TYPE_STRINGS = "STRINGS";
    private static final String HEAP_TYPE_ARRAY= "ARRAY";
    private static final String HEAP_TYPE_TREE = "TREE";

    private String userDataType = null;
    private int inputNumberOfIntegers = 0;
    private List<String> inputStringsList = null;
    private String userHeapType = null;

    public HeapSort (){
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

            inputStringsList = Arrays.asList(line.split(" "));
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

    private void sortIntegers(IndexedHeap<Integer> heap){
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many numbers would you like to sort?");
        int choice = scanner.nextInt();
        if (userHeapType == "Ascending"){
           
        } else if (userHeapType == "Descending"){

        }else {
            throw new HeapOTroubleException();
        }
    }

    private void sortStrings(IndexedHeap<String> heap){
        if (userHeapType == "Ascending"){

        } else if (userHeapType == "Descending"){

        }else {
            throw new HeapOTroubleException();
        }
    }


   public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        boolean continueFlag = true;
        Scanner scanner = new Scanner(System.in);

        while(continueFlag) {
            heapSort.getUserInput(scanner);
            System.out.println("DATA TYPE = " + heapSort.userDataType);
            System.out.println("inputNumberOfIntegers = " + heapSort.inputNumberOfIntegers);
            System.out.println("inputStringsList = " + heapSort.inputStringsList);
            System.out.println("HEAP TYPE = " + heapSort.userHeapType);

            if (DATA_TYPE_INTEGERS.equals(heapSort.userDataType)){
                IndexedHeap<Integer> heap = new IndexedHeapArray<>((a, b) -> a-b);
                heapSort.sortIntegers(heap);
            } else if (DATA_TYPE_STRINGS.equals(heapSort.userDataType)){
                IndexedHeap<String> heap = new IndexedHeapArray<>(String.CASE_INSENSITIVE_ORDER);
                heapSort.sortStrings(heap);
            } else {
                throw new HeapOTroubleException();
            }

            System.out.print("Do you want to continue (y/n) ? : ");
            String continueStr = scanner.next();
            continueFlag = "Y".equalsIgnoreCase(continueStr) ? true : false;
        }

        scanner.close();
   }
}
