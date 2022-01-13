package com.locadora.exception;

public class RecursoNaoEncontrado extends BusinessException {

    public RecursoNaoEncontrado() {
    }

    public RecursoNaoEncontrado(String message) {
        super(message);
    }

    public RecursoNaoEncontrado(String message, Throwable cause) {
        super(message, cause);
    }

    public RecursoNaoEncontrado(Throwable cause) {
        super(cause);
    }

    public RecursoNaoEncontrado(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
