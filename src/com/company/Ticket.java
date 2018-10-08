package com.company;

public class Ticket
{
    private String stopover;
    private String carrier;
    private String flightNum;
    private String placeNum;
    private String placeClass;
    private String date;
    private String time;
    private String status;
    private String fareBasis;
    private Double price;
    private String formOfPaint;
    private String origin;
    private String destination;
    private String passengerName;
    private String passengerLastName;
    private String document;
    public Ticket()
    {
        stopover = "";
        carrier = "";
        flightNum = "";
        placeNum = "";
        placeClass = "";
        date = "";
        time = "";
        status = "";
        fareBasis = "";
        price = 0.;
        formOfPaint = "";
        origin = "";
        destination = "";
        passengerName = "";
        passengerLastName = "";
        document = "";
    }
    public void setStopover(String stopover)
    {
        this.stopover = stopover;
    }
    public String getStopover()
    {
        return stopover;
    }
    public void setCarrier(String carrier)
    {
        this.carrier = carrier;
    }
    public String getCarrier()
    {
        return carrier;
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
    public void setPlaceClass(String placeClass)
    {
        this.placeClass = placeClass;
    }
    public String getPlaceClass()
    {
        return placeClass;
    }
    public void setDate(String date)
    {
        this.date = date;
    }
    public String getDate()
    {
        return date;
    }
    public void setTime(String time)
    {
        this.time = time;
    }
    public String getTime()
    {
        return time;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }
    public String getStatus()
    {
        return status;
    }
    public void setFareBasis(String fareBasis)
    {
        this.fareBasis = fareBasis;
    }
    public String getFareBasis()
    {
        return fareBasis;
    }
    public void setPrice(Double price)
    {
        this.price = price;
    }
    public Double getPrice()
    {
        return price;
    }
    public void setFormOfPaint(String formOfPaint)
    {
        this.formOfPaint = formOfPaint;
    }
    public String getFormOfPaint()
    {
        return formOfPaint;
    }
    public void setOrigin(String origin)
    {
        this.origin = origin;
    }
    public String getOrigin()
    {
        return origin;
    }
    public void setDestination(String destination)
    {
        this.destination = destination;
    }
    public String getDestination()
    {
        return destination;
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
    public void setDocument(String passportData)
    {
        this.document = passportData;
    }
    public String getDocument()
    {
        return document;
    }
}
