package com.kslau.nexus.calculator;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by shen-mini-itx on 4/6/2017.
 */

public class CalculatorTest {

    @Test
    public void TestCompute() {
        String expression = "1+3*4/10+9";
        double result = new MainActivity().infix(expression);
        double expectedResult = 11.2;
        assertEquals("Compute correct", expectedResult, result);
    }
}
