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
public class CalculatorLongSubTest {

    Calculator calculator;

    @BeforeEach
    public void setUp(){
        calculator = new Calculator();
    }

    @DisplayName("Subtracting two longs test")
    @ParameterizedTest
    @ValueSource(longs = {0,1,-5,320000})
    public void longSubTest(long param){

        long expectedValue = 100 - param;
        Assertions.assertEquals(expectedValue, calculator.sub(100, param));
    }


    @AfterAll
    public static void closeClass(){
        System.out.println("Calculator long subtraction test finished on thread " + Thread.currentThread().getName());
    }
}
