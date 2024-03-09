package org.JesacaLin;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
//import java.util.Scanner;
public class DocReader  {
    public static void reader (String filePath) {
        File dataFile = new File(filePath);
        try (Scanner dataInput = new Scanner(dataFile)) {
            while (dataInput.hasNextLine()) {
                String lineOfInput = dataInput.nextLine();
                System.out.println(lineOfInput);
            }
        } catch (FileNotFoundException e) {
            System.err.println("The file does not exist.");
        }

    }
}
