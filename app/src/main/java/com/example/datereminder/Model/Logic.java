package com.example.datereminder.Model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Logic {
    public static String fromSecondsToDateString(Long created){
        SimpleDateFormat formatterDate = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        return formatterDate.format(new Date(created * 1000));
    }

    public static long getActualDateInSeconds(){
        long tsLong = System.currentTimeMillis()/1000; // 1582930800000 /1000 to get to seconds
        return tsLong;
    }

//    public static long getDateInSeconds(){
//
//    }
}
