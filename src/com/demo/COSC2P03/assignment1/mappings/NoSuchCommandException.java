package com.demo.COSC2P03.assignment1.mappings;

public class NoSuchCommandException extends RuntimeException {
    public NoSuchCommandException() {
    }

    public NoSuchCommandException(String msg) {
        super(msg);
    }
}
