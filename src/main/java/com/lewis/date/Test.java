package com.lewis.date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

/**
 * @author: draem0507
 * @date: 2019-01-03 15:33
 * @desc: 时间处理类
 * @refer http://www.runoob.com/java/java8-datetime-api.html
 * <p>在旧版的 Java 中，日期时间 API 存在诸多问题，其中有：
 * 非线程安全 − java.util.Date 是非线程安全的，所有的日期类都是可变的，这是Java日期类最大的问题之一。
 * 设计很差 − Java的日期/时间类的定义并不一致，在java.util和java.sql的包中都有日期类，此外用于格式化和解析的类在java.text包中定义。java.util.Date同时包含日期和时间，而java.sql.Date仅包含日期，将其纳入java.sql包并不合理。另外这两个类都有相同的名字，这本身就是一个非常糟糕的设计。
 * 时区处理麻烦 − 日期类并不提供国际化，没有时区支持，因此Java引入了java.util.Calendar和java.util.TimeZone类，但他们同样存在上述所有的问题。
 * Java 8 在 java.time 包下提供了很多新的 API。以下为两个比较重要的 API：
 * Local(本地) − 简化了日期时间的处理，没有时区的问题。
 * Zoned(时区) − 通过制定的时区处理日期时间。
 * 新的java.time包涵盖了所有处理日期，时间，日期/时间，时区，时刻（instants），过程（during）与时钟（clock）的操作。</p>
 *
 * @refer https://vimsky.com/article/3745.html
 */
public class Test {


    public static void main(String[] args) {


        LocalDateTime currentTime  = LocalDateTime.now();


        System.out.println(currentTime);//2019-01-03T15:36:59.465


      LocalDate localDate= currentTime.toLocalDate();
        System.out.println(localDate);//2019-01-03


        System.out.println(localDate.getMonth());//JANUARY
        System.out.println(localDate.getDayOfMonth());//3
        LocalDateTime localDateTime_new=  currentTime.withDayOfMonth(5).withMonth(10);
        System.out.println(localDateTime_new.getYear());
        System.out.println(localDateTime_new.getMonth());//OCTOBER

        LocalDate date3 = LocalDate.of(2019, Month.DECEMBER, 12);

        // 22 小时 15 分钟
        LocalTime date4 = LocalTime.of(22, 15,20);

        LocalTime date5 = LocalTime.parse("20:15:30");

        String str = "2019-01-08 11:30";

        DateTimeFormatter formatter= DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        TemporalAccessor temporalAccessor= formatter.parse(str);

        LocalDateTime localDateTime= LocalDateTime.parse(str, formatter);
        System.out.println(localDateTime.toString());

        localDateTime =LocalDateTime.from(temporalAccessor);
        System.out.println(localDateTime.toString());

        //如果时间字符串符合 <a href="http://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html#ISO_LOCAL_DATE_TIME">ISO-8601 format</a>,则不用手动设置format
        String strDatewithTime = "2015-08-04T10:11:30";
        LocalDateTime aLDT = LocalDateTime.parse(strDatewithTime);
        System.out.println("Date with Time: " + aLDT);

        //将LocalDateTime转换为时区ISO8601字符串

        LocalDateTime ldt = LocalDateTime.now();
        ZonedDateTime zdt = ldt.atZone(ZoneOffset.UTC); //you might use a different zone
        String iso8601 = zdt.toString();
       // 从ISO8601字符串转换回LocalDateTime

         iso8601 = "2016-02-14T18:32:04.150Z";
         zdt = ZonedDateTime.parse(iso8601);
         ldt = zdt.toLocalDateTime();
        System.out.println(ldt.toString());




    }
}
