package Exceptions;

public class SignUpUserNameInUseException extends IllegalArgumentException{
    /**
     * Creates an exception to indicate that a user name used by a user when signing up is already associated with another user.
     */
    public SignUpUserNameInUseException() {super("User name is already in use.");}
}
