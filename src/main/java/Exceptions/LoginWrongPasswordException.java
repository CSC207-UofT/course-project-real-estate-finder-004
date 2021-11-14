package Exceptions;

public class LoginWrongPasswordException extends IllegalArgumentException{
    public LoginWrongPasswordException(){super("Wrong password!");}
}
