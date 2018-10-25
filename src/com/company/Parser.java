package com.company;

import Essences.Ticket;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Parser
{


    public  Boolean parse(String fileName, List<Ticket> tickets)
    {
        int ticketIndex = 0;
        ArrayList<String> tags= new ArrayList<>();
        tags.add(new String("carrier"));
        tags.add(new String("flightNum"));
        tags.add(new String("placeNum"));
        tags.add(new String("placeClass"));
        tags.add(new String("date"));
        tags.add(new String("time"));
        tags.add(new String("status"));
        tags.add(new String("fareBasisLeft"));
        tags.add(new String("fareBasisRight"));
        tags.add(new String("price"));
        tags.add(new String("origin"));
        tags.add(new String("destination"));
        tags.add(new String("passengerName"));
        tags.add(new String("passengerLastName"));
        tags.add(new String("document"));
        String[] xmlData = new String[tags.size()];
        int tagIndex = -1;
        String line;
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(fileName), StandardCharsets.UTF_8)))
        {
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
                        tickets.add(new Ticket());
                        ticketIndex++;
                    }
                    else
                    {
                        if(line.contains("</ticket>"))
                        {
                            /*LocalDate date = LocalDate.of(Integer.parseInt(xmlData[4].substring(0,xmlData[4].indexOf("-"))),
                                    Integer.parseInt(xmlData[4].substring(xmlData[4].indexOf("-")+1,xmlData[4].lastIndexOf("-"))),
                                    Integer.parseInt(xmlData[4].substring(xmlData[4].lastIndexOf("-")+1)));
                            LocalTime time = LocalTime.of(Integer.parseInt(xmlData[5].substring(0,xmlData[5].indexOf(":"))),
                                    Integer.parseInt(xmlData[5].substring(xmlData[5].indexOf(":")+1,xmlData[5].lastIndexOf(":"))));
                            LocalDate fareBasisLeft = LocalDate.of(Integer.parseInt(xmlData[7].substring(0,xmlData[7].indexOf("-"))),
                                    Integer.parseInt(xmlData[7].substring(xmlData[7].indexOf("-")+1,xmlData[7].lastIndexOf("-"))),
                                    Integer.parseInt(xmlData[7].substring(xmlData[7].lastIndexOf("-")+1)));
                            LocalDate fareBasisRight = LocalDate.of(Integer.parseInt(xmlData[8].substring(0,xmlData[8].indexOf("-"))),
                                    Integer.parseInt(xmlData[8].substring(xmlData[8].indexOf("-")+1,xmlData[8].lastIndexOf("-"))),
                                    Integer.parseInt(xmlData[8].substring(xmlData[8].lastIndexOf("-")+1)));
                            tickets.add(new Ticket(new String(xmlData[0]), new String(xmlData[1]), new String(xmlData[2]), new String(xmlData[3]), date, time,
                                    new String(xmlData[6]), fareBasisLeft, fareBasisRight, Double.parseDouble(xmlData[9]), new String(xmlData[10]), new String(xmlData[11]),
                                    new String(xmlData[12]), new String(xmlData[13]), new String(xmlData[14])));
                            System.out.print(xmlData[0] + "\n" + xmlData[1] + "\n" + xmlData[2] + "\n" + xmlData[3] + "\n" + date + "\n" + time + "\n" + xmlData[6] + "\n" + fareBasisLeft+"\n" +
                                    fareBasisRight + "\n" + Double.parseDouble(xmlData[9]) + "\n" + xmlData[10] + "\n" + xmlData[11] + "\n" + xmlData[12] + "\n" + xmlData[13] + "\n" + xmlData[14]);*/
                        }
                    }
                }
            }
        }
        catch (IOException e)
        {
            System.out.println(e.toString());
        }
        return  true;
    }
}
