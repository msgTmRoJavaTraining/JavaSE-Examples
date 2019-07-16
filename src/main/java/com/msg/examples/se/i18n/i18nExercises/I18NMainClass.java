package com.msg.examples.se.i18n.i18nExercises;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class I18NMainClass {

    public static void main(String[] args){
        Locale local = new Locale.Builder().setLanguage("ro").setRegion("RO").build();


        try {
            ResourceBundle messages = ResourceBundle.getBundle("i18n/MyBundle", local);

            String greetings = messages.getString("greetings");
            System.out.println(greetings);
            String inquiry = messages.getString("inquiry");
            System.out.println(inquiry);
            String farewell = messages.getString("farewell");
            System.out.println(farewell);

            Object[] messageArguments = {greetings, inquiry};
            MessageFormat formatter = new MessageFormat(messages.getString("parametrized"));
            formatter.setLocale(local);
            String parametrized = formatter.format(messageArguments);
            System.out.println(parametrized);
        } catch (MissingResourceException ex) {
            System.out.println("Resource bundle not found!");
        }
    }

}
