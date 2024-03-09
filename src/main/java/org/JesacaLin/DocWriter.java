package org.JesacaLin;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.*;
public class DocWriter {
    public static void writer (String filePath, String dataString) {
        try (PrintWriter dataOutput = new PrintWriter(new FileOutputStream(filePath, true))) {
           dataOutput.println(dataString);
        } catch (FileNotFoundException e) {
            System.err.println("Cannot open the file for writing");
        }
    }
}
