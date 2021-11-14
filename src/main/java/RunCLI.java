import java.io.IOException;

public class RunCLI {
    public static void main(String[] args) throws IOException {
        DatabaseManager manager = new DatabaseManager();
        CommandLine test_command = new CommandLine(System.in, manager);
        test_command.main_menu();
    }
}
