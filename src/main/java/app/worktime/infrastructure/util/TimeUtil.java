package app.worktime.infrastructure.util;

import java.time.LocalTime;
import java.util.List;

public class TimeUtil {
    public static LocalTime calculateInterval(final LocalTime startTime, final LocalTime endTime){
        final LocalTime diff = endTime.minusHours(startTime.getHour());
        return diff.minusMinutes(startTime.getMinute());
    }

    public static LocalTime reduce(final List<LocalTime> times){
        LocalTime total = LocalTime.of(0, 0);
        total = times.stream().reduce(total, (subTotal, e) -> subTotal.plusHours(e.getHour()));
        total = times.stream().reduce(total, (subTotal, e) -> subTotal.plusMinutes(e.getMinute()));
        return total;
    }
}