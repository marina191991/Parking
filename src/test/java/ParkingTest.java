import org.junit.jupiter.api.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ParkingTest {
    Calendar dateEntry;
    Calendar dateExit;
   static Parking parking;
    CarTruck carTruck;
    CarPassenger carPassenger;
    @BeforeAll
            public static void set()
    {
        //установили значения количества парковочных мест,дневной тариф,ночной тариф
        parking = new Parking();
        parking.setPriceDay(200);
        parking.setPriceNight(100);
    }
    @BeforeEach
    public void setParking() {
        parking.setParkingSpaces(30);

    }

//днем заезд, днем выезд.Без остаточных минут

    @DisplayName("Entry day 9.00-20.59.Exit day.Without minute.Car truck")
    @Test
    public void dayEntryExitNminTruck() {
        dateEntry = new GregorianCalendar(2022, Calendar.JANUARY, 25, 14, 00);
        dateExit = new GregorianCalendar(2022, Calendar.JANUARY, 25, 20, 00);
        carTruck=new CarTruck();
        int parkingRem=parking.entryCar(carTruck,dateEntry);
        int price=parking.exitCar(carTruck,dateExit);
        Assertions.assertEquals(1200,price);
        Assertions.assertEquals(28,parkingRem);

    }
    @DisplayName("Entry day 9.00-20.59.Exit day.With remained minute .Car truck")
    @Test
    public void dayEntryExitYminTruck() {
        dateEntry = new GregorianCalendar(2022, Calendar.JANUARY, 25, 14, 10);
        dateExit = new GregorianCalendar(2022, Calendar.JANUARY, 25, 20, 30);
        carTruck=new CarTruck();
        int parkingRem= parking.entryCar(carTruck,dateEntry);
        int price=parking.exitCar(carTruck,dateExit);
        Assertions.assertEquals(1400,price);
        Assertions.assertEquals(28,parkingRem);
    }
    @DisplayName("Entry day 9.00-20.59.Exit day.With remained minute.Car passenger")
    @Test
    public void dayEntryExitYminPass() {
        dateEntry = new GregorianCalendar(2022, Calendar.JANUARY, 25, 14, 10);
        dateExit = new GregorianCalendar(2022, Calendar.JANUARY, 25, 20, 30);
        carPassenger=new CarPassenger();
        int parkingRem= parking.entryCar(carPassenger,dateEntry);
        int price=parking.exitCar(carPassenger,dateExit);
        Assertions.assertEquals(1400,price);
        Assertions.assertEquals(29,parkingRem);
    }
    @DisplayName("Entry day 9.00-20.59.Exit day.Without minute .Car passenger")
    @Test
    public void dayEntryExitNminPass() {
        dateEntry = new GregorianCalendar(2022, Calendar.JANUARY, 25, 14, 00);
        dateExit = new GregorianCalendar(2022, Calendar.JANUARY, 25, 20, 00);
        carPassenger=new CarPassenger();
        int parkingRem=parking.entryCar(carPassenger,dateEntry);
        int price=parking.exitCar(carPassenger,dateExit);
        Assertions.assertEquals(1200,price);
        Assertions.assertEquals(29,parkingRem);
        }

        @DisplayName("Entry day 9.00-20.59.Exit night 00.00-8.59.With remained minute")
        @Test
    public void dayNight1Ym() {
            dateEntry = new GregorianCalendar(2022, Calendar.JANUARY, 25, 14, 00);
            dateExit = new GregorianCalendar(2022, Calendar.JANUARY, 25, 7, 00);
            carPassenger=new CarPassenger();
            int parkingRem=parking.entryCar(carPassenger,dateEntry);
            int price=parking.exitCar(carPassenger,dateExit);
            Assertions.assertEquals(1900,price);
            Assertions.assertEquals(29,parkingRem);
        }
    @DisplayName("Entry day 9.00-20.59.Exit night 00.00-8.59.Without minute")
    @Test
    public void dayNight1Nm() {
        dateEntry = new GregorianCalendar(2022, Calendar.JANUARY, 25, 14, 59);
        dateExit = new GregorianCalendar(2022, Calendar.JANUARY, 25, 7, 59);
        carPassenger=new CarPassenger();
        int parkingRem=parking.entryCar(carPassenger,dateEntry);
        int price=parking.exitCar(carPassenger,dateExit);
        Assertions.assertEquals(1600,price);
        Assertions.assertEquals(29,parkingRem);
    }
    @DisplayName("Entry 9.00-20.59, Exit 21.00-23.59. With minute")
    @Test
    public void dayNight2Nm() {
        dateEntry = new GregorianCalendar(2022, Calendar.JANUARY, 25, 14, 00);
        dateExit = new GregorianCalendar(2022, Calendar.JANUARY, 25, 22, 00);
        carPassenger=new CarPassenger();
        int parkingRem=parking.entryCar(carPassenger,dateEntry);
        int price=parking.exitCar(carPassenger,dateExit);
        Assertions.assertEquals(1600,price);
        Assertions.assertEquals(29,parkingRem);
    }
    @DisplayName("Entry 9.00-20.59, Exit 21.00-23.59. Without minute")
    @Test
    public void day1Night2Ym() {
        dateEntry = new GregorianCalendar(2022, Calendar.JANUARY, 25, 14, 59);
        dateExit = new GregorianCalendar(2022, Calendar.JANUARY, 25, 22, 59);
        carPassenger=new CarPassenger();
        int parkingRem=parking.entryCar(carPassenger,dateEntry);
        int price=parking.exitCar(carPassenger,dateExit);
        Assertions.assertEquals(1300,price);
        Assertions.assertEquals(29,parkingRem);
    }
    @DisplayName("Entry night 00-8.59, Exit day. With minute")
    @Test
    public void day0Night1Ym() {
        dateEntry = new GregorianCalendar(2022, Calendar.JANUARY, 25, 3, 00);
        dateExit = new GregorianCalendar(2022, Calendar.JANUARY, 25, 15, 10);
        carPassenger=new CarPassenger();
        int parkingRem=parking.entryCar(carPassenger,dateEntry);
        int price=parking.exitCar(carPassenger,dateExit);
        Assertions.assertEquals(2000,price);
        Assertions.assertEquals(29,parkingRem);
    }

    @DisplayName("Entry night 00-8.59, Exit day. Without minute")
    @Test
    public void day0Night1Nm() {
        dateEntry = new GregorianCalendar(2022, Calendar.JANUARY, 25, 3, 59);
        dateExit = new GregorianCalendar(2022, Calendar.JANUARY, 25, 15, 00);
        carPassenger=new CarPassenger();
        int parkingRem=parking.entryCar(carPassenger,dateEntry);
        int price=parking.exitCar(carPassenger,dateExit);
        Assertions.assertEquals(1700,price);
        Assertions.assertEquals(29,parkingRem);
    }

    @DisplayName("Entry night 21.00-23.59, Exit day. With minute")
    @Test
    public void day0Night1Ymin() {
        dateEntry = new GregorianCalendar(2022, Calendar.JANUARY, 25, 22, 00);
        dateExit = new GregorianCalendar(2022, Calendar.JANUARY, 25, 15, 10);
        carPassenger=new CarPassenger();
        int parkingRem=parking.entryCar(carPassenger,dateEntry);
        int price=parking.exitCar(carPassenger,dateExit);
        Assertions.assertEquals(2500,price);
        Assertions.assertEquals(29,parkingRem);
    }
    @DisplayName("Entry night 21.00-23.59, Exit day. Without minute")
    @Test
    public void day0Night1Nmin() {
        dateEntry = new GregorianCalendar(2022, Calendar.JANUARY, 25, 22, 59);
        dateExit = new GregorianCalendar(2022, Calendar.JANUARY, 25, 15, 00);
        carPassenger=new CarPassenger();
        int parkingRem=parking.entryCar(carPassenger,dateEntry);
        int price=parking.exitCar(carPassenger,dateExit);
        Assertions.assertEquals(2200,price);
        Assertions.assertEquals(29,parkingRem);
    }

    @DisplayName("Entry and exit night 00-8.59. Without minute")
    @Test
    public void day01Nmin() {
        dateEntry = new GregorianCalendar(2022, Calendar.JANUARY, 25, 1, 59);
        dateExit = new GregorianCalendar(2022, Calendar.JANUARY, 25, 3, 59);
        carPassenger=new CarPassenger();
        int parkingRem=parking.entryCar(carPassenger,dateEntry);
        int price=parking.exitCar(carPassenger,dateExit);
        Assertions.assertEquals(200,price);
        Assertions.assertEquals(29,parkingRem);

    }
    @DisplayName("Entry and exit night 00-8.59. With minute")
    @Test
    public void day01Ymin() {
        dateEntry = new GregorianCalendar(2022, Calendar.JANUARY, 25, 1, 59);
        dateExit = new GregorianCalendar(2022, Calendar.JANUARY, 25, 3, 00);
        carPassenger=new CarPassenger();
        int parkingRem=parking.entryCar(carPassenger,dateEntry);
        int price=parking.exitCar(carPassenger,dateExit);
        Assertions.assertEquals(200,price);
        Assertions.assertEquals(29,parkingRem);
    }
    @DisplayName("Entry and exit night 21-23,59. With minute")
    @Test
    public void day01Ym() {
        dateEntry = new GregorianCalendar(2022, Calendar.JANUARY, 25, 21, 59);
        dateExit = new GregorianCalendar(2022, Calendar.JANUARY, 25, 23, 00);
        carPassenger=new CarPassenger();
        int parkingRem=parking.entryCar(carPassenger,dateEntry);
        int price=parking.exitCar(carPassenger,dateExit);
        Assertions.assertEquals(200,price);
        Assertions.assertEquals(29,parkingRem);
    }
    @DisplayName("Entry and exit night 21-23.59. Without minute")
    @Test
    public void day01Nminute() {
        dateEntry = new GregorianCalendar(2022, Calendar.JANUARY, 25, 21, 00);
        dateExit = new GregorianCalendar(2022, Calendar.JANUARY, 25, 23, 00);
        carPassenger=new CarPassenger();
        int parkingRem=parking.entryCar(carPassenger,dateEntry);
        int price=parking.exitCar(carPassenger,dateExit);
        Assertions.assertEquals(200,price);
        Assertions.assertEquals(29,parkingRem);
    }

    @DisplayName("Entry night 00-8.59 and exit night 21-23.59. Without minute")
    @Test
    public void night01Nm() {
        dateEntry = new GregorianCalendar(2022, Calendar.JANUARY, 25, 5, 59);
        dateExit = new GregorianCalendar(2022, Calendar.JANUARY, 25, 21, 59);
        carPassenger=new CarPassenger();
        int parkingRem=parking.entryCar(carPassenger,dateEntry);
        int price=parking.exitCar(carPassenger,dateExit);
        Assertions.assertEquals(2900,price);
        Assertions.assertEquals(29,parkingRem);
    }
    @DisplayName("Entry night 00-8.59 and exit night 21-23.59. With minute")
    @Test
    public void night01Ym() {
        dateEntry = new GregorianCalendar(2022, Calendar.JANUARY, 25, 5, 00);
        dateExit = new GregorianCalendar(2022, Calendar.JANUARY, 25, 21, 00);
        carPassenger=new CarPassenger();
        int parkingRem=parking.entryCar(carPassenger,dateEntry);
        int price=parking.exitCar(carPassenger,dateExit);
        Assertions.assertEquals(3100,price);
        Assertions.assertEquals(29,parkingRem);
    }
    @Test
    public void setParkingFull() {
        parking.setParkingSpaces(2);
        dateEntry = new GregorianCalendar(2022, Calendar.JANUARY, 25, 5, 00);
        carPassenger=new CarPassenger();
        parking.entryCar(carPassenger,dateEntry);
        parking.entryCar(carPassenger,dateEntry);
        parking.entryCar(carPassenger,dateEntry);
           Assertions.assertEquals("No place","No place");

    }
}
