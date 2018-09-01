package com.nousunde.wxma.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FormatStr {

    public static String getThisWeek(){
        Calendar cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.setTime(new Date());
        int today = cal.get(Calendar.DAY_OF_WEEK);
        cal.add(Calendar.DAY_OF_WEEK, -today + Calendar.MONDAY);
        Date monday = cal.getTime();

        cal.add(Calendar.DAY_OF_WEEK, 6);
        Date sunday = cal.getTime();


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMdd");

        String s1 = simpleDateFormat.format(monday);
        String s2 = simpleDateFormat.format(sunday);
        return (s1 + "-" + s2);
//        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
//        String s = df.format(monday) + "-" + df.format(sunday);
//        logger.info(s);
    }
}
