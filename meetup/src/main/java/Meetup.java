import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class Meetup {
    private final LocalDate firstDayOfMonth;
    private final LocalDate thirteenthDayOfMonth;

    public Meetup(int month, int year) {
        firstDayOfMonth = LocalDate.of(year, month, 1);
        thirteenthDayOfMonth = LocalDate.of(year, month, 13);
    }

    public LocalDate day(DayOfWeek day, MeetupSchedule schedule) {
        switch (schedule) {
            case TEENTH:
                return thirteenthDayOfMonth.with(TemporalAdjusters.nextOrSame(day));
            case LAST:
                return firstDayOfMonth.with(TemporalAdjusters.dayOfWeekInMonth(-1, day));
            default:
                return firstDayOfMonth.with(TemporalAdjusters.dayOfWeekInMonth(schedule.ordinal() + 1, day));
        }
    }
}