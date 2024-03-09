package org.example.stream;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("all")
class StreamPracticeTetst {

    Trader raoul = new Trader("Raoul", "Cambridge");
    Trader mario = new Trader("Mario", "Milan");
    Trader alan = new Trader("Alan", "Cambridge");
    Trader brian = new Trader("Brian", "Cambridge");

    List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 399),
            new Transaction(mario, 2012, 399),
            new Transaction(raoul, 2012, 1000),
            new Transaction(alan, 2012, 999),
            new Transaction(brian, 2011, 599)
    );

    /**
     * 需求：给定一个数字列表，如何返回一个由每个数的平方构成的列表呢
     * 如：给定 [1, 2, 3, 4] - 返回 [1, 4, 9, 16]
     */
    @Test
    void test1() {
        Integer[] arr = new Integer[]{1, 2, 3, 4};
        Arrays.stream(arr)
                .map(i -> i * i)
                .forEach(System.out::println);
    }

    /**
     * 1. 找出2011年所有的交易，并按照交易金额排序(从低到高)
     */
    @Test
    void test2() {
        transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted((t1, t2) -> Integer.compare(t1.getValue(), t2.getValue()))
                .forEach(System.out::println);
    }

    /**
     * 2. 交易员都在哪些不同的城市工作
     */
    @Test
    void test3() {
        transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);
    }

    /**
     * 3. 查找所有来自Cambridge的交易员，按名字排序
     */
    @Test
    void test4() {
        transactions.stream()
                .filter(t -> "Cambridge".equals(t.getTrader().getCity()))
                .map(Transaction::getTrader)
                .sorted((t1, t2) -> t1.getName().compareTo(t2.getName()))
                .distinct()
                .forEach(System.out::println);
    }

    /**
     * 4. 返回所有交易员的姓名字符串，按字母顺序排序
     */
    @Test
    void test5() {
        transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .sorted()
                .distinct()
                .forEach(System.out::println);
    }

    /**
     * 5. 有没有交易员是在米兰工作的
     */
    @Test
    void test6() {
        boolean anyMatch = transactions.stream()
                .anyMatch(t -> "Milan".equals(t.getTrader().getCity()));
        System.out.println("有没有在米兰工作的交易员：" + anyMatch);
    }

    /**
     * 6. 打印生活在剑桥的交易员的所有交易额
     */
    @Test
    void test7() {
        Optional<Integer> sum = transactions.stream()
                .filter(t -> "Cambridge".equals(t.getTrader().getCity()))
                .map(Transaction::getValue)
                .reduce(Integer::sum);
        System.out.println("交易额总和：" + sum.get());
    }

    /**
     * 7. 所有交易中，最高的交易金额是多少
     */
    @Test
    void test8() {
        Optional<Integer> max = transactions.stream()
                .map(Transaction::getValue)
                .max(Integer::compare);
        System.out.println("最高交易金额为：" + max.get());
    }
}
