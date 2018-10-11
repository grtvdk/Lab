package com.company;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        /*boolean flag = false;
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        int ticketIndex = -1;
        ArrayList<String> tags= new ArrayList<String>();
        tags.add(new String("stopover"));
        tags.add(new String("carrier"));
        tags.add(new String("flightNum"));
        tags.add(new String("placeNum"));
        tags.add(new String("placeClass"));
        tags.add(new String("date"));
        tags.add(new String("time"));
        tags.add(new String("status"));
        tags.add(new String("fareBasis"));
        tags.add(new String("price"));
        tags.add(new String("formOfPaint"));
        tags.add(new String("origin"));
        tags.add(new String("destination"));
        tags.add(new String("passengerName"));
        tags.add(new String("passengerLastName"));
        tags.add(new String("document"));
        String[] xmlData = new String[tags.size()];
        int tagIndex = -1;
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("Tickets.xml"), StandardCharsets.UTF_8)))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {

                if(line.indexOf("<")!=line.lastIndexOf("<"))
                {
                    try
                    {
                        tagIndex = tags.indexOf(line.substring(line.indexOf("<")+1,line.indexOf(">")));
                        xmlData[tagIndex] = new String(new String(line.substring(line.indexOf(">")+1,line.lastIndexOf("<"))));
                    }
                    catch (Exception e)
                    {
                        System.out.println(e.toString());
                    }
                }
                else
                {
                    if(line.contains("<ticket>"))
                    {
                        flag=true;
                        tickets.add(new Ticket());
                        ticketIndex++;
                    }
                    else
                    {
                        if(line.contains("</ticket>"))
                        {
                            flag = false;
                            tickets.get(ticketIndex).setStopover(new String(xmlData[0]));
                            tickets.get(ticketIndex).setCarrier(new String(xmlData[1]));
                            tickets.get(ticketIndex).setFlightNum(new String(xmlData[2]));
                            tickets.get(ticketIndex).setPlaceNum(new String(xmlData[3]));
                            tickets.get(ticketIndex).setPlaceClass(new String(xmlData[4]));
                            tickets.get(ticketIndex).setDate(new String(xmlData[5]));
                            tickets.get(ticketIndex).setTime(new String(xmlData[6]));
                            tickets.get(ticketIndex).setStatus(new String(xmlData[7]));
                            tickets.get(ticketIndex).setFareBasis(new String(xmlData[8]));
                            tickets.get(ticketIndex).setPrice(new Double(Double.parseDouble(xmlData[9])));
                            tickets.get(ticketIndex).setFormOfPaint(new String(xmlData[10]));
                            tickets.get(ticketIndex).setOrigin(new String(xmlData[11]));
                            tickets.get(ticketIndex).setDestination(new String(xmlData[12]));
                            tickets.get(ticketIndex).setPassengerName(new String(xmlData[13]));
                            tickets.get(ticketIndex).setPassengerLastName(new String(xmlData[14]));
                            tickets.get(ticketIndex).setDocument(new String(xmlData[15]));
                        }
                    }
                }
            }
        }
        catch (IOException e)
        {
            System.out.println(e.toString());
        }
        for(Ticket t:tickets)
        {
            System.out.print(t.getStopover()+"\n"+t.getCarrier()+"\n"+t.getFlightNum()+"\n"+t.getPlaceNum()+"\n"+t.getPlaceClass()+"\n"+t.getDate()+"\n"+t.getTime()+"\n"+t.getStatus()+"\n"+
                    t.getFareBasis()+"\n"+t.getPrice()+"\n"+t.getFormOfPaint()+"\n"+t.getOrigin()+"\n"+t.getDestination()+"\n"+t.getPassengerName()+"\n"+t.getPassengerLastName()+"\n"+t.getDocument());
        }*/
    }
}
