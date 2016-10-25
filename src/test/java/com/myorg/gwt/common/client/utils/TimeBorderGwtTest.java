package com.myorg.gwt.common.client.utils;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.junit.client.GWTTestCase;
import org.junit.Test;

import java.util.Date;


public class TimeBorderGwtTest extends GWTTestCase {

    @Test
    public void testGetMorningBorder() {
        checkTimePeriod("06:00:00.000", TimeBorder.Border.MORNING);
    }

    @Test
    public void testGetMorningBorder2() {
        checkTimePeriod("08:59:59.999", TimeBorder.Border.MORNING);
    }

    @Test
    public void testGetDayBorder() {
        checkTimePeriod("09:00:00.000", TimeBorder.Border.DAY);
    }

    @Test
    public void testGetNotDayBorder() {
        checkTimePeriod("18:59:59.999", TimeBorder.Border.DAY);
    }

    @Test
    public void testGetEveningBorder() {
        checkTimePeriod("19:00:00.000", TimeBorder.Border.EVENING);
    }

    @Test
    public void testGetEveningBorder2() {
        checkTimePeriod("22:59:59.999", TimeBorder.Border.EVENING);
    }

    @Test
    public void testGetNightBorder() {
        checkTimePeriod("23:00:00.000", TimeBorder.Border.NIGHT);
    }

    @Test
    public void testGetNightBorder2() {
        checkTimePeriod("05:59:59.999", TimeBorder.Border.NIGHT);
    }

    private static void checkTimePeriod(String time, TimeBorder.Border timeBorderExpected) {
        Date date = DateTimeFormat.getFormat("HH:mm:ss.S").parse(time);
        TimeBorder.Border timeBorder = TimeBorder.getBorder(date);
        assertEquals(timeBorder, timeBorderExpected);
    }

    public String getModuleName() {
        return "com.myorg.gwt.common.Common";
    }
}
