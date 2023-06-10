package com.demo.COSC2P03.assignment1;

import BasicIO.ASCIIDataFile;
import BasicIO.ASCIIOutputFile;
import com.demo.COSC2P03.assignment1.mappings.SortedLookup;

import java.util.Arrays;

public class Client {
    public static void main(String[] args) {


        SortedLookup map = new SortedLookup();
        map.add("ls", "list directory \r\n l - asasasdasd \r\n r - asdasdas");
        map.add("L", "Lye");
        map.add("B", "Bye");
        map.add("A", "ehhh Bye");
        //test exceptions and such
        try {
            map.lookup("A");
            map.lookup("C");
        } catch (RuntimeException re) {
            System.out.println("...could you not?");
        }

        System.out.println(Arrays.toString(map.getKeys()));
        System.out.println(map.size());

        for(String[] node: map.asArray())
            System.out.println(Arrays.toString(node));

        System.out.println(Arrays.toString(map.search("e")));

       // System.out.println(Arrays.toString(map.excerpt(new String[]{"A", "C"}).asArray()));

        System.out.println(map.listing());

        map.save(new ASCIIOutputFile("C:\\workspaces\\DataStructuresDemo\\src\\com\\demo\\COSC2P03\\output.txt"));

        SortedLookup lookup = new SortedLookup(new ASCIIDataFile("C:\\workspaces\\DataStructuresDemo\\src\\com\\demo\\COSC2P03\\output.txt"));

        lookup.save(new ASCIIOutputFile("C:\\workspaces\\DataStructuresDemo\\src\\com\\demo\\COSC2P03\\lookup.txt"));
    }

}
