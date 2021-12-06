package Exceptions;

import java.lang.IllegalArgumentException;

public class SignUpPhoneNumberLengthException extends IllegalArgumentException {
    /**
     * Creates an exception to indicate that the phone number entered by the user upon signing up is not
     * 10 digits long.
     */
    public SignUpPhoneNumberLengthException() {
        super("Phone number should be 10 digits long.");
    }
}
