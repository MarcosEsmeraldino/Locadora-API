package com.locadora.exception;

public class RecursoJaExiste extends BusinessException {

    public RecursoJaExiste() {
    }

    public RecursoJaExiste(String message) {
        super(message);
    }

    public RecursoJaExiste(String message, Throwable cause) {
        super(message, cause);
    }

    public RecursoJaExiste(Throwable cause) {
        super(cause);
    }

    public RecursoJaExiste(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
