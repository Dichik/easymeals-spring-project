package com.example.easymeals.exception;

public class AlreadyExistsException extends RuntimeException {

    public AlreadyExistsException(Long id) {
        super("Item with " + id + " id already exists.");
    }

    public AlreadyExistsException() {
        super("Item already exists.");
    }

}
