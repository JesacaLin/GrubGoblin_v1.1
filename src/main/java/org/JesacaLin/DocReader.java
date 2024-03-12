package org.JesacaLin;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
//import java.util.Scanner;
public class DocReader  {
    //maybe return a map, key is the id and the value is the establishment info. makes it easy to display to users in the main method.
    public static Map<String, String> reader (String filePath) {
        Map<String, String> establishmentMap = new HashMap<>();
        File dataFile = new File(filePath);
        try (Scanner dataInput = new Scanner(dataFile)) {
            while (dataInput.hasNextLine()) {
                String lineOfInput = dataInput.nextLine();
                if (!lineOfInput.isEmpty()) {
                    String[] parts = lineOfInput.split("\\|", 2);
                    establishmentMap.put(parts[0], parts[1]);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("The file does not exist.");
        }
        return establishmentMap;
    }
    public static void dealsTypeReader(String filePath, String userInput) {
        File dataFile = new File(filePath);
        try (Scanner dataInput = new Scanner(dataFile)) {
            while (dataInput.hasNextLine()) {
                String lineOfInput = dataInput.nextLine();
                String typeOfDeal = "";
                switch (userInput) {
                    case "1" -> typeOfDeal = "Drinks Deal";
                    case "2" -> typeOfDeal = "Food Deal";
                    case "3" -> typeOfDeal = "Grocery Deal";
                    case "4" -> typeOfDeal = "Other";
                    }
                if (lineOfInput.contains(typeOfDeal)) {
                    System.out.println(lineOfInput);
                }
            }
        }catch (FileNotFoundException e) {
            System.err.println("The file does not exist.");
        }
    }
}
