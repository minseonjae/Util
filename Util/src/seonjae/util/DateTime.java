package seonjae.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTime {

    private boolean build = false;
    private long time;
    private LocalDateTime localDateTime = null;

    public DateTime() {
        this(System.currentTimeMillis());
    }
    public DateTime(boolean build) {
        this(System.currentTimeMillis(), build);
    }
    public DateTime(long time) {
        this.time = time;
    }
    public DateTime(long time, boolean build) {
        this.time = time;
        if (build) build();
    }
    public DateTime(String dateTime) {
        build = true;
        localDateTime = LocalDateTime.parse(dateTime);
    }

    public DateTime build() {
        if (!build) {
            localDateTime = LocalDateTime.ofInstant(new Date(time).toInstant(), ZoneId.systemDefault());
            build = true;
        }
        return this;
    }

    public int getYear() {
        if (!build) return 0;
        return localDateTime.getYear();
    }
    public int getMonth() {
        if (!build) return 0;
        return localDateTime.getMonthValue();
    }
    public int getDay() {
        if (!build) return 0;
        return localDateTime.getDayOfMonth();
    }
    public int getHour() {
        if (!build) return 0;
        return localDateTime.getHour();
    }
    public int getMinute() {
        if (!build) return 0;
        return localDateTime.getMinute();
    }
    public int getSecond() {
        if (!build) return 0;
        return localDateTime.getSecond();
    }

    public String toDateString() {
        if (!build) return null;
        return localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
    public String toTimeString() {
        if (!build) return null;
        return localDateTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }
    public String toString(String pattern) {
        if (!build) return null;
        return localDateTime.format(DateTimeFormatter.ofPattern(pattern));
    }
    public String toString() {
        if (!build) {
            String[] times = new String[4];
            times[0] = (int) (time / 86400000) < 1 ? null : (int) (time / 86400000) + "일";
            times[1] = (int) (time / 3600000 % 24) < 1 ? null : (int) (time / 3600000 % 24) + "시";
            times[2] = (int) (time / 60000 % 60) < 1 ? null : (int) (time / 60000 % 60) + "분";
            times[3] = (int) (time / 1000 % 60) < 1 ? null : (int) (time / 1000 % 60) + "초";

            return StringUtil.connectString(times, " ");
        }
        return localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
