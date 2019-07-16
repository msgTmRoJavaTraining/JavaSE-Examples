package com.msg.examples.se.Day7;

import java.text.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class InternationalizationMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please select language: ");
        String language = scanner.next("\\w\\w");
        Locale locale;
        String region = null;
        String country = "US";
        if (language.equals("ro")) {
            country = "RO";
            region = "mda";
        }
        if(region!= null){
            locale = new Locale(language, country,region);
        }else{
            locale = new Locale(language, country);
        }

        try {
            ResourceBundle messages = ResourceBundle.getBundle("i18n/MyBundle", locale);
            String greetings = messages.getString("greetings");
            System.out.println("This is hello: " + greetings);
            String inquiry = messages.getString("inquiry");
            System.out.println("This is how are you: " + inquiry);
            String farewell = messages.getString("farewell");
            System.out.println("This is goodbye: " + farewell);

            String firstWord = "A traji";
            String secondWord = "țîgară";
            Object[] messageArguments = {firstWord, secondWord};
            MessageFormat formatter = new MessageFormat(messages.getString("parametrized"));
            formatter.setLocale(locale);
            String parametrized = formatter.format(messageArguments);
            System.out.println("This is a regional expresion: " + parametrized);

        } catch (MissingResourceException ex) {
            System.out.println("Resource bundle not found!");
        }
        Scanner secondScanner = new Scanner(System.in);
        System.out.print("Insert string to be converted into number: ");
        int input = Integer.parseInt(secondScanner.next());
        NumberFormat numberFormatter = NumberFormat.getInstance(locale);
        System.out.println(numberFormatter.format(input));


        Scanner thirdScanner = new Scanner(System.in);
        System.out.print("Insert string to be converted into date: ");
        String thirdinput = thirdScanner.next("\\d{2}/\\d{2}/\\d{4}");
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date startDate;
        try {
            startDate = df.parse(thirdinput);
            String newDateString = df.format(startDate);
            System.out.println("Date is: "+ newDateString);
            Instant instant = startDate.toInstant();
            LocalDateTime ldt = instant.atOffset(ZoneOffset.UTC).toLocalDateTime();
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd' T 'HH:mm:ss");
            System.out.println(ldt.format(fmt));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
