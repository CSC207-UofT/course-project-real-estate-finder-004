package Exceptions;

public class SignUpEmailInUseException extends IllegalArgumentException{
    public SignUpEmailInUseException() {super("Email is already in use.");}
}
