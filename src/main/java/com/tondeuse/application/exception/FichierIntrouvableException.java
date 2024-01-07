package com.tondeuse.application.exception;

import java.io.IOException;

public class FichierIntrouvableException extends IOException {
    public FichierIntrouvableException(String message, Throwable cause) {
        super(message, cause);
    }
}