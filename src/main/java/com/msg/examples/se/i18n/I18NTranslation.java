package com.msg.examples.se.i18n;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Scanner;

class frI18NTranslation {

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Please select language: ");
    String language = scanner.next("\\w\\w");
    String country = "US";
    if (language.equals("fr")) {
      country = "FR";
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

      Object[] messageArguments = {greetings, inquiry};
      MessageFormat formatter = new MessageFormat(messages.getString("parametrized"));
      formatter.setLocale(locale);
      String parametrized = formatter.format(messageArguments);
      System.out.println(parametrized);
    } catch (MissingResourceException ex) {
      System.out.println("Resource bundle not found!");
    }
  }
}
