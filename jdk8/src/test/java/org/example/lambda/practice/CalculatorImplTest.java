package org.example.lambda.practice;

import org.junit.jupiter.api.Test;

class CalculatorImplTest {

    CalculatorImpl calculator = new CalculatorImpl();

    @Test
    void calc() {
        Long sum = calculator.calc(100L, 200L, Long::sum);
        System.out.println("100 + 200 = " + sum);

        System.out.println("----------------------------------");

        Long result = calculator.calc(100L, 200L, (l1, l2) -> l1 * l2);
        System.out.println("100 * 200 = " + result);
    }
}