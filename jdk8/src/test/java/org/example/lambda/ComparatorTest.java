package org.example.lambda;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.TreeSet;

@SuppressWarnings("all")
public class ComparatorTest {
    // 1.匿名内部类
    @Test
    public void comparatorTest() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        TreeSet<Integer> treeSet = new TreeSet<>(comparator);
    }
    // 2.lambda表达式
    @Test
    public void comparatorLambdaTest() {
        // Comparator<Integer> comparator = (o1, o2) -> Integer.compare(o1, o2);
        Comparator<Integer> comparator = Integer::compare;
        TreeSet<Integer> treeSet = new TreeSet<>(comparator);
    }

}
