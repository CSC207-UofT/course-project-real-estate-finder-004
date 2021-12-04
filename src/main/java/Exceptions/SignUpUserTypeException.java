package Exceptions;

public class SignUpUserTypeException extends IllegalArgumentException{
    /**
     * Creates an exception to indicate that the user did not enter B/S or to choose their
     * user type upon signing up.
     */
    public SignUpUserTypeException() {super("entities.User type must be entities.Buyer or entities.Seller (B/S).");}
}
