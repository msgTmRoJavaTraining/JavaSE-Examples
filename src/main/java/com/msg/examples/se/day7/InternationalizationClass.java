package com.msg.examples.se.day7;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.*;

public class InternationalizationClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please select your language: ");
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
        System.out.print("You've selected the language " + language + ", from country " + country);

        System.out.println("\nType a decimal number:");
        double givenNumber = scanner.nextDouble();

        NumberFormat numberFormatter = NumberFormat.getInstance(locale);
        System.out.println("You typed: " + numberFormatter.format(givenNumber));

        System.out.println("\nIntroducing a date");
        System.out.println("Year: ");
        int givenYear = scanner.nextInt();

        System.out.println("Month: ");
        int givenMonth = scanner.nextInt();

        System.out.println("Day: ");
        int givenDay = scanner.nextInt();

        Date finalDate = null;

        try {
            finalDate = new SimpleDateFormat("dd-MM-yyyy").parse(givenDay + "-" + givenMonth + "-" + givenYear);
            DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
            System.out.println("Formatted date: " + dateFormatter.format(finalDate));
        } catch (ParseException e) {
            System.out.println("Datele introduse sunt incorecte");
        }
    }
}
