package com.demo.COSC2P03.assignment3.src.storage;

import java.util.Scanner;

public class HeapSort {

    String dataType = null;
    String sortType = null;
    public HeapSort (){
        IndexedHeap<String> heap=new IndexedHeapArray<>(String.CASE_INSENSITIVE_ORDER);
        IndexedHeap<Integer> numheap=new IndexedHeapArray<>((a,b)->a-b);
        dataType = chooseDataType();
        sortType = chooseAscendOrDescend();
        System.out.println(dataType);
        if (dataType == "Numbers"){
            sortNumbers(numheap);
        } else if (dataType == "Letters"){
            sortLetters(heap);
        } else {
            throw new HeapOTroubleException();
        }
        //
        /*
        quickTest(heap);
        System.out.println();
        heap=new IndexedHeapArray<>(String.CASE_INSENSITIVE_ORDER.reversed()); //For a max-heap!
        quickTest(heap);
        System.out.println();

        /*IndexedHeap<String> theap=new IndexedHeapTree<>(String.CASE_INSENSITIVE_ORDER);
        heap=new IndexedHeapArray<>(String.CASE_INSENSITIVE_ORDER);
        doubleTest(heap,theap); //Yields the precise same results for both!
        doubleTest(theap,new IndexedHeapTree<>(String.CASE_INSENSITIVE_ORDER.reversed()));*/
        //


        //testNumbers(numheap);
    }

    public String chooseDataType (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Data Type .");
        System.out.println("1: Numbers");
        System.out.println("2: Letters");
        System.out.println("Choice = ");

        int choice = scanner.nextInt();

        String dataType = null;
        if (choice == 1){
            dataType = "Numbers";
        } else if (choice == 2) {
            dataType = "Letters";
        } else {
            dataType = "invalid";
        }

    return dataType;
    }

    public String chooseAscendOrDescend(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like them sorted Ascending or Descending?");
        System.out.println("1: Ascending");
        System.out.println("2: Descending");

    //    int choice = scanner.nextInt();
        int choice = 1;

        String sortType = null;

        if (choice == 1){
            sortType = "Ascending";
        } else if (choice == 2) {
            sortType = "Descending";
        } else {
            sortType = "invalid";
        }
        scanner.close();
        return sortType;
    }

    private void sortNumbers(IndexedHeap<Integer> heap){
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many numbers would you like to sort?");
        int choice = scanner.nextInt();
        if (sortType == "Ascending"){
           
        } else if (sortType == "Descending"){

        }else {
            throw new HeapOTroubleException();
        }
    }

    private void sortLetters(IndexedHeap<String> heap){
        if (sortType == "Ascending"){

        } else if (sortType == "Descending"){

        }else {
            throw new HeapOTroubleException();
        }
    }


/*
    //Test 1
    private void quickTest(IndexedHeap<String> heap) {
        for (int i=0;i<10;i++) {
            String t=Character.toString((char)(Math.random()*26+65));
            System.out.print("\t"+t);
            heap.insert(t);
        }
        System.out.println();
        for (String s:heap) System.out.print(s);
        System.out.println();
        while (!heap.isEmpty()) System.out.print("\t"+heap.remove());
        System.out.println();
    }
    //
    //Test 2
    private void testNumbers(IndexedHeap<Integer> heap) {
        System.out.println("Number time");
        for (int i=0;i<20;i++) {
            heap.insert((int)(Math.random()*1000));
        }
        for (int v:heap) System.out.print(" "+v);
        System.out.println();
        while (!heap.isEmpty()) System.out.print(" "+heap.remove());
        System.out.println();
    }
    //
*/
    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
    }

}
