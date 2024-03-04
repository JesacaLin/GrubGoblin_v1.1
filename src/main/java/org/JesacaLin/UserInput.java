package org.JesacaLin;
import java.time.DayOfWeek;
import java.util.*;
public class UserInput {
    private String userInput;

    Scanner scanner = new Scanner(System.in)
    public String getStringInput(String prompt) {
        try {
            System.out.println(prompt);
            userInput = scanner.nextLine().toLowerCase();
        } catch (NullPointerException e) {
            System.out.println("Please enter an answer!");
        } finally {
            scanner.close();
        }
        return userInput;
    }
    public List<DayOfWeek> getDaysOfWeekInput(String prompt) {
        //please list days that the deal is available, if multiple, please separate by a common.
        //Display prompt
        System.out.println(prompt);
        //Initialize new ArrayList to store DayOfWeek;
        List<DayOfWeek> listOfDays = new ArrayList<>();
        String[] daysArray = scanner.nextLine().split(",");
        //need throw an exception if the strings in the day array does not match DayOfWeek constants.
        //convert each daysArray element into DayOfWeek and add to new Array.
        for (String day : daysArray) {
            try {
                DayOfWeek convertedDay = DayOfWeek.valueOf(day.toUpperCase());
                listOfDays.add(convertedDay);
            } catch (IllegalArgumentException e) {
                System.out.println(day + " is not a valid day of the week. Please try again");
            }
        }
        return listOfDays;
    }
}
