package org.JesacaLin;
import java.time.DayOfWeek;
import java.util.*;
public class Main {
    public static void main(String[] args) {

        while (true) {

            String menu = ("""
                    -------------------------------------------------
                    |   GRUB GOBLIN: Your Food Deals Directory      |
                    -------------------------------------------------
                    |  Please enter your selection from the menu    |
                    -------------------------------------------------
                    | 1: Add a deal                                 |
                    | 2: See all deals                              |
                    | 3: See all restaurants with deals             |
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
                Establishment newEstablishment = new Establishment(userInputName, userInputAddress);
                String establishedId = newEstablishment.getId();

                //Write Establishment to doc
                String establishmentData = newEstablishment.toString();
                DocWriter.writer("data/Establishment.txt", establishmentData);


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
            }
            if (menuInput.equals("3")) {}
            if (menuInput.equals("4")) {}
            if (menuInput.equals("5")) {
                break;
            }
        }
    }
}