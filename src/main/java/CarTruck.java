import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class CarTruck extends CarAbstract{
    //Занимает два парк места
    private final Integer size=2;
    private Calendar calendarEntry;
    private Calendar calendarExit;
    private Map<Integer,CarTruck> carTruckMap;

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
