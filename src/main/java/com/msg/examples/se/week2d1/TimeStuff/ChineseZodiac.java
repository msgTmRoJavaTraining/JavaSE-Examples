package com.msg.examples.se.week2d1.TimeStuff;

import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;

public class ChineseZodiac {
    public static ChiZodiac signOfYear(TemporalAccessor date){
        int ans=date.get(ChronoField.YEAR);
        ans=ans-2000;
        ans=ans%12;
        ans=ans+5;
        if(ans>12)ans=ans-12;

        return ChiZodiac.values()[ans-1];
    }





}


