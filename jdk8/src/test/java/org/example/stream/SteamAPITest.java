package org.example.stream;

import org.example.lambda.Employee;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@SuppressWarnings("all")
class SteamAPITest {

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 23, 9999),
            new Employee("李四", 36, 8888),
            new Employee("王五", 36, 8888),
            new Employee("赵六", 45, 8888),
            new Employee("田七", 32, 4444)
    );

    @Test
    void filter() {
        // 中间操作
        // 多个中间操作可以连起来形成一个流水线，除非流水线上触发终止操作
        // 否则中间操作不会执行任何的处理，而在终止操作时一次性全部处理，称为 ‘惰性求值’
        Stream<Employee> stream = employees.stream()
                .filter(e -> {
                    System.out.println("过滤中...");
                    return e.getAge() >= 35;
                });
        // 终止操作
        stream.forEach(System.out::println);
    }

    @Test
    void limit() {
        employees.stream()
                .filter(e -> e.getSalary() > 5000)
                .limit(2) // 截断流，使其元素不超过给定数量
                .forEach(System.out::println);
    }

    @Test
    void map() {
        Arrays.asList("aa", "bb", "cc")
                .stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    @Test
    void map2() {
        employees.stream()
                .map(Employee::getName)
                .forEach(System.out::println);
    }

    @Test
    void sort() {
        Arrays.asList("aa", "cc", "bb")
                .stream()
                .sorted()
                .forEach(System.out::println);

        // -------------------

        employees.stream()
                .sorted((e1, e2) -> {
                    if (e1.getAge() == e2.getAge()) {
                        return e1.getName().compareTo(e2.getName());
                    }
                    return Integer.compare(e1.getAge(), e2.getAge());
                })
                .forEach(System.out::println);
    }
}
