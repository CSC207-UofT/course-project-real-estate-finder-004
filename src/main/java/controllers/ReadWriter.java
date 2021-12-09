package controllers;

import java.io.IOException;

// Adapted from https://github.com/CSC207-UofT/CleanArchLoginSample/blob/main/src/edu/toronto/csc207/ReadWriter.java

public interface ReadWriter {
    void saveToFile() throws IOException;
    Object readFromFile() throws IOException, ClassNotFoundException;
}
