package org.JesacaLin;
import java.time.DayOfWeek;
import java.util.*;
public class Main {
    public static void main(String[] args) {

        while (true) {
            //MENU - Intellij suggested I change it to a text block.
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
                //System.out.println(newEstablishment.toString());

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
                System.out.println(newDeal.toString());

                //Gathering Deals Availability data
                String userInputDays = UserInput.getStringInput("What day is this deal available? If more than multiple days, separate with a ',' ");

                //Create new Deals Availability instance
                DealsAvailability instance = DealsAvailability.createInstance(dealId,  userInputDays);
                assert instance != null;

                System.out.println(instance.toString());
            }
            if (menuInput.equals("2")) {}
            if (menuInput.equals("3")) {}
            if (menuInput.equals("4")) {}
            if (menuInput.equals("5")) {
                break;
            }
        }
    }
}