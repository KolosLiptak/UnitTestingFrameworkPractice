package org.unittesting;

import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.Assume.assumeTrue;

@Execution(ExecutionMode.CONCURRENT)
public class CalculatorLongDivTest {

    Calculator calculator;

    @BeforeEach
    public void setUp(){
        calculator = new Calculator();
    }

    @DisplayName("Dividing two non zero longs test")
    @ParameterizedTest
    @ValueSource(longs = {0,1,-5,320000})
    public void longDivTestNonZero(long param){

        Assumptions.assumeTrue(param != 0);
        long expectedValue = 1000 / param;
        Assertions.assertEquals(expectedValue, calculator.div(1000, param));
    }

    @Test
    @DisplayName("Dividing by zero longs test")
    public void longDivTestWithZero(){

        Assertions.assertThrows(NumberFormatException.class, () -> calculator.div(1000, 0));
    }


    @AfterAll
    public static void closeClass(){
        System.out.println("Calculator long division test finished on thread " + Thread.currentThread().getName());
    }
}
