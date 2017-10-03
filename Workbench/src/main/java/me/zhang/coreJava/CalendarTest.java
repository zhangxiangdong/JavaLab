package me.zhang.coreJava;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Zhang on 10/3/2017 4:16 PM.
 */
public class CalendarTest {

    public static void main(String[] args) {
        // construct d as current date
        GregorianCalendar d = new GregorianCalendar();
        final int today = d.get(Calendar.DAY_OF_MONTH);
        final int month = d.get(Calendar.MONTH);

        // set d to start date of the month
        d.set(Calendar.DAY_OF_MONTH, 1);

        int weekday = d.get(Calendar.DAY_OF_WEEK);

        // get first day of week
        int firstDayOfWeek = d.getFirstDayOfWeek();

        // determine the required indentation for the first line
        int indent = 0;
        while (weekday != firstDayOfWeek) {
            indent++;
            d.add(Calendar.DAY_OF_MONTH, -1);
            weekday = d.get(Calendar.DAY_OF_WEEK);
        }

        // 1. print weekday names
        String[] weekdayNames = new DateFormatSymbols().getShortWeekdays();
        do {
            System.out.printf("%4s", weekdayNames[weekday]);
            d.add(Calendar.DAY_OF_MONTH, 1);
            weekday = d.get(Calendar.DAY_OF_WEEK);
        } while (weekday != firstDayOfWeek);
        System.out.println();
        for (int i = 1; i <= indent; i++) {
            System.out.println("   ");
        }

        d.set(Calendar.DAY_OF_MONTH, 1);
        do {
            // 2. print day
            int day = d.get(Calendar.DAY_OF_MONTH);
            System.out.printf("%3d", day);

            // mark current day with *
            if (day == today) {
                System.out.print("*");
            } else {
                System.out.print(" ");
            }

            // advance d to the next day
            d.add(Calendar.DAY_OF_MONTH, 1);
            weekday = d.get(Calendar.DAY_OF_WEEK);

            // start a new line at the start of the week
            if (weekday == firstDayOfWeek) {
                System.out.println();
            }
        } while (d.get(Calendar.MONTH) == month);
        // the loop exits when d is day 1 of the next month

        // print final end of line if necessary
        if (weekday != firstDayOfWeek) {
            System.out.println();
        }
    }

}
