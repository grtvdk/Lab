package com.company;

import java.time.LocalDate;
import java.time.LocalTime;

public class Ticket
{
    private String carrier;
    private String flightNum;
    private String placeNum;
    private String placeClass;
    private LocalDate date;
    private LocalTime time;
    private String status;
    private LocalDate fareBasisLeft;
    private LocalDate fareBasisRight;
    private Double price;
    private String origin;
    private String destination;
    private String passengerName;
    private String passengerLastName;
    private String document;
    public Ticket()
    {
        carrier = "";
        flightNum = "";
        placeNum = "";
        placeClass = "";
        date = LocalDate.EPOCH;
        time = LocalTime.MIN;
        status = "";
        fareBasisLeft = LocalDate.EPOCH;
        fareBasisRight = LocalDate.EPOCH;
        price = 0.;
        origin = "";
        destination = "";
        passengerName = "";
        passengerLastName = "";
        document = "";
    }
    public Ticket(String carrier, String flightNum, String placeNum, String placeClass, LocalDate date, LocalTime time, String status, LocalDate fareBasisLeft,
                  LocalDate fareBasisRight, Double price, String origin, String destination, String passengerName, String passengerLastName, String document)
    {
        this.carrier = carrier;
        this.flightNum = flightNum;
        this.placeNum = placeNum;
        this.placeClass = placeClass;
        this.date = date;
        this.time = time;
        this.status = status;
        this.fareBasisLeft = fareBasisLeft;
        this.fareBasisRight = fareBasisRight;
        this.price = price;
        this.origin = origin;
        this.destination = destination;
        this.passengerName = passengerName;
        this.passengerLastName = passengerLastName;
        this.document = document;
    }
}
