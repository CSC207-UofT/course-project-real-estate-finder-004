package Exceptions;

public class LoginWrongPasswordException extends IllegalArgumentException{
    /**
     * Creates an exception to indicate that a password used by the user upon logging in is wrong.
     */
    public LoginWrongPasswordException(){super("Wrong password!");}
}
