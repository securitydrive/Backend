package com.example.demo.service.exception;

/**
 * @author tensor
 */
public class UserExistsException extends RuntimeException {

    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public UserExistsException(String message) {
        super(message);
    }
}