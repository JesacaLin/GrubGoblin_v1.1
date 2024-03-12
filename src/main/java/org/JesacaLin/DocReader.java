package org.JesacaLin;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
//import java.util.Scanner;
public class DocReader  {
    //maybe return a map, key is the id and the value is the establishment info. makes it easy to display to users in the main method.
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
    public static Map<String, String> dealsTypeReader(String filePath, String userInput) {
        Map<String, String> dealsMap = new HashMap<>();
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
                    String[] parts = lineOfInput.split("\\|", 2);
                    dealsMap.put(parts[0], parts[1]);
                }
            }
        }catch (FileNotFoundException e) {
            System.err.println("The file does not exist.");
        }
        return dealsMap;
    }

    public static Map<String, String> establishmentReader (String filePath) {
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

}
