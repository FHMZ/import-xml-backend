package com.importer.importxmlbackend.exception;

public class FileNotFoundException extends RuntimeException {

    public FileNotFoundException(final String errorMessage) {
        super(errorMessage);
    }

}
