package com.msg.examples.se.day6;

import com.msg.examples.se.exceptions.AvoidExceptionMasking;

import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.util.logging.Logger;

public class ChineseZodiacQuery {
    private static final Logger LOGGER = Logger.getLogger(AvoidExceptionMasking.class.getPackage().getName());

    public static ZodiacSign findZodiacSign(TemporalAccessor date) {
        int year = date.get(ChronoField.YEAR);


        switch (getChineseZodiacYear(year)) {
            case 1:
                return ZodiacSign.Rat;

            case 2:
                return ZodiacSign.Ox;

            case 3:
                return ZodiacSign.Tiger;

            case 4:
                return ZodiacSign.Rabbit;

            case 5:
                return ZodiacSign.Dragon;

            case 6:
                return ZodiacSign.Snake;

            case 7:
                return ZodiacSign.Horse;

            case 8:
                return ZodiacSign.Goat;

            case 9:
                return ZodiacSign.Monkey;

            case 10:
                return ZodiacSign.Rooster;

            case 11:
                return ZodiacSign.Dog;

            case 12:
                return ZodiacSign.Pig;
        }

        return ZodiacSign.Rat;
    }

    private static int getChineseZodiacYear(int year) {
        return ((year - 1900) % 12) + 1;
    }

    public enum ZodiacSign {
        Rat, Ox, Tiger, Rabbit, Dragon, Snake, Horse, Goat, Monkey, Rooster, Dog, Pig;
    }
}
