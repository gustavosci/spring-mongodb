package br.com.springmongo.service.exception;

public class ObjectNotFoundException extends RuntimeException {

    public ObjectNotFoundException(final String msg) {
        super(msg);
    }
}
