import java.util.Calendar;

import java.util.Map;

public class CarPassenger extends CarAbstract {
    //Занимает одно парк места
    private final Integer size = 1;
    private Calendar calendarEntry;
    private Calendar calendarExit;
    private Map<Integer,CarPassenger> carPassengerMap;

    @Override
    public Integer getSize() {
        return size;
    }

    public Calendar getCalendarEntry() {
        return calendarEntry;
    }

    public void setCalendarEntry(Calendar calendarEntry) {
        this.calendarEntry = calendarEntry;
    }

    public Calendar getCalendarExit() {
        return calendarExit;
    }

    public void setCalendarExit(Calendar calendarExit) {
        this.calendarExit = calendarExit;
    }

}
