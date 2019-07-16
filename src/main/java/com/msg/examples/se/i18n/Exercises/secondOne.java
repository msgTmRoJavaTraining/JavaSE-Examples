package com.msg.examples.se.i18n.Exercises;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

public class secondOne {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti un numar: ");
        String numberInput = scanner.next();

        Locale locale = new Locale("ro", "RO");

        NumberFormat numberFormatter = NumberFormat.getInstance(locale);
        System.out.println(numberFormatter.parse(numberInput));

        System.out.println("Introduceti o data calendaristica(in formatul dd MM yyyy): ");
        String dateInput = scanner.next();

        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        Date date = df.parse(dateInput);
        GregorianCalendar myDate = new GregorianCalendar();
        myDate.setTime(date);

        DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.FULL, locale);
        System.out.println(dateFormatter.format(date));
    }
}
