package org.example.date;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

@SuppressWarnings("all")
class SimpleDateFormatTest {

    // 存在多线程安全问题
    @Test
    void threadIssue() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Callable<Date> callable = new Callable<Date>() {
            @Override
            public Date call() throws Exception {
                return sdf.parse("20240313");
            }
        };
        ExecutorService executor = Executors.newFixedThreadPool(10);
        List<Future> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            results.add(executor.submit(callable));
        }

        for (Future result : results) {
            try {
                System.out.println(result.get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
