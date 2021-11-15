import Exceptions.LoginUserNotFoundException;
import Exceptions.LoginWrongPasswordException;
import org.junit.*;
import static org.junit.Assert.*;

public class LoginUserTest {
    @Test (timeout = 50)
    public void testLoginUser(){
        DatabaseManager myDatabaseManager = new DatabaseManager();
        myDatabaseManager.signUp("Alexis Tassone", "b","alexistassone", "alexis.tassone@mail.utoronto.ca",
                "1234567890", "1234");
        try {
            User logged_in_user = myDatabaseManager.loginUser("Alexis Tassone", "1234");
        } catch(LoginUserNotFoundException | LoginWrongPasswordException e) {
            fail();
        }
        try{
            User myUser = myDatabaseManager.loginUser("Alexis Tassone", "4321");
            fail();
        } catch (LoginUserNotFoundException | LoginWrongPasswordException ignored) {

        }
    }
}

