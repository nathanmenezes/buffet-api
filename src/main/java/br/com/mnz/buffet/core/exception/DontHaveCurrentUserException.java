package br.com.mnz.buffet.core.exception;

public class DontHaveCurrentUserException extends RuntimeException {
    public DontHaveCurrentUserException(String message) {
        super(message);
    }
}
