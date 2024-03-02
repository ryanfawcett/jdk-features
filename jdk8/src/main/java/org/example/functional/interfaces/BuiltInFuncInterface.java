package org.example.functional.interfaces;

import org.example.lambda.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 内置函数接口
 *
 * @author ryan fawcett
 */
public class BuiltInFuncInterface {

    // 1. 消费型接口
    public void greeting(String name, Consumer<String> consumer) {
        consumer.accept(name);
    }

    // 2. 供给型接口

    /**
     * 获取整数集合
     *
     * @param count    集合中整数的个数
     * @param supplier 如何生成整数
     * @return 整数集合
     */
    public List<Integer> getNumberList(int count, Supplier<Integer> supplier) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(supplier.get());
        }
        return list;
    }

    // 3. 函数型接口

    public String strHandler(String s, Function<String, String> func) {
        return func.apply(s);
    }

    // 4. 断言型接口
    public List<Employee> filter(List<Employee> employees, Predicate<Employee> predicate) {
        List<Employee> emps = new ArrayList<>();
        employees.forEach(employee -> {
            if (predicate.test(employee)) {
                emps.add(employee);
            }
        });
        return emps;
    }

}
