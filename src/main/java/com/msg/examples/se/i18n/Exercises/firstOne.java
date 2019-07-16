package com.msg.examples.se.i18n.Exercises;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class firstOne {
    public static void main(String[] args) {
        String country = "RO";
        String language = "ro";

        Locale locale = new Locale(language, country);
        try {
            ResourceBundle messages = ResourceBundle.getBundle("i18n/MyBundle", locale);

            String greetings = messages.getString("greetings");
            System.out.println(greetings);

            String inquiry = messages.getString("inquiry");
            System.out.println(inquiry
            );
            System.out.println(messages.getString("farewell"));

            Object[] messageArguments = {greetings, inquiry};
            MessageFormat formatter = new MessageFormat(messages.getString("parametrized"));
            formatter.setLocale(locale);
            String parametrized = formatter.format(messageArguments);
            System.out.println(parametrized);

        } catch (MissingResourceException e) {
            System.out.println("Nu exista limba selectata!");
        }
    }
}
