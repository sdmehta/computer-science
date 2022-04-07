package com.demo.assignment5;

public class NoItemException extends RuntimeException{
    public NoItemException() {
        this("No Item present");
    }

    public NoItemException(String message) {
        super(message);
    }
}
