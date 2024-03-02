package org.example.lambda.practice;

public class CalculatorImpl {

    public Long calc(Long l1, Long l2, Calculator<Long, Long> calculator) {
        return calculator.calc(l1, l2);
    }

}
