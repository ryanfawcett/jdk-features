package org.example.stream;

import org.example.lambda.Employee;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * Stream 的终止操作
 *
 * @author ryan fawcett
 */
@SuppressWarnings("all")
class TerminationTest {

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 23, 9999, Employee.Status.FREE),
            new Employee("李四", 36, 8888, Employee.Status.BUSY),
            new Employee("王五", 36, 8888, Employee.Status.VACATION),
            new Employee("赵六", 45, 8888, Employee.Status.BUSY),
            new Employee("田七", 32, 4444, Employee.Status.FREE)
    );

    @Test
    void allMatch() {
        boolean allMatch = employees.stream()
                .allMatch(e -> Employee.Status.FREE.equals(e.getStatus()));
        System.out.println("allMatch = " + allMatch);
    }

    @Test
    void anyMatch() {
        boolean anyMatch = employees.stream()
                .anyMatch(e -> Employee.Status.FREE.equals(e.getStatus()));
        System.out.println("anyMatch = " + anyMatch);
    }

    @Test
    void findFirst() {
        Optional<Employee> first = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .findFirst();
        System.out.println("first = " + first);
    }

    @Test
    void findAny() {
        Optional<Employee> any = employees.stream()
                .filter(e -> Employee.Status.FREE.equals(e.getStatus()))
                .findAny();
        System.out.println("any = " + any);
    }

    @Test
    void min() {
        Optional<Integer> min = employees.stream()
                .map(Employee::getAge)
                .min(Integer::compareTo);
        System.out.println("min = " + min);
    }

    @Test
    void max() {
        Optional<Employee> maxSalaryEmp = employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary));
        System.out.println("maxSalaryEmp = " + maxSalaryEmp.get());
    }
}
