import java.io.IOException;

public class RunCLI {
    public static void main(String[] args) throws IOException {
        CommandLine test_command = new CommandLine();
        User user1 = new User("John Smith", "jsmith", "1234@gmail.com", "123-456-7890", "1234");
        test_command.createUser(user1);
        test_command.choose();
    }
}
