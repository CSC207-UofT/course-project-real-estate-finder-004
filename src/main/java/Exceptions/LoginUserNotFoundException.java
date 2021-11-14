package Exceptions;

public class LoginUserNotFoundException extends IllegalArgumentException {
    public LoginUserNotFoundException() {
        super("Username does not exist!");
    }
}
