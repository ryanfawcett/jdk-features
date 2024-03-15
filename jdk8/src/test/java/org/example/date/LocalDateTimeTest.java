package org.example.date;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneOffset;

@SuppressWarnings("all")
class LocalDateTimeTest {

    @Test
    void localDateTime() {
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        LocalDateTime ldt2 = LocalDateTime.of(2024, 3, 13, 21, 20, 30);
        System.out.println(ldt2);

        LocalDateTime ldt3 = ldt.plusYears(2);
        System.out.println(ldt3);

        System.out.println(ldt.getYear());
        System.out.println(ldt.getMonth());
        System.out.println(ldt.getDayOfMonth());
        System.out.println(ldt.getHour());
        System.out.println(ldt.getMinute());
        System.out.println(ldt.getSecond());
    }

    /**
     * 时间戳
     */
    @Test
    void instant() {
        Instant now = Instant.now(); // 默认获取UTC时区
        System.out.println("now = " + now);

        OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.ofHours(8));
        System.out.println("offsetDateTime = " + offsetDateTime);

        System.out.println(now.toEpochMilli()); // 获取对应的毫秒值
    }

    /**
     * Duration - 计算两个时间之间的间隔
     * Period - 计算两个日期之间的间隔
     */
    @Test
    void duration() throws InterruptedException {
        Instant ins1 = Instant.now();
        Thread.sleep(1000);
        Instant ins2 = Instant.now();

        // 计算时间戳之间的间隔
        Duration between = Duration.between(ins1, ins2);
        System.out.println("between = " + between);
        System.out.println(between.toMillis());


        LocalDate ldt1 = LocalDate.now();
        Thread.sleep(1000);
        LocalDate ldt2 = LocalDate.now();
        Period period = Period.between(ldt1, ldt2);

        System.out.println(period.getDays());
    }
}
