package org.JesacaLin;
import java.time.DayOfWeek;
import java.util.*;
public class DealsAvailability implements ReadableWriteableWithID {
    private String id;
    private String dealId;
    private String stringOfDays;
    private List<DayOfWeek> listOfDays;

    public DealsAvailability(String dealId, String stringOfDays) {
        this.id = getId();
        this.dealId = dealId;
        this.listOfDays = convertToArray(stringOfDays);
    }

    @Override
    public String getId() {
        id = IDGenerator.generateID("deal_availability");
        return id;
    }
    public List<DayOfWeek> convertToArray(String days) {
        //List<DayOfWeek> listOfDays = new ArrayList<>();
        String[] arr = days.split(",");
        for(String day : arr) {
            DayOfWeek dayOfWeek = DayOfWeek.valueOf(day.toUpperCase());
            listOfDays.add(dayOfWeek);
        }
        return listOfDays;
    }
}
