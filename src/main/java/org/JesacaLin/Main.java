package org.JesacaLin;
import java.sql.SQLOutput;
import java.time.DayOfWeek;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Map<String, String> establishmentMap = new HashMap<>();
        Map<String, String> dealsMap = new HashMap<>();
        Map<String, List<String>> daysMap = new HashMap<>();

        while (true) {

            String menu = ("""
                    -------------------------------------------------
                    |   GRUB GOBLIN: Your Food Deals Directory      |
                    -------------------------------------------------
                    |  Please enter your selection from the menu    |
                    -------------------------------------------------
                    | 1: Add a deal                                 |
                    | 2: See all establishments with deals          |
                    | 3: See specific types of deals                |
                    | 4: See deals on a specific date               |
                    | 5: Exit                                       |
                    -------------------------------------------------
                    """);
            String menuInput = UserInput.getStringInput(menu);

            //ADDING A DEAL
            if (menuInput.equals("1")) {
                //Gathering Establishment Data
                String userInputName = UserInput.getStringInput("What is the name of the establishment?");
                String userInputAddress = UserInput.getStringInput("What is the full address?");

                //Create new Establishment Instance
                Establishment establishmentInstance = new Establishment(userInputName, userInputAddress);
                String establishedId = establishmentInstance.getId();

                //Write Establishment to doc
                String filePath = "data/Establishment.txt";
                String establishmentData = establishmentInstance.toString();
                DocWriter.writer(filePath, establishmentData);

                System.out.println(establishmentInstance.toString());
                System.out.println("*".repeat(12));
                System.out.println("\n".repeat(1));

                //Gathering Deal data
                String typeOfDeal = ("""
                    --------------------------
                    |  What type of deal?    |
                    --------------------------
                    | 1: Drinks Deal         |
                    | 2: Food Deal           |
                    | 3: Grocery Deal        |
                    | 4: Other               |
                    --------------------------
                    """);
                String userInputTypeOfDeal = UserInput.getStringInput(typeOfDeal);

                String userInputDealDetails = UserInput.getStringInput("Please provide details of the deal");

                //Creating new Deals Instance
                Deals newDeal = new Deals(establishedId, userInputTypeOfDeal, userInputDealDetails);
                String dealId = newDeal.getId();

                //Writing Deal to Docs
                String dealsData = newDeal.toString();
                DocWriter.writer("data/Deals.txt", dealsData);

                //Gathering Deals Availability data
                String userInputDays = UserInput.getStringInput("What day is this deal available? If more than multiple days, separate with a ',' ");

                //Create new Deals Availability instance
                DealsAvailability instance = DealsAvailability.createInstance(dealId,  userInputDays);
                assert instance != null;

                //Writing Deal Availability to Docs
                String dealsAvailabilityData = instance.toString();
                DocWriter.writer("data/DealAvailability.txt", dealsAvailabilityData);

            }
            if (menuInput.equals("2")) {
                //Reading the docs
                String filePath = "data/Establishment.txt";
                DocReader.reader(filePath);
                System.out.println("\n".repeat(1));
            }
            if (menuInput.equals("3")) {
                String typeOfDeal = ("""
                    ---------------------------------
                    |  What are you looking for?    |
                    ---------------------------------
                    | 1: Drinks Deal                |
                    | 2: Food Deal                  |
                    | 3: Grocery Deal               |
                    | 4: Other                      |
                    ---------------------------------
                    """);
                String userInput = UserInput.getStringInput(typeOfDeal);
                //Reading the docs
                String filePathDeals = "data/Deals.txt";
                dealsMap = DocReader.dealsTypeReader(filePathDeals, userInput);

                String filePathEstablishment = "data/Establishment.txt";
                establishmentMap = DocReader.establishmentReader(filePathEstablishment);
                if (!dealsMap.isEmpty()) {
                    for(Map.Entry<String, String> dealEntry : dealsMap.entrySet()) {
                        String dealEntryValue = dealEntry.getValue();
                        String[] parts = dealEntryValue.split("\\|");
                        String establishmentID = parts[0];
                        String type = parts[1];
                        String detail = parts[2];

                        System.out.println(type + "  @  " + establishmentMap.get(establishmentID) + "  --->  " + detail);
                        System.out.println("*".repeat(12));
                    }
                }
                System.out.println("\n".repeat(1));
            }
            if (menuInput.equals("4")) {
                String daysChoice = ("""
                    ---------------------------------
                    |  What days you looking for?   |
                    ---------------------------------
                    | 1: Monday                     |
                    | 2: Tuesday                    |
                    | 3: Wednesday                  |
                    | 4: Thursday                   |
                    | 5: Friday                     |
                    | 6: Saturday                   |
                    | 7: Sunday                     |
                    ---------------------------------
                    """);
                String userInput = UserInput.getStringInput(daysChoice);
                String dayOfDeal = "";
                switch (userInput) {
                    case "1" -> dayOfDeal = "MONDAY";
                    case "2" -> dayOfDeal = "TUESDAY";
                    case "3" -> dayOfDeal = "WEDNESDAY";
                    case "4" -> dayOfDeal = "THURSDAY";
                    case "5" -> dayOfDeal = "FRIDAY";
                    case "6" -> dayOfDeal = "SATURDAY";
                    case "7" -> dayOfDeal = "SUNDAY";
                }
                //Reading the docs
                String filePathDeals = "data/DealAvailability.txt";
                daysMap = DocReader.daysReader(filePathDeals, dayOfDeal);
                //if a map's value contains the user input, then search the deals array for value that contains the dealId, grab the establishment id, look in establishment map and get that info as well.
                if (!daysMap.isEmpty()) {
                    for(Map.Entry<String, List<String>> dayEntry : daysMap.entrySet()) {
                        //Grab the value of the map entry
                        List<String> mapValue = dayEntry.getValue();
                        //iterate and look for days matching user input
                            //if there is a match, split the string, first part is the dealsId, second is the day, store in variables
                        for (String stringValue : mapValue) {
                            if (stringValue.contains(dayOfDeal)) {
                                String[] splitStringValue = stringValue.split("\\|");
                                String dealId = splitStringValue[0];
                                String dealInfoFromDealMap = null;
                                for (String key : dealsMap.keySet()) {
                                    if (key.contains(dealId)) {
                                        dealInfoFromDealMap = dealsMap.get(key);
                                        break;
                                    }
                                }
                                if (dealInfoFromDealMap != null) {
                                    System.out.println(dayOfDeal + "  --->  " + dealInfoFromDealMap);
                                }
                            }
                        }
                        System.out.println("*".repeat(12));
                    }
                }
                System.out.println("\n".repeat(1));
            }
            if (menuInput.equals("5")) {
                break;
            }
        }
    }
}