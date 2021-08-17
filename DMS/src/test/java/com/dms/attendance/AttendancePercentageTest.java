package com.dms.attendance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AttendancePercentageTest {
    @Test
    public void calculatePercentageTest() {
        AttendancePercentage attendancePercentage = new AttendancePercentage();
        assertEquals(50, attendancePercentage.calculatePercentage(50, 100));
    }
}