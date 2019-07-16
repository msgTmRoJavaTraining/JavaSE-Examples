package com.msg.examples.se.week2d2;

import javafx.scene.input.DataFormat;

import javax.swing.text.NumberFormatter;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);

        double num=Double.parseDouble(scn.nextLine());
        Locale cont= new Locale("ro","RO");
        NumberFormat form= NumberFormat.getInstance(cont);
        System.out.println(form.format(num));

        String pattern="dd/MM/yyyy";
        SimpleDateFormat dtForm=new SimpleDateFormat(pattern);
        System.out.println("dati data in formatul an,luna,zi");

        Calendar cale=Calendar.getInstance();
        System.out.println("YYYY/MM/DD");
        cale.set(scn.nextInt(),scn.nextInt(),scn.nextInt());


        System.out.println(dtForm.format(cale.getTime()));
    }
}
