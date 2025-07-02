package br.com.mnz.shift.core.exception;

public class DontHaveCurrentUserException extends RuntimeException {
    public DontHaveCurrentUserException(String message) {
        super(message);
    }
}
