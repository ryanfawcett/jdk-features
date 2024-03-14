package org.example.date;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

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
    }
}
