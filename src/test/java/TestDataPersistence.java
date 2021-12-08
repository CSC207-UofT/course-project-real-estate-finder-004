import controllers.DatabaseManager;
import entities.Seller;

public class TestDataPersistence {
    public static void main(String[] args) {
        DatabaseManager manager = new DatabaseManager();
        Seller me = (Seller) manager.loginUser("sebastian", "pass");
//        System.out.println(me.getEmail());
//        me.setEmail("sebastian@gmail.com");
        System.out.println(me.getUnreadMessages());
        me.addMessage("TEST");
        System.out.println(me.getUnreadMessages());

        manager.updateUser(me);


        DatabaseManager manager2 = new DatabaseManager();
        Seller me2 = (Seller) manager2.loginUser("sebastian", "pass");
        System.out.println(me2.getUnreadMessages());
    }
}
