package org.JesacaLin;
import java.time.DayOfWeek;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Map<String, String> establishmentMap = new HashMap<>();
        Map<String, String> dealsMap = new HashMap<>();

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

                //Populating Establishment Map
                //String[] parts = establishmentData.split("\\|", 2);
                //establishmentMap.put(parts[0], parts[1]);

                System.out.println(establishmentInstance.toString());


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
                //make a new map, then display relevant info to the user rather than the id as well
                String filePath = "data/Establishment.txt";
                DocReader.reader(filePath);

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
                    }
                }
            }
            if (menuInput.equals("4")) {}

            if (menuInput.equals("5")) {
                break;
            }
        }
    }
}