package controllers;

import externalinterfaces.Storage;

import java.io.*;

// Adapted from https://github.com/CSC207-UofT/CleanArchLoginSample/blob/main/src/edu/toronto/csc207/UserReadWriter.java

public class StorageReadWriter<T, K> implements ReadWriter {

    private final String filePath;
    private Storage<T, K> storage;

    /**
     * Writes storage at filePath.
     *
     * @throws IOException Throws an IOException when the file is not found.
     */
    @Override
    public void saveToFile() throws IOException {

        OutputStream file = new FileOutputStream(this.filePath);
        OutputStream buffer = new BufferedOutputStream(file);
        ObjectOutput output = new ObjectOutputStream(buffer);

        // serialize the storage
        output.writeObject(storage);
        output.close();
    }


    /**
     * Read storage at filePath.
     *
     * @return object in the file
     * @throws IOException Throws an IOException when the file is not found.
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
