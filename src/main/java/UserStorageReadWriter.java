import java.io.IOException;

public class UserStorageReadWriter extends StorageReadWriter{

    public UserStorageReadWriter() {
        super("src/users.ser");
    }

    @Override
    public void saveToFile(Object object) throws IOException {
        super.saveToFile(object);
    }

    @Override
    public HashMapUserStorage readFromFile() throws IOException, ClassNotFoundException {
        return (HashMapUserStorage) super.readFromFile();
    }
}
