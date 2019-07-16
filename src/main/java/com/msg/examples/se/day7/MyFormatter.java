package com.msg.examples.se.day7;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class MyFormatter {

    public static void main(String args[]) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please select language: ");
        String language = scanner.next("\\w\\w");
        String country = "US";
        if (language.equals("ro")) {
            country = "RO";
        }

        Locale locale = new Locale(language, country);

        try {
            ResourceBundle messages = ResourceBundle.getBundle("i18n/MyBundle", locale);

            String greetings = messages.getString("greetings");
            System.out.println(greetings);
            String inquiry = messages.getString("inquiry");
            System.out.println(inquiry);
            String farewell = messages.getString("farewell");
            System.out.println(farewell);

        } catch (MissingResourceException ex) {
            System.out.println("Resource bundle not found!");
        }

        System.out.println("Please write a number:");
        String stringNumber=scanner.next();
        double number =Double.valueOf(stringNumber);

        NumberFormat numberFormatter = NumberFormat.getInstance(locale);
        System.out.println(numberFormatter.format(number));


        System.out.println("Please write a date:");
        String stringDate=scanner.next();

        Date dateFormatter=new SimpleDateFormat("dd/MM/yyyy").parse(stringDate);
        DateFormat date = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
        System.out.println(date.format(dateFormatter));

    }
}
