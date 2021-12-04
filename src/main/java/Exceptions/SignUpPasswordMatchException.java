package Exceptions;

import java.lang.IllegalArgumentException;

public class SignUpPasswordMatchException extends IllegalArgumentException {
    /**
     * Creates an exception to indicate that the second password entered by the user upon
     * signing up does not match the first password.
     */
    public SignUpPasswordMatchException() {
        super("Passwords do not match!");
    }
}