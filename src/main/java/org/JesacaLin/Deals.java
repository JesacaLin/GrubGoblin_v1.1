package org.JesacaLin;
import java.util.*;
public class Deals implements ReadableWriteableWithID {
    private String id;
    //establishment id...how to get?
    private String establishmentId;
    private String userInputTypeOfDeal;
    private String typeOfDeal;
    private String dealDetails;

    public Deals(String establishmentId, String userInputTypeOfDeal, String dealDetails) {
        this.id = getId();
        this.establishmentId = establishmentId;
        this.typeOfDeal = getTypeOfDeal(userInputTypeOfDeal);
        this.dealDetails = dealDetails;
    }
    @Override
    public String getId() {
        id = IDGenerator.generateID("deal");
        return id;
    }
    public String getTypeOfDeal(String userInput) {
        switch (userInput) {
            case "1" -> typeOfDeal = "Drinks Deal";
            case "2" -> typeOfDeal = "Food Deal";
            case "3" -> typeOfDeal = "Grocery Deal";
            case "4" -> {
                return typeOfDeal = "Other";
            }
        }
        return typeOfDeal;
    }

    public String getDealDetails() { return dealDetails;}

    @Override
    public String toString() {
        return id + "|" + establishmentId + "|" + typeOfDeal + "|" + dealDetails;
    }

}
