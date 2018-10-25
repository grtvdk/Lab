package Essences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Passenger {
    private String passengerName;
    private String passengerLastName;
    private String document;

    public Passenger() {
        this.passengerName = "";
        this.passengerLastName = "";
        this.document = "";
    }
    public Passenger (String passengerName, String passengerLastName, String document) {
        this.passengerName = passengerName;
        this.passengerLastName = passengerLastName;
        this.document = document;
    }
    public Passenger(HashMap<String, String> attributes) {
        List<String> attributeNames = Passenger.getAttributeNames();
        for (String attributeName : attributeNames) {
            switch (attributeName){
                case "passengerName":
                    this.passengerName = attributes.get(attributeName);
                    break;
                case "passengerLastName":
                    this.passengerLastName = attributes.get(attributeName);
                    break;
                case "document":
                    this.document = attributes.get(attributeName);
                    break;
                default:
                    System.out.println("No such attribute's name");
            }
        }
    }
    public static List<String> getAttributeNames() {
        List<String> attributeNames = new ArrayList<>();
        attributeNames.add("passengerName");
        attributeNames.add("passengerLastName");
        attributeNames.add("document");
        return attributeNames;
    }
    public String toJson() {
        return "{\"passengerName\": \""+ this.passengerName +
                "\",\"passengerLastName\": \"" + this.passengerLastName +
                "\",\"document\": \"" + this.document +
                "\"}";
    }
}
