package Exceptions;

public class SignUpPhoneNumberInUseException extends IllegalArgumentException{
    public SignUpPhoneNumberInUseException() {super("Phone number is already in use.");}
}
