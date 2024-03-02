package org.example.lambda;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("all")
public class EmployeeTest {

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 23, 9999),
            new Employee("李四", 36, 8888),
            new Employee("王五", 36, 8888),
            new Employee("赵六", 45, 8888),
            new Employee("田七", 32, 4444)
    );

    @Test
    public void filterByAgeTest() {
        List<Employee> emps = filterByAge(employees);
        for (Employee emp : emps) {
            System.out.println("emp = " + emp);
        }
    }

    @Test
    public void filterBySalaryTest() {
        List<Employee> emps = filterBySalary(employees);
        for (Employee emp : emps) {
            System.out.println("emp = " + emp);
        }
    }

    // 优化方式一：策略设计模式
    @Test
    public void filterByEmployeeAgePredicateTest() {
        List<Employee> emps = filterByPredicate(employees, new FilterByEmployeeAge());
        for (Employee emp : emps) {
            System.out.println("emp = " + emp);
        }
    }

    @Test
    public void filterByEmployeeSalaryPredicateTest() {
        List<Employee> emps = filterByPredicate(employees, new FilterByEmployeeSalary());
        for (Employee emp : emps) {
            System.out.println("emp = " + emp);
        }
    }

    // 优化方式二：匿名内部类
    @Test
    public void filterByAgeInnerClassTest() {
        List<Employee> emps = filterByPredicate(employees, new FilterPredicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge() >= 35;
            }
        });
        System.out.println(emps);
    }

    // 优化方式三：Lambda表达式
    @Test
    public void filterByAgeLambdaTest() {
        List<Employee> emps = employees.stream()
                .filter(employee -> employee.getAge() >= 35)
                .collect(Collectors.toList());
        emps.forEach(System.out::println);
    }

    // 需求：获取当前公司中所有员工的名字
    @Test
    public void getEmployeeNamesTest() {
        List<String> names = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        names.forEach(System.out::println);
    }

    // 需求：获取当前公司中员工年龄大于35岁的员工信息
    public List<Employee> filterByAge(List<Employee> originalEmps) {
        List<Employee> emps = new ArrayList<>();
        for (Employee emp : originalEmps) {
            if (emp.getAge() >= 35) {
                emps.add(emp);
            }
        }
        return emps;
    }

    // 需求：获取当前公司中员工工资大于5000的员工信息
    public List<Employee> filterBySalary(List<Employee> originalEmps) {
        List<Employee> emps = new ArrayList<>();
        for (Employee emp : originalEmps) {
            if (emp.getSalary() >= 5000) {
                emps.add(emp);
            }
        }
        return emps;
    }

    public List<Employee> filterByPredicate(List<Employee> originalEmps, FilterPredicate predicate) {
        List<Employee> emps = new ArrayList<>();
        for (Employee emp : originalEmps) {
            if (predicate.test(emp)) {
                emps.add(emp);
            }
        }
        return emps;
    }

}
