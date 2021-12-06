package Exceptions;

public class SignUpUserNameInUseException extends IllegalArgumentException{
    public SignUpUserNameInUseException() {super("User name is already in use.");}
}
