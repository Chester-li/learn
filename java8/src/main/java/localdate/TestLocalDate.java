package localdate;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TestLocalDate {

    @Test
    public void testLocalDate() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDate localeDate = LocalDate.now();
        System.out.println(localeDate.toString());

        localeDate.plusMonths(1);
        System.out.println(localeDate.toString());

        localeDate = LocalDate.of(2015, 1, 1);
        System.out.println(localeDate.toString());

        LocalTime localTime = LocalTime.now();
        System.out.println(localTime.toString());

        //localTime变量的值不变
        localTime.plusHours(10);
        localTime.minusMinutes(100);
        System.out.println(localTime.toString());

        System.out.println(localTime.plusHours(10));

        ZonedDateTime zonedDateTime =  ZonedDateTime.now();
        System.out.println(zonedDateTime.toString());

        zonedDateTime = ZonedDateTime.of(
          LocalDate.of(2015 , 1,1),
          LocalTime.of(0, 0),
          ZoneId.of("Europe/Berlin")
        );
        System.out.println(zonedDateTime);

        //格式化输出ZoneDateTime
        System.out.println(dateTimeFormatter.format(zonedDateTime));

    }

}
