package com.edsc.bookstore.services.exceptions;

import org.apache.logging.log4j.message.Message;

public class DataIntegrityViolationException extends RuntimeException {

    private static final long serialVersionUID = 1L;



    public DataIntegrityViolationException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataIntegrityViolationException(String message) {
        super(message);
    }
    

    
}
