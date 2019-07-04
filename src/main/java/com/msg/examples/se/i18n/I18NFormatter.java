package com.msg.examples.se.i18n;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class I18NFormatter {
  public static void main(String args[]) {
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

    double number = 346.548;
    NumberFormat numberFormatter = NumberFormat.getInstance(locale);
    System.out.println(numberFormatter.format(number));

    numberFormatter = NumberFormat.getCurrencyInstance(locale);
    System.out.println(numberFormatter.format(number));

    DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
    System.out.println(dateFormatter.format(new Date()));

    dateFormatter = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.SHORT, locale);
    System.out.println(dateFormatter.format(new Date()));
  }
}
