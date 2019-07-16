package com.msg.examples.se.i18n;

import java.text.*;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class StringFormater
{
    public static void main(String[] args) throws ParseException {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please select language: ");
        String language = scanner.next("\\w\\w");
        String country = "US";
        if (language.equals("fr")) {
            country = "FR";
        } else if (language.equals("de")) {
            country = "DE";
        } else if (language.equals("ro")) {
            country = "RO";
        }

        Locale locale = new Locale(language, country);


        String ex="120.05";

        NumberFormat numberFormatter = NumberFormat.getInstance(locale);
        System.out.println(numberFormatter.format(Double.parseDouble(ex)));

        Date data = null;

        int ziua=5;
        int luna=10;
        int anul=1927;

        String s=ziua+"-"+luna+"-"+anul;

        data = new SimpleDateFormat("dd-MM-yyyy").parse(s);

        DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.LONG, locale);
        System.out.println("Formatted date: " + dateFormatter.format(data));

    }
}
