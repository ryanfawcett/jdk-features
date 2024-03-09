package org.example.optional;

import org.example.lambda.Employee;
import org.junit.jupiter.api.Test;

import javax.swing.text.html.Option;
import java.util.Optional;

@SuppressWarnings("all")
class OptionalTest {

    @Test
    void of() {
        // Optional<String> opt = Optional.of("Hello World");
        // 注意：参数不能为 null
        // Optional<String> opt = Optional.of(null); // NullPointerException
    }

    @Test
    void get() {
        Optional<String> opt = Optional.of("Hello World");
        System.out.println(opt.get());
    }

    @Test
    void ofNullable() {
        Optional<String> opt = Optional.ofNullable(null);
        // String greeting = opt.get(); // NoSuchElementException: No value present
    }

    @Test
    void isPresent() {
        Optional<String> opt = Optional.of("Hello World");
        System.out.println(opt.isPresent());

        Optional<String> nullOpt = Optional.ofNullable(null);
        System.out.println(nullOpt.isPresent()); // false
    }

    @Test
    void orElse() {
        Optional<String> opt = Optional.of("Hello World");
        String greeting = opt.orElse("greeting");
        System.out.println(greeting);

        // ----
        Optional<String> nullOpt = Optional.ofNullable(null);
        String orElse = nullOpt.orElse("greeting");
        System.out.println(orElse);
    }

    @Test
    void map() {
        Optional<Employee> empOpt = Optional.of(new Employee("张三", 20, 3000, Employee.Status.FREE));
        String name = empOpt.map(Employee::getName).orElse("李四");
        System.out.println(name);
    }
}
