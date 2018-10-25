package Essences;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Ticket {
    private String carrier;
    private String flightNum;
    private String placeNum;
    private String placeClass;
    private LocalDate date;
    private LocalTime time;
    private String status;
    private Double price;
    private String origin;
    private String destination;
    private Passenger passenger;
    private Boolean sellStatus;

    public Ticket() {
        carrier = "";
        flightNum = "";
        placeNum = "";
        placeClass = "";
        date = LocalDate.EPOCH;
        time = LocalTime.MIN;
        status = "";
        price = 0.;
        origin = "";
        destination = "";
        passenger = new Passenger();
        sellStatus = false;
    }
    public Ticket(String carrier, String flightNum, String placeNum, String placeClass, LocalDate date, LocalTime time, String status, Double price, String origin, String destination) {
        this.carrier = carrier;
        this.flightNum = flightNum;
        this.placeNum = placeNum;
        this.placeClass = placeClass;
        this.date = date;
        this.time = time;
        this.status = status;
        this.price = price;
        this.origin = origin;
        this.destination = destination;
        passenger = new Passenger();
        sellStatus = false;
    }
    public  Ticket(HashMap<String, String> atributes) {
        List<String> attributeNames = Ticket.getAttributeNames();
        for (String attributeName : attributeNames) {
            switch (attributeName){
                case "carrier":
                    this.carrier = atributes.get(attributeName);
                    break;
                case "flightNum":
                    this.flightNum = atributes.get(attributeName);
                    break;
                case "placeNum":
                    this.placeNum = atributes.get(attributeName);
                    break;
                case "placeClass":
                    this.placeClass = atributes.get(attributeName);
                    break;
                case "date":
                    this.date = LocalDate.of(Integer.parseInt(atributes.get(attributeName).substring(0,atributes.get(attributeName).indexOf("-"))),
                            Integer.parseInt(atributes.get(attributeName).substring(atributes.get(attributeName).indexOf("-")+1,atributes.get(attributeName).lastIndexOf("-"))),
                            Integer.parseInt(atributes.get(attributeName).substring(atributes.get(attributeName).lastIndexOf("-")+1)));
                    break;
                case "time":
                    this.time = LocalTime.of(Integer.parseInt(atributes.get(attributeName).substring(0,atributes.get(attributeName).indexOf(":"))),
                            Integer.parseInt(atributes.get(attributeName).substring(atributes.get(attributeName).indexOf(":")+1,atributes.get(attributeName).lastIndexOf(":"))));
                    break;
                case "status":
                    this.status = atributes.get(attributeName);
                    break;
                case "price":
                    this.price = Double.parseDouble(atributes.get(attributeName));
                    break;
                case "origin":
                    this.origin = atributes.get(attributeName);
                    break;
                case "destination":
                    this.destination = atributes.get(attributeName);
                    break;
                default:
                    System.out.println("No such attribute's name");
            }
        }
        passenger = new Passenger();
        sellStatus = false;
    }
    public void addPassenger(Passenger passenger)
    {
        this.passenger = passenger;
        sellStatus = true;
    }
    public boolean isSold()
    {
        if (sellStatus)
            return true;
        return false;
    }
    public static List<String> getAttributeNames() {
        List<String> attributeNames = new ArrayList<>();
        attributeNames.add("carrier");
        attributeNames.add("flightNum");
        attributeNames.add("placeNum");
        attributeNames.add("placeClass");
        attributeNames.add("date");
        attributeNames.add("time");
        attributeNames.add("status");
        attributeNames.add("price");
        attributeNames.add("origin");
        attributeNames.add("destination");
        return attributeNames;
    }
    public void printAttributes() {
        System.out.println(this.carrier + " " + this.flightNum + " " + this.placeNum + " " + this.placeClass + " " + this.date + " " + this.time + " " + this.status + " " + this.price + " " + this.origin +
                " " + this.destination);
    }
    public String toJson() {
        return "{\"carrier\": \""+ this.carrier +
                "\",\"flightNum\": \"" + this.flightNum +
                "\",\"placeNum\": \"" + this.placeNum +
                "\",\"placeClass\": \"" + this.placeClass +
                "\",\"date\": \"" + this.date +
                "\",\"time\": \"" + this.time +
                "\",\"status\": \"" + this.status +
                "\",\"price\": \"" + this.price +
                "\",\"origin\": \"" + this.origin +
                "\",\"destination\": \"" + this.destination +
                "\"}";
    }
}
