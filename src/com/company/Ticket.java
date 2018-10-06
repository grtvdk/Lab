package com.company;

public class Ticket
{
    String flightNum;
    String placeNum;
    Double price;
    String passengerName;
    String passengerLastName;
    String passportData;
    public Ticket()
    {
        flightNum = "";
        placeNum = "";
        price = 0.;
        passengerName = "";
        passengerLastName = "";
        passportData = "";
    }
    public void setFlightNum(String flightNum)
    {
        this.flightNum = flightNum;
    }
    public String getFlightNum()
    {
        return flightNum;
    }
    public void setPlaceNum(String placeNum)
    {
        this.placeNum = placeNum;
    }
    public String getPlaceNum()
    {
        return placeNum;
    }
    public void setPrice(Double price)
    {
        this.price = price;
    }
    public Double getPrice()
    {
        return price;
    }
    public void setPassengerName(String passengerName)
    {
        this.passengerName = passengerName;
    }
    public String getPassengerName()
    {
        return passengerName;
    }
    public void setPassengerLastName(String passengerLastName)
    {
        this.passengerLastName = passengerLastName;
    }
    public String getPassengerLastName()
    {
        return passengerLastName;
    }
    public void setPassportData(String passportData)
    {
        this.passportData = passportData;
    }
    public String getPassportData()
    {
        return passportData;
    }
}
