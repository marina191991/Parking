import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) throws InterruptedException, ParseException {
        //установили значения количества парковочных мест,дневной тариф,ночной тариф
        Parking parking = new Parking();
        parking.setParkingSpaces(30);
        parking.setPriceDay(200);
        parking.setPriceNight(100);

        Calendar dateEntry = new GregorianCalendar(2022, Calendar.JANUARY, 25, 5, 00);
        Calendar dateExit = new GregorianCalendar(2022, Calendar.JANUARY, 25, 23, 00);
       System.out.println("Price=" + parking.count(dateEntry, dateExit));
    }
}
