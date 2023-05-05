package com.example.travelator.chapter07.testing;

import java.time.ZonedDateTime;

public class TimeUtils {
    public static ZonedDateTime zonedDateTime(String s) {
        return ZonedDateTime.parse(s);
    }
}
