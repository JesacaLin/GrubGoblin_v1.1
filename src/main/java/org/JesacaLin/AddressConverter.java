package org.JesacaLin;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import java.util.*;
public class AddressConverter {
    //Must also change the environment variable in intellij for this to run.
    //Need to restrict the api...
    //Look up more methods in Google Maps Service library for java.
    //way to shut down the api after use.
    private static final String API_Key = System.getenv("MY_GOOGLE_API_KEY");
    private static final GeoApiContext context = new GeoApiContext.Builder().apiKey(API_Key).maxRetries(3).build();
    public static double[] convertAddressToCoordinates(String address) {
        //Check if the API key is set
        if (API_Key == null || API_Key.isEmpty()) {
            throw new IllegalArgumentException("API key is not set!");
        }
        try {
            GeocodingResult[] results = GeocodingApi.geocode(context, address).await();
            if (results.length > 0) {
                double latitude = results[0].geometry.location.lat;
                double longitude = results[0].geometry.location.lng;
                return new double[] {latitude, longitude};
            } else {
                throw new Exception("No results found for address: " + address);
            }
        } catch (Exception e) {
            System.err.println("Error converting address to coordinates: " + e.getMessage());
            return null;
        }
    }
}
