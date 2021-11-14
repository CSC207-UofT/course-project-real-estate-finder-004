package Exceptions;

public class SignUpUserTypeException extends IllegalArgumentException{
    public SignUpUserTypeException() {super("User type must be Buyer or Seller (B/S).");}
}
