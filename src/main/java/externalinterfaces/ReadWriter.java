package externalinterfaces;

import java.io.IOException;

public interface ReadWriter {
    /**
     */
    void saveToFile() throws IOException;

    /**
     */
    Object readFromFile() throws IOException, ClassNotFoundException;
}
