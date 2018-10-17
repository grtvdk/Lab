package com.company;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args) throws IOException
    {
       Parser p = new Parser();
       DomParser dp = new DomParser("Tickets.xml");
       dp.parse();
       //p.parse("Tickets.xml",new ArrayList<Ticket>());
    }
}
