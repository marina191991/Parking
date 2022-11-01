import java.util.Calendar;

public class CarAbstract {

    private Integer size;
    private Calendar calendarEntry;
    private Calendar calendarExit;

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

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
