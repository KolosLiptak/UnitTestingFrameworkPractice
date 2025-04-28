package org.unittesting;

import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@Execution(ExecutionMode.CONCURRENT)
public class CalculatorNegativeTest {

    Calculator calculator = new Calculator();

    @BeforeEach
    public void setUp(){
        calculator = new Calculator();
    }

    @DisplayName("Positive check test negative numbers")
    @ParameterizedTest
    @ValueSource(longs = {0,-1,-5, -320000})
    public void longNegativeTrueTest(long param){

        Assertions.assertTrue(calculator.isNegative(param));
    }

    @DisplayName("Negative check test positive numbers")
    @ParameterizedTest
    @ValueSource(longs = {1, 5,320000})
    public void longNegativeFalseTest(long param){

        Assertions.assertFalse(calculator.isNegative(param));
    }

    @AfterAll
    public static void closeClass(){
        System.out.println("Calculator number is negative test finished on thread " + Thread.currentThread().getName());
    }
}
