import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Parking {
    private int parkingSpaces;//общее количество и пойдет на уменьшение при занятии мест
    private int priceDay; //9.00-21.00
    private int priceNight;//21.00-9.00
    private Integer price;


    public int entryCar(CarAbstract car, Calendar begin) {
        //begin
        if (parkingSpaces != 0) {
            parkingSpaces = parkingSpaces - car.getSize();
            car.setCalendarEntry(begin);
        } else System.out.println("No place");
        return parkingSpaces;
    }

    public Integer exitCar(CarAbstract car, Calendar end) {
        car.setCalendarExit(end);
        Integer i = count(car.getCalendarEntry(), end);
        return i;
    }

    public Integer count(Calendar begin, Calendar end) {
        int y = 0;
        int x = 0;
        //проверка одинаковые ли даты

        DateFormat dateFormat1 = new SimpleDateFormat("HH.mm");

        int day = begin.get(Calendar.DAY_OF_MONTH);
        int hour = begin.get(Calendar.HOUR_OF_DAY);
        Date beginD = begin.getTime();
        String str = dateFormat1.format(beginD);
        Double doubleBegin = Double.parseDouble(str);
        Date endD = end.getTime();
        String str1 = dateFormat1.format(endD);
        Double doubleEnd = Double.parseDouble(str1);
       int day1 = end.get(Calendar.DAY_OF_MONTH);
        int hour1 = end.get(Calendar.HOUR_OF_DAY);
        if (day == day1) {
            //днем заезд, днем выезд
            if ((hour >= 9) && (hour < 21) && (hour1 >= 9) && (hour1 < 21)) {
                double d = doubleEnd - doubleBegin;
                y = checkRem(d);
                price = priceDay * y;
            }
//въезд днем,выезд 00-8.59
            if ((hour >= 9) && (hour < 21) && (hour1 >= 0) && (hour1 < 9)) {
                double d = 20.59 - doubleBegin;
                //System.out.println("d=" + d);
                double n = 8.59 - doubleEnd + 3.00;
               // System.out.println("n=" + n);
                //взять остаток у d
                y = checkRem(d);
                int priceD = priceDay * y;
                //взять остаток у n
                x = checkRem(n);
                int priceN = priceNight * x;
                price = priceD + priceN;
            }

            //въезд днем , выезд 21.00-23.59
            if ((hour >= 9) && (hour < 21) && (hour1 >= 21) && (hour1 <= 23)) {
                double d = 20.59 - doubleBegin;

                double n = 23.59 - doubleEnd;
                   //взять остаток у d
                y = checkRem(d);
                            int priceD = priceDay * y;
                //взять остаток у n
                x = checkRem(n);
                int priceN = priceNight * x;
                price = priceD + priceN;
                            }
//въезд 00-8.59 ,выезд днем
            if ((hour >= 0) && (hour < 9) && (hour1 >= 9) && (hour1 < 21)) {
                double d = doubleEnd - 9.00;
                //System.out.println("d=" + d);
                double n = 8.59 - doubleBegin;
                //System.out.println("n=" + n);
                //взять остаток у d
                y = checkRem(d);
                               int priceD = priceDay * y;
                //взять остаток у n
                x = checkRem(n);
                               int priceN = priceNight * x;
                price = priceD + priceN;

            }
//въезд 21.00-23.59,выезд днем
            if (((hour >= 21) && (hour <= 23)) && ((hour1 >= 9) && (hour1 < 21))) {
                double d = doubleEnd - 9.00;
                double n = 23.59 - doubleBegin + 9.00;
                               y = checkRem(d);
                //взять остаток у d
                               int priceD = priceDay * y;
                //взять остаток у n
                x = checkRem(n);
                             int priceN = priceNight * x;
                price = priceD + priceN;
            }
            //въезд и выезд в период ночного тарифа 00-8.59
            if (((hour >= 0) && (hour < 9)) && ((hour1 >= 0) && (hour1 < 9))) {
                double d = doubleEnd - doubleBegin;
                                //взять остаток у d
               y= checkRem(d);

                price = priceNight * y;
            }
            //въезд и выезд в период ночного тарифа 21-23,59
            if (((hour >= 21) && (hour <= 23)) && ((hour1 >= 21) && (hour1 <= 23))) {
                double d = doubleEnd - doubleBegin;
                //взять остаток у d
                y = checkRem(d);
                               price = priceNight * y;
                            }
            //въезд в период ночного тарифа 00-8.59 и выезд в период ночного тарифа 21-23.59
            if (((hour >= 0) && (hour < 9)) && ((hour1 >= 21) && (hour1 <= 23))) {
                double d = 8.59 - doubleBegin;
                double n = 23.59 - doubleEnd;
                //взять остаток у d
                y = checkRem(d);
                       //взять остаток у n
                x = checkRem(n);
                             int priceN = priceNight * (x + y);
                int pricePlus12HDay = priceDay * 12;
                price = priceN + pricePlus12HDay;
            }
        }
        return price;
    }

    //Проверка на остаток и округление в бОльшую сторону количества часов в случае наличия остатка (минут)
    public Integer checkRem(double d) {
        int count;
        if ((d % 1) != 0) {
            count = (int) (d) + 1;
        } else
            count = (int) (d);
        return count;
    }


    public Integer getParkingSpaces() {
        return parkingSpaces;
    }

    public void setParkingSpaces(Integer parkingSpaces) {
        this.parkingSpaces = parkingSpaces;
    }

    public int getPriceDay() {
        return priceDay;
    }

    public void setPriceDay(int priceDay) {
        this.priceDay = priceDay;
    }

    public int getPriceNight() {
        return priceNight;
    }

    public void setPriceNight(int priceNight) {
        this.priceNight = priceNight;
    }
}
