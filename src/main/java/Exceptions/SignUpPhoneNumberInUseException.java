package Exceptions;

public class SignUpPhoneNumberInUseException extends IllegalArgumentException{
    /**
     * Creates an exception to indicate that a phone number used by a user when signing up is already associated with another user.
     */
    public SignUpPhoneNumberInUseException() {super("Phone number is already in use.");}
}
