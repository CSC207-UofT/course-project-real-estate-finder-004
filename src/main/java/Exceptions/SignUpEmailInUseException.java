package Exceptions;

public class SignUpEmailInUseException extends IllegalArgumentException{
    /**
     * Creates an exception to indicate that an email used by a user when signing up is already associated with another user.
     */
    public SignUpEmailInUseException() {super("Email is already in use.");}
}
