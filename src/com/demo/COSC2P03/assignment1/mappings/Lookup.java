package com.demo.COSC2P03.assignment1.mappings;

import BasicIO.ASCIIOutputFile;

public interface Lookup {
    public String add(String key, String item);

    public String lookup(String key);

    public String[] search(String key);

    public String[] getKeys();

    public Lookup excerpt(String[] keys);

    public int size();

    public String listing();

    public String[][] asArray();

    public void save(ASCIIOutputFile file);
}
