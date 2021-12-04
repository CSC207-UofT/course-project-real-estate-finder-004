package Exceptions;

public class LoginUserNotFoundException extends IllegalArgumentException {
    /**
     * Creates an exception to indicate that a username used by the user upon logging in does not exist.
     */
    public LoginUserNotFoundException() {
        super("Username does not exist!");
    }
}
