package org.JesacaLin;
import java.util.*;
public class AddressConverter {
    //Must also chance the environment variable in intellij for this to run.
    //Need to restrict the api but...Google doc mentioned I can't if I want to use the geolocation services??
    private static final String API_Key = System.getenv("MY_GOOGLE_API_KEY");
    public static double[] convertAddressToCoordinates(String address) {
        //Check if the API key is set
        if (API_Key == null || API_Key.isEmpty()) {
            throw new IllegalArgumentException("API key is not set!");
        }
        try {
            double latitude = 0;
            double longitude = 0;
            return new double[] {latitude, longitude};
        } catch (Exception e) {
            System.err.println("Error converting address to coordinates: " + e.getMessage());
            return null;
        }
    }
}
