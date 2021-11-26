package Exceptions;

public class SignUpUserTypeException extends IllegalArgumentException{
    public SignUpUserTypeException() {super("entities.User type must be entities.Buyer or entities.Seller (B/S).");}
}
