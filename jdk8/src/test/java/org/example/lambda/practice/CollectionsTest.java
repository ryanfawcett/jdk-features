package org.example.lambda.practice;

import org.example.lambda.Employee;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class CollectionsTest {

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 23, 9999),
            new Employee("李四", 36, 8888),
            new Employee("王五", 36, 8888),
            new Employee("赵六", 45, 8888),
            new Employee("田七", 32, 4444)
    );

    // 需求：调用Collections.sort()方法，通过自定义排序比较两个Employee，使用Lambda作为传递参数
    // 先按照年龄比较，如果年龄相同，则按照姓名比较
    @Test
    public void sortTest() {
        employees.sort((e1, e2) -> {
            if (e1.getAge() == e2.getAge()) {
                return e1.getName().compareTo(e2.getName());
            }
            return Integer.compare(e1.getAge(), e2.getAge());
        });

        System.out.println(employees);
    }

}
