import controllers.DatabaseManager;
import entities.Seller;

public class TestDataPersistence {
    public static void main(String[] args) {
        DatabaseManager manager = new DatabaseManager();
        Seller me = (Seller) manager.loginUser("sebastian", "1234");
        me.addMessage("TEST");
        System.out.println(me.getUnreadMessages());

        manager.updateUser(me);


        DatabaseManager manager2 = new DatabaseManager();
        Seller me2 = (Seller) manager2.loginUser("sebastian", "1234");
        System.out.println(me2.getUnreadMessages());
    }
}
