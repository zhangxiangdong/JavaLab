package me.zhang.calendar;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class WeekTest {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();

        int currentMonth = calendar.get(Calendar.MONTH);

        long currentTime = calendar.getTimeInMillis();
        calendar.add(Calendar.MONTH, -3);
        long threeMonthAgoTime = calendar.getTimeInMillis();
        int interval = (int) ((currentTime - threeMonthAgoTime) / (24 * 3600 * 1000));

        calendar.set(Calendar.MONTH, currentMonth);

        System.out.println("3个月天数：" + interval);

        List<Week> weeks = new ArrayList<Week>() {
            @Override
            public String toString() {
                Iterator<Week> it = iterator();
                if (!it.hasNext())
                    return "[]";

                StringBuilder sb = new StringBuilder();
                sb.append('[').append('\n');
                for (; ; ) {
                    sb.append('\t');
                    Week e = it.next();
                    sb.append(e);
                    if (!it.hasNext())
                        return sb.append('\n').append(']').toString();
                    sb.append('\n');
                }
            }
        };

        weeks.add(new Week());
        int weekIndex = 0;

        final int future = 13;
        calendar.add(Calendar.DAY_OF_MONTH, future);
        for (int i = -future; i < interval; i++) {
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
            int month = calendar.get(Calendar.MONTH) + 1;

            String week = null;
            switch (dayOfWeek) {
                case Calendar.SUNDAY:
                    week = "SUNDAY";
                    break;
                case Calendar.MONDAY:
                    week = "MONDAY";
                    break;
                case Calendar.TUESDAY:
                    week = "TUESDAY";
                    break;
                case Calendar.WEDNESDAY:
                    week = "WEDNESDAY";
                    break;
                case Calendar.THURSDAY:
                    week = "THURSDAY";
                    break;
                case Calendar.FRIDAY:
                    week = "FRIDAY";
                    break;
                case Calendar.SATURDAY:
                    week = "SATURDAY";
                    break;
            }

            // System.out.println(week + " " + month + "月" + dayOfMonth + "日" + (i == 0 ? "（今天）" : ""));

            Week w = weeks.get(weekIndex);
            if (w != null) {
                w.days.add(new Week.Day(week + "|" + month + "月" + dayOfMonth + "日" + (i == 0 ? "（今天）" : "")));
            }

            if (dayOfWeek == Calendar.SUNDAY) {
                // System.out.println("---");
                Week next = new Week();
                weekIndex++;
                weeks.add(next);
            }

            calendar.add(Calendar.DAY_OF_MONTH, -1);
        }

        System.out.println(weeks);
    }

    public static class Week {

        @NotNull
        public final List<Day> days = new ArrayList<>();

        @Override
        public String toString() {
            ArrayList<Day> reverse = new ArrayList<>(days);
            Collections.reverse(reverse);

            return "Week{" +
                    "days=" + reverse +
                    '}';
        }

        public static class Day {
            @NotNull
            public final String day;

            public Day(@NotNull String day) {
                this.day = day;
            }

            @Override
            public String toString() {
                return day;
            }
        }

    }

}
