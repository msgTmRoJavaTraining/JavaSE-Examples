package com.msg.examples.se.datetime.Exercises;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;

public class ChineseYear {
    public static String findChineseYear(TemporalAccessor date) {
        int number = 0;
        String result;
        int year = date.get(ChronoField.YEAR);

        if (year > 2000) {
            number = year - 2000;
            number %= 12;
            number += 5;
            if(number>12)
                number-=12;
        } else if (year < 2000 && year > 1900) {
            number = year - 1900;
            number %= 12;
            number++;
        }

        switch (number) {
            case 1:
                result = ChineseZodiacAnimals.Rat.toString();
                break;
            case 2:
                result = ChineseZodiacAnimals.Ox.toString();
                break;
            case 3:
                result = ChineseZodiacAnimals.Tiger.toString();
                break;
            case 4:
                result = ChineseZodiacAnimals.Rabbit.toString();
                break;
            case 5:
                result = ChineseZodiacAnimals.Dragon.toString();
                break;
            case 6:
                result = ChineseZodiacAnimals.Snake.toString();
                break;
            case 7:
                result = ChineseZodiacAnimals.Horse.toString();
                break;
            case 8:
                result = ChineseZodiacAnimals.Goat.toString();
                break;
            case 9:
                result = ChineseZodiacAnimals.Monkey.toString();
                break;
            case 10:
                result = ChineseZodiacAnimals.Rooster.toString();
                break;
            case 11:
                result = ChineseZodiacAnimals.Dog.toString();
                break;
            case 12:
                result = ChineseZodiacAnimals.Pig.toString();
                break;
            default:
                result = "Wrong";
        }
        return result + " year.";
    }

    public enum ChineseZodiacAnimals {
        Rat, Ox, Tiger, Rabbit, Dragon, Snake, Horse, Goat, Monkey, Rooster, Dog, Pig
    }
}