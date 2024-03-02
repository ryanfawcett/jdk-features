package org.example.functional.interfaces;

import org.example.lambda.Employee;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class BuiltInFuncInterfaceTest {

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 23, 9999),
            new Employee("李四", 36, 8888),
            new Employee("王五", 36, 8888),
            new Employee("赵六", 45, 8888),
            new Employee("田七", 32, 4444)
    );

    BuiltInFuncInterface builtInFuncInterface = new BuiltInFuncInterface();

    @Test
    void greeting() {
        builtInFuncInterface.greeting("Ryan", s -> System.out.println("My name is " + s));
    }

    @Test
    void getNumberList() {
        List<Integer> numbers = builtInFuncInterface.getNumberList(10, () -> (int) (Math.random() * 100));
        numbers.forEach(System.out::println);
    }

    @Test
    void strHandler() {
        // 需求：将传入的字符串全部转换为大写
        String string = builtInFuncInterface.strHandler("absdG", String::toUpperCase);
        System.out.println("string = " + string);

        // 需求：去除首位空格
        String greeting = "  My name is ryan fawcett";
        System.out.println("处理前：" + greeting);

        greeting = builtInFuncInterface.strHandler(greeting, String::trim);
        System.out.println("处理后：" + greeting);
    }

    @Test
    void filter() {
        // 需求：获取当前公司中年龄大于35岁的员工信息
        List<Employee> emps = builtInFuncInterface.filter(employees, employee -> employee.getAge() >= 35);
        emps.forEach(System.out::println);
    }

}