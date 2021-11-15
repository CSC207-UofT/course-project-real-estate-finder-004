public class Creator {
    HashMapUserStorage userStorage;
    UserStorageReadWriter userStorageReadWriter;
    HashMapPropertyStorage propertyStorage;
    PropertyStorageReadWriter propertyStorageReadWriter;
    final static boolean writeToFile = true;

    public Creator(HashMapUserStorage userStorage,
                   UserStorageReadWriter userStorageReadWriter,
                   HashMapPropertyStorage propertyStorage,
                   PropertyStorageReadWriter propertyStorageReadWriter){
        this.userStorage = userStorage;
        this.userStorageReadWriter = userStorageReadWriter;
        this.propertyStorage = propertyStorage;
        this.propertyStorageReadWriter = propertyStorageReadWriter;
    }
}
