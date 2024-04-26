package edu.wgu.d387_sample_code.rest;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeZoneConversion {

    public String timeConversion() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");

        ZonedDateTime eastern = ZonedDateTime.now(ZoneId.of("America/New_York"));
        ZonedDateTime mountain = ZonedDateTime.now(ZoneId.of("America/Denver"));
        ZonedDateTime coordinatedUniversal = ZonedDateTime.now(ZoneId.of("UTC"));

        String times = formatter.format(eastern) + " Eastern Time|" +
                formatter.format(mountain) + " Mountain Time|" +
                formatter.format(coordinatedUniversal) + " UTC";

        return times;
    }
}
