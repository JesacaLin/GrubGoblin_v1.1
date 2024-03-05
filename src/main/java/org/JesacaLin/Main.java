package org.JesacaLin;
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
                String testing = UserInput.getStringInput("What is the name?");
                System.out.println(testing);
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