package org.example.stream;

import org.example.lambda.Employee;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@SuppressWarnings("all")
class StreamTest {

    @Test
    void streamCreation() {
        // 1. 通过调用Collection的stream() 或 parallelStream()
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();

        // 2. Arrays中的静态方法
        Employee[] employees = new Employee[10];
        Stream<Employee> stream2 = Arrays.stream(employees);

        // 3. Stream的静态方法 of()
        Stream<String> stream3 = Stream.of("aa", "bb");
        // 4. 创建无限流
        Stream<Integer> iterate = Stream.iterate(0, x -> x + 1);
        iterate.limit(10).forEach(System.out::println);
        // 5. 生成
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);
    }

}
