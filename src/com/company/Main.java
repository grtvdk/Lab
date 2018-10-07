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
        boolean flag = false;
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        int ticketIndex = -1;
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("Ticket.xml"), StandardCharsets.UTF_8)))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {

                if(line.indexOf("<")!=line.lastIndexOf("<"))
                {
                    try
                    {
                        if(line.contains("<flightNum>"))
                            tickets.get(ticketIndex).setFlightNum(new String(getData(line)));
                        else
                        {
                            if(line.contains("<placeNum>"))
                                tickets.get(ticketIndex).setPlaceNum(new String(getData(line)));
                            else
                            {
                                if(line.contains("<price>"))
                                    tickets.get(ticketIndex).setPrice(new Double(Double.parseDouble(getData(line))));
                                else
                                {
                                    if (line.contains("<passengerName>"))
                                        tickets.get(ticketIndex).setPassengerName(new String(getData(line)));
                                    else {
                                        if (line.contains("<passengerLastName>"))
                                            tickets.get(ticketIndex).setPassengerLastName(new String(getData(line)));
                                        else {
                                            if (line.contains("<passportData>"))
                                                tickets.get(ticketIndex).setPassportData(new String(getData(line)));
                                        }
                                    }
                                }
                            }
                        }
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
                            flag=false;
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
            System.out.print(t.getFlightNum()+"\n"+t.getPlaceNum()+"\n"+t.getPrice()+"\n"+t.getPassengerName()+"\n"+t.getPassengerLastName()+"\n"+t.getPassportData());
        }
    }
    private static String getData(String xmlString)
    {
        return new String(xmlString.substring(xmlString.indexOf(">")+1,xmlString.lastIndexOf("<")));
    }
}
