package app.worktime.infrastructure.util;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class DateUtil {
    private static final String DATE_PATTERN         = "dd/MM/yyyy";
    private static final String TIME_PATTERN         = "HH:mm:ss";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);

    public static String format(final LocalDate date){
        return date == null ? null : FORMATTER.format(date);
    }

    public static LocalDate parse(final String value){
        try {
            return FORMATTER.parse(value, LocalDate::from);
        }
        catch (DateTimeParseException ex){
            return null;
        }
    }

    public static LocalDate toLocalDate(final Date date) {
        return LocalDate.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    public static boolean validDate(final String value){
        return parse(value) != null;
    }
}