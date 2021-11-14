import java.io.*;

public class StorageReadWriter implements ReadWriter {

    private String filePath;

    /**
     * Writes the users to file at filePath.
     *
     * @param object object to be written
     * @throws IOException
     */
    @Override
    public void saveToFile(Object object) throws IOException {

        OutputStream file = new FileOutputStream(this.filePath);
        OutputStream buffer = new BufferedOutputStream(file);
        ObjectOutput output = new ObjectOutputStream(buffer);

        // serialize the Map
        output.writeObject(object);
        output.close();
    }


    /**
     * Store the users to file at filePath.
     *
     * @return object in the file
     * @throws IOException
     */
    @Override
    public Object readFromFile() throws IOException, ClassNotFoundException {

        InputStream file = new FileInputStream(this.filePath);
        InputStream buffer = new BufferedInputStream(file);
        ObjectInput input = new ObjectInputStream(buffer);

        // serialize the Map
        Object object = input.readObject();
        input.close();
        return object;
    }

    public StorageReadWriter(String filePath){
        this.filePath = filePath;
    }
}
