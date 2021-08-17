package com.dms.attendance;

public class AttendancePercentage {
    private static final int MINDAYS = 0;
    private static final int PERCENT = 100;

    public int calculatePercentage(int daysPresent,int totalDays) {
        if(totalDays == MINDAYS) {
            return -1;
        }
        else {
            int percentage = (daysPresent * PERCENT )/totalDays;
            return percentage;
        }
    }
}