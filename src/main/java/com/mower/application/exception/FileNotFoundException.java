package com.mower.application.exception;

import java.io.IOException;

public class FileNotFoundException extends IOException {
    public FileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}