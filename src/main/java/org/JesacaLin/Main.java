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
            //String menuInput = scanner.nextLine().toLowerCase();
            String menuInput = UserInput.getStringInput(menu);

            //ADDING A DEAL
            if (menuInput.equals("1")) {
                String userInputName = UserInput.getStringInput("What is the name of the establishment?");
                String userInputAddress = UserInput.getStringInput("What is the full address?");
                Establishment newEstablishment = new Establishment(userInputName, userInputAddress);
                String establishedId = newEstablishment.getId();

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

                Deals newDeal = new Deals(establishedId, userInputTypeOfDeal, userInputDealDetails);
                String dealId = newDeal.getId();

                String userInputDays = UserInput.getStringInput("What day is this deal available? If more than multiple days, separate with a ',' ");
                
                DealsAvailability dealsAvailability = new DealsAvailability(dealId, userInputDays);
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