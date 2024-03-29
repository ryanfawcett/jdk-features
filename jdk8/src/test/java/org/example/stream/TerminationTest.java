package org.example.stream;

import org.example.lambda.Employee;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Test
    void reduce() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        Integer i = list.stream()
                .reduce(0, (x, y) -> x + y);
        System.out.println("i = " + i);
    }

    @Test
    void reduceNoIdentity() {
        Optional<Double> sum = employees.stream()
                .map(Employee::getSalary)
                .reduce(Double::sum);
        System.out.println("sum = " + sum);
    }

    @Test
    void collect() {
        List<String> names = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println("names = " + names);
    }

    // 需求：以员工状态对员工进行分组
    @Test
    void groupBy() {
        Map<Employee.Status, List<Employee>> groupByStatus = employees.stream()
                .collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println("groupByStatus = " + groupByStatus);
    }

    // 需求：先以员工状态进行非组，再以年龄进行分组
    // 小于35岁的为青年
    // 大于等于35岁，并且小于45岁的为中年
    // 大于45岁的为老年
    @Test
    void groupByMulti() {
        Map<Employee.Status, Map<String, List<Employee>>> multiGroupBy = employees.stream()
                .collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy(e -> {
                            Employee emp = (Employee) e;
                            if (emp.getAge() < 35) {
                                return "青年";
                            } else if (emp.getAge() >= 35 && emp.getAge() < 45) {
                                return "中年";
                            } else {
                                return "老年";
                            }
                        }))
                );
        System.out.println("multiGroupBy = " + multiGroupBy);
    }
}
