package com.company;

import Essences.Ticket;
import Parsers.MyTicketDOMParser;
import Parsers.MyTicketSAXParser;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args) throws IOException
    {
       List<Ticket> tickets = new ArrayList<Ticket>();
        try {
            MyTicketDOMParser dP = new MyTicketDOMParser("Tickets.xml", "Tickets.xsd");
            dP.parse(tickets);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
       try {
           MyTicketSAXParser saxP = new MyTicketSAXParser(tickets, "Tickets.xml", "Tickets.xsd");
           saxP.parse();
           for (Ticket ticket: tickets)
           {
               ticket.printAttributes();
               System.out.println(ticket.toJson());
           }
       }
       catch (Exception e)
       {
           System.out.println(e.getMessage());
       }
    }
}
