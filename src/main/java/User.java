import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String username;
    private String email;
    private String phone;
    private String password;

    public User(String name, String username, String email, String phone, String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() { return phone; }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        if (phone.length() != 10) {
            throw new IllegalArgumentException("Your phone number should be exactly 10 digits long. Please input again");
        }
        this.phone = phone;
    }
}