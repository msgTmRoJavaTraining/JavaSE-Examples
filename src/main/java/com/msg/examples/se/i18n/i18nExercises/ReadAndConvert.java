package com.msg.examples.se.i18n.i18nExercises;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAccessor;
import java.util.*;

public class ReadAndConvert {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.print("Write a number");
        String string = scanner.next();

        NumberFormat numberFormatter = NumberFormat.getInstance(new Locale("ro","RO"));
        System.out.println(numberFormatter.format(Double.valueOf(string)));

        System.out.println("Write a date with format yyyy-MM-dd");
        String string1 = scanner.next();
        LocalDate localDate = LocalDate.parse(string1);
        Date date = Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());

        DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.MEDIUM, new Locale("ro","RO"));
        System.out.println("Your date"+dateFormatter.format(date));
        System.out.println("\n");
        System.out.println("Introduce another date");
        String string2 = scanner.next();
        DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        localDate = LocalDate.parse(string2);
        System.out.println("Your date"+FOMATTER.format(localDate));
    }

}
