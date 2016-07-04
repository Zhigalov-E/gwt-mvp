package com.myorg.gwt.client.utils;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.junit.client.GWTTestCase;
import org.junit.Test;
import java.util.Date;


public class TimeMessagerTest extends GWTTestCase {

    @Test
    public  void testGoodMorning() {
        checkMessageForLocale("06:00:00.000", "Доброе утро");
    }

    @Test
    public  void testGoodDay() {
        checkMessageForLocale("09:00:00.000", "Добрый день");
    }

    @Test
    public  void testGoodEvening() {
        checkMessageForLocale("19:00:00.000", "Добрый вечер");
    }

    @Test
    public  void testGoodNight() {
        checkMessageForLocale("23:00:00.000", "Доброй ночи");
    }

    private void checkMessageForLocale(String time, String expectedMessage) {
        Date date = DateTimeFormat.getFormat("HH:mm:ss.S").parse(time);
        assertEquals(TimeMessager.getInstance().getMessageResouse(date), expectedMessage);
    }

    public String getModuleName() {
        return "com.myorg.gwt.MvpInAction";
    }
}
