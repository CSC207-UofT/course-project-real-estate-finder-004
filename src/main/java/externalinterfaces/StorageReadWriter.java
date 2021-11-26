package externalinterfaces;

import java.io.*;

public class StorageReadWriter<T, K> implements ReadWriter {

    private String filePath;
    private Storage<T, K> storage;

    /**
     * Writes the users to file at filePath.
     *
     * @throws IOException
     */
    @Override
    public void saveToFile() throws IOException {

        OutputStream file = new FileOutputStream(this.filePath);
        OutputStream buffer = new BufferedOutputStream(file);
        ObjectOutput output = new ObjectOutputStream(buffer);

        // serialize the Map
        output.writeObject(storage);
        output.close();
    }


    /**
     * Store the users to file at filePath.
     *
     * @return object in the file
     * @throws IOException
     */
    @Override
    public Storage<T, K> readFromFile() throws IOException, ClassNotFoundException {

        InputStream file = new FileInputStream(this.filePath);
        InputStream buffer = new BufferedInputStream(file);
        ObjectInput input = new ObjectInputStream(buffer);

        // serialize the Map
        Object object = input.readObject();
        input.close();
        this.storage = (Storage<T, K>) object;
        return this.storage;
    }

    public StorageReadWriter(String filePath, Storage<T, K> storage){
        this.filePath = filePath;
        this.storage = storage;
    }
}
