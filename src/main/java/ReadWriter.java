import java.io.IOException;

public interface ReadWriter {
    /**
     * @param filepath location of ser file
     * @param o object to be serialized
     */
    void saveToFile(Object o) throws IOException;

    /**
     * @param filepath location of ser file
     */
    Object readFromFile() throws IOException, ClassNotFoundException;
}
