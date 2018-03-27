package com.nowakowski.screeningparser.converter;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;

import static com.nowakowski.screeningparser.util.Constants.DAY;
import static com.nowakowski.screeningparser.util.Constants.HOUR;
import static com.nowakowski.screeningparser.util.Constants.MINUTE;
import static com.nowakowski.screeningparser.util.Constants.MINUTES;
import static com.nowakowski.screeningparser.util.Constants.MONTH;
import static com.nowakowski.screeningparser.util.Constants.SINGLE_HOUR;
import static com.nowakowski.screeningparser.util.Constants.YEAR;

public class LocalDateTimeConverter {

    private LocalDateTimeConverter() {
    }

    public static LocalDateTime from(String date, String time) {
        String[] splitDate = date.split("-");
        String[] splitTime = time.split(":");
        int[] dateParts = Arrays.stream(splitDate).mapToInt(Integer::parseInt).toArray();
        int[] timeParts = Arrays.stream(splitTime).mapToInt(Integer::parseInt).toArray();
        return LocalDateTime.of(dateParts[YEAR], dateParts[MONTH], dateParts[DAY], timeParts[HOUR], timeParts[MINUTE]);
    }

    public static LocalTime from(String description) {
        String[] descriptionParts = description.split(" min");
        int durationInMinutes = Integer.parseInt(descriptionParts[MINUTES]);
        int hours = durationInMinutes / SINGLE_HOUR;
        int minutes = durationInMinutes % SINGLE_HOUR;
        return LocalTime.of(hours, minutes);
    }
}
