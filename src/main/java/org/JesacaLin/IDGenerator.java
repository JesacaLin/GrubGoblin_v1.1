package org.JesacaLin;
import java.util.*;
public class IDGenerator {
    public static String generateID(String className) {
        String uuidID = UUID.randomUUID().toString();
        return className.toUpperCase() + "_"+ uuidID;
    }
}
