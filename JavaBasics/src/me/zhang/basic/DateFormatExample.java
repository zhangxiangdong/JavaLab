package me.zhang.basic;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Zhang on 2016/4/14 上午 10:50 .
 */
public class DateFormatExample {
    public static void main(String[] args) {
        Date d = new Date(1119280000000L);
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.CHINA);
        System.out.println(df.format(d));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        System.out.println(sdf.format(d));
    }
}
