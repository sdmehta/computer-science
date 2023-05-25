package com.demo.COSC2P03.mappings;

import BasicIO.ASCIIDataFile;
import BasicIO.ASCIIOutputFile;


public class SortedLookup implements Lookup {

    private Node head = null;

    /*
    ** Default constructor
     */
    public SortedLookup() {
        head = null;
    }

    /*
     ** Constructor which populate its contents from an ASCIIDataFile
     */
    public SortedLookup(ASCIIDataFile inputFile) {
        while (!inputFile.isEOF()) {
            String key = inputFile.readLine();
            if (key == null)
                break;
            StringBuilder dataBuilder = new StringBuilder();
            boolean eod = false;
            while (!eod) {
                String line = inputFile.readLine();

                if ("----------".equals(line)) {
                    eod = true;
                } else {
                    dataBuilder.append(line);
                    dataBuilder.append("\r\n");
                }
            }

            add(key, dataBuilder.toString());
        }
    }

    /*
     ** Constructor which populate its contents from an ASCIIDataFile
     */
    public SortedLookup(String[][] inputArray) {
        for(String[] entry : inputArray) {
            add(entry[0], entry[1]);
        }
    }

    /*
     ** You can add as many pairings of key and entry as you’d like
     **   - Each is mapping a string to a string
     **   - If you try adding an entry corresponding to an already-existing key? You simply replace the entry for that key (note: all keys are stored as lowercase-only)
     */
    public String add(String key, String item) {
        if (head == null)
            head = addIt(key, item, head);
        else
            head.next = addIt(key, item, head.next);

        return item;
    }

    private Node addIt(String key, String item, Node node) {
        if (node == null) {
            return new Node(key, item, null);
        }
        if (key.compareTo(node.key) < 0) {
            return new Node(key, item, node);
        } else if (key.compareTo(node.key) > 0) {
            node.next = addIt(key, item, node.next);
        } else {
            node.data = item;
        }
        return node;
    }

    /*
     ** You can lookup a key
     **   - This simply returns the corresponding entry for that key (treated as lowercase)
     **   - If it doesn’t exist, then that throws a NoSuchCommandException (part of the same package)
     */
    public String lookup(String key) {
        if (key == null || "".equals(key))
            return null;

        Node node = head;

        while (node != null) {
            if (key.equalsIgnoreCase(node.key))
                return node.data;

            node = node.next;
        }

        throw new NoSuchCommandException("Command not present.");
    }


    /*
     ** You’re implementing a search:
     **  - It receives a search term, which it will try to match within entries and keys themselves
     **  - It is not case-sensitive!
     **  - It returns an array, containing only the keys for matches
     **     _ All searches are ‘legal’; the array is properly-sized to the number of matches
     */
    @Override
    public String[] search(String searchKey) {
        if (searchKey == null || "".equals(searchKey))
            return new String[0];

        int count = 0;
        Node node = head.next;
        while (node != null) {
            if (searchKey.equalsIgnoreCase(node.key) || node.data.toLowerCase().contains(searchKey.toLowerCase()))
                count++;
            node = node.next;
        }

        String result[] = new String[count];
        int i = 0;
        node = head.next;
        while (node != null) {
            if (searchKey.equalsIgnoreCase(node.key) || node.data.toLowerCase().contains(searchKey.toLowerCase()))
                result[i++] = node.key;
            node = node.next;
        }

        return result;
    }

    private int getCount() {
        int count = 0;
        Node node = head.next;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    /*
    ** getKeys, which gives an array of all the keys in the Lookup:
    **      - Obviously if it’s empty, then the array simply has a length of zero
     */
    public String[] getKeys() {
        String[] keys = new String[getCount()];
        int i = 0;
        Node node = head.next;
        while (node != null) {
            keys[i++] = node.key;
            node = node.next;
        }

        return keys;
    }

    /*
    ** excerpt: a new instance of a Lookup, constrained only to those keys specified (as an array) in its parameter
    **  - Technically, this can also act as a minimal substitute for being able to remove entries
    **  - If the provided keys has any entries not present, it’s the same problem as looking up a
    *      single non-existent key (and must be handled the same way)
     */
    @Override
    public Lookup excerpt(String[] keys) {
        Lookup result = new SortedLookup();

        for (String key : keys) {
            String data = lookup(key);
            result.add(key, data);
        }

        return result;
    }

    /*
    ** It has the ability to return its total size
    **  - What it returns is the total character count of all keys and entries!
     */
    @Override
    public int size() {
        int size = 0;
        Node node = head.next;
        while (node != null) {
            size += node.key.length();
            size += node.data.length();
            node = node.next;
        }

        return size;
    }

    /*
    ** It has the ability to generate ‘one big listing’ of its entire contents as a String:
    **  - Have the key be the first term in the line, then a tab, then the entry (obviously some entries will have multiple lines; but that’s not your concern)
    **  _ Between each entry, have a ‘break’ of ten dashes
    **  - The listing should be sorted, by key
    **  - Also, though your interface can’t do this, any concrete type will be expected to override toString, to simply return the same contents as the listing
     */

    @Override
    public String listing() {
        StringBuilder strBuilder = new StringBuilder();

        Node node = head.next;
        while (node != null) {
            strBuilder.append(node.key);
            strBuilder.append("\t");
            strBuilder.append(node.data);
            strBuilder.append("\n");
            strBuilder.append("---------");
            strBuilder.append("\n");
            node = node.next;
        }

        return strBuilder.toString();
    }


    /*
    ** It can render and return itself asArray:
    **  - This simply yields a 2D array of strings: first column is keys; second is corresponding entries
     */
    @Override
    public String[][] asArray() {
        String result[][] = new String[getCount()][];
        int i = 0;
        Node node = head.next;

        while (node != null) {
            result[i] = new String[2];
            result[i][0] = node.key;
            result[i][1] = node.data;
            node = node.next;
            i++;
        }

        return result;
    }

    /*
    ** It can render itself (save) into an ASCIIOutputFile
    **  - It receives a (presumably newly-instantiated) ASCIIOutputFile as its only parameter
     */
    @Override
    public void save(ASCIIOutputFile file) {
        Node node = head;

        while (node != null) {
            file.writeLine(node.key);
            file.writeLine(node.data);
            file.writeLine("----------");
            node = node.next;
        }
    }

    public String toString() {
        return this.listing();
    }

//    public Iterator iterator() {
//        return new Cartogerator();
//    }
//    private class Cartogerator implements Iterator {
//        private Node ptr;
//        public Cartogerator() {
//            ptr=head.next;
//        }
//        public E next() {
//            E item=ptr.data;
//            ptr=ptr.next;
//            return item;
//        }
//
//        public boolean hasNext() {
//            return ptr!=null;
//        }
//    }
}
