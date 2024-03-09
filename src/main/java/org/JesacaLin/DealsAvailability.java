package org.JesacaLin;
import java.time.DayOfWeek;
import java.util.*;
public class DealsAvailability implements ReadableWriteableWithID {
    private String id;
    private String dealId;
    private String stringOfDays;
    private List<DayOfWeek> listOfDays = new ArrayList<>();

    private DealsAvailability(String dealId, String stringOfDays) {
        this.id = getId();
        this.dealId = dealId;
        this.stringOfDays = stringOfDays;
        this.listOfDays = convertToArray();
    }
    //Need static factory method because stringOfDays needed to be initialized BEFORE using in the constructor.
    public static DealsAvailability createInstance(String dealId, String stringOfDays) {
        try {
            return new DealsAvailability(dealId, stringOfDays);
        } catch (Exception e) {
            System.out.println("Error creating an instance of Deals Availability");
            return null;
        }
    }
    @Override
    public String getId() {
        id = IDGenerator.generateID("deal_availability");
        return id;
    }
    private List<DayOfWeek> convertToArray() {
        String[] arr = stringOfDays.split(",");
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) {
                arr[i] = arr[i].trim();
            }
            DayOfWeek dayOfWeek = DayOfWeek.valueOf(arr[i].toUpperCase());
            listOfDays.add(dayOfWeek);
        }
        return listOfDays;
    }
    @Override
    public String toString() {
        return id + "," + dealId + "," + listOfDays;
    }
}
