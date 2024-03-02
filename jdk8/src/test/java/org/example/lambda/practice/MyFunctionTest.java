package org.example.lambda.practice;

import org.junit.jupiter.api.Test;

public class MyFunctionTest {

    @Test
    public void convert2UppercaseTest() {
        String uppercase = stringHandler("abcdef", String::toUpperCase);
        System.out.println("uppercase = " + uppercase);
    }

    public String stringHandler(String string, MyFunction myFunction) {
        return myFunction.getValue(string);
    }

}
