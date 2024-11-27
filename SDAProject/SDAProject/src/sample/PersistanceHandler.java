package sample;

import java.util.ArrayList;

public interface PersistanceHandler {
    void write(String filename, String data);
    void Read(String filename);
}
