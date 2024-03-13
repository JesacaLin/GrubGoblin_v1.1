package org.JesacaLin;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class DocReader  {
    public static void reader (String filePath) {
        File dataFile = new File(filePath);
        try (Scanner dataInput = new Scanner(dataFile)) {
            while (dataInput.hasNextLine()) {
                String lineOfInput = dataInput.nextLine();
                System.out.println(lineOfInput);
                System.out.println("*".repeat(12));
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

    public static Map<String, List<String>> daysReader(String filePath, String dayOfDeal) {
        Map<String, List<String>> daysMap = new HashMap<>();
        File dataFile = new File(filePath);
        try (Scanner dataInput = new Scanner(dataFile)) {
            while (dataInput.hasNextLine()) {
                String lineOfInput = dataInput.nextLine();
                if (lineOfInput.contains(dayOfDeal)) {
                    String[] parts = lineOfInput.split("\\|");
                    String availableId = parts[0];
                    String dealId = parts[1];
                    String daysString = parts[2].substring(1, parts[2].length() -1);
                    String[] daysArr = daysString.split(",");
                    List<String> daysMapArray = new ArrayList<>();
                    //Looping through the daysArr and adding each day with the corresponding dealsId
                    for (String day : daysArr) {
                        day = day.trim();
                        daysMapArray.add(dealId + "|" + day);
                    }
                    //Adding the finished Array as the Map's value, the unique availableID is the key
                    daysMap.put(availableId, daysMapArray);
                }
            }
        }catch (FileNotFoundException e) {
            System.err.println("The file does not exist.");
        }
        return daysMap;
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
