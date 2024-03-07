package org.JesacaLin;
import java.util.*;
public class Deals implements ReadableWriteableWithID {
    private String id;
    //establishment id...how to get?
    private String establishmentId;
    private String typeOfDeal;
    private String dealDetails;

    @Override
    public String getId() {
        id = IDGenerator.generateID("deal");
        return id;
    }

    public Deals(String establishmentId, String typeOfDeal, String dealDetails) {
        this.id = getId();
        this.establishmentId = establishmentId;
        this.typeOfDeal = typeOfDeal;
        this.dealDetails = dealDetails;
    }

    public String getTypeOfDeal() {return typeOfDeal;}

    public void setTypeOfDeal(String typeOfDeal) { this.typeOfDeal = typeOfDeal;}

    public String getDealDetails() { return dealDetails;}

    public void setDealDetails(String dealDetails) {this.dealDetails = dealDetails;}

    @Override
    public String toString() {
        return id + " , " + establishmentId + " , " + typeOfDeal + " , " + dealDetails;
    }

}
