package entities;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String username;
    private String email;
    private String phone;
    private String password;

    /**
     * Constructor statement for the user class.  Adds the basic information required for a user to sign up.
     *
     * @param name     A String of the user's name.
     * @param username A String of the user's desired username, for use in logging in.  Must be unique from other users.
     * @param email    String with the user's email address.
     * @param phone    A 10 character String with the user's phone number.
     * @param password A string with the user's password.
     */
    public User(String name, String username, String email, String phone, String password) {
        if (phone.length() != 10) {
            throw new IllegalArgumentException("Your phone number should be exactly 10 digits long. Please input again.");
        }
        try {
            double d = Double.parseDouble(phone);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("Your phone number should only contain numeric values. Please input again.");
        }
        this.name = name;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    /**
     * Getter method for username.
     *
     * @return The user's username, a String.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Getter method for email
     *
     * @return Returns the user's email as a string.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Getter method for name
     *
     * @return Returns the user's name as a string.
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method for the user's password.
     *
     * @return Returns the user's password as a string.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Getter method for the user's phone.
     *
     * @return Returns the user's phone number as a length 10 string.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Setter method for the user's username.
     *
     * @param username String to set as the user's username.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Setter method for the user's email.
     *
     * @param email String to set as the user's email.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Setter method for the user's name. Must be unique.
     *
     * @param name String to set for the user's username.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter method for the user's password.
     *
     * @param password String to set for the user's password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Setter method for the user's phone number.
     *
     * @param phone String to set for the user's phone number.  Must be length 10, and a number.
     */
    public void setPhone(String phone) {
        if (phone.length() != 10) {
            throw new IllegalArgumentException("Your phone number should be exactly 10 digits long. Please input again");
        }
        try {
            double d = Double.parseDouble(phone);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("Your phone number should only contain numeric values. Please input again.");
        }
        this.phone = phone;
    }
}