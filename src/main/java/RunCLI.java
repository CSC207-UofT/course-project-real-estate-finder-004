import java.io.IOException;
import java.util.HashMap;

public class RunCLI {
    public static void main(String[] args) throws IOException {
        UserStorage myHashMapStorage = new HashMapUserStorage();
        CreateUser myCreateUser = new CreateUser(myHashMapStorage);
        myCreateUser.createSeller("John Smith", "jsmith", "1234@gmail.com", "1234567890", "1234");
        CreateProperty.createProperty((Seller) myHashMapStorage.getUser("jsmith"), "6 Hoskin Avenue", "Toronto", "Ontario", "CA", "M5T 2HY", 16000F, 1000, true);
        CommandLine test_command = new CommandLine(System.in, myHashMapStorage);
        test_command.choose();
    }
}
