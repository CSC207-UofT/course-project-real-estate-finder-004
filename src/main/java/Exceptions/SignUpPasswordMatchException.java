package Exceptions;

import java.lang.IllegalArgumentException;

public class SignUpPasswordMatchException extends IllegalArgumentException {
    public SignUpPasswordMatchException() {
        super("Passwords do not match!");
    }
}