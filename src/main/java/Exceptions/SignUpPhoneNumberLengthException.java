package Exceptions;

import java.lang.IllegalArgumentException;

public class SignUpPhoneNumberLengthException extends IllegalArgumentException {
    public SignUpPhoneNumberLengthException() {
        super("Phone number should be 10 digits long.");
    }
}
