import java.io.IOException;

public class RunCLI {
    public static void main(String[] args) throws IOException {
        CommandLine test_command = new CommandLine();
        Seller user1 = new Seller("John Smith", "jsmith", "1234@gmail.com", "123-456-7890", "1234");
        user1.addProperty(new Property("6 Hoskin Avenue", "Toronto", "Ontario", "CA", "M5T 2HY", 16000F, 1000, user1));
        test_command.createUser(user1);
        test_command.choose();
    }
}
