package com.company;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("Tickets.xml"), StandardCharsets.UTF_8)))
        {
            Parser p = new Parser();
            p.parse(reader, new ArrayList<>());
        }
        catch (IOException e)
        {
            System.out.println(e.toString());
        }
    }
}
