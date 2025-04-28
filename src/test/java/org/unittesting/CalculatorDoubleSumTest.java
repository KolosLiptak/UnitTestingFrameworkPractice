package org.unittesting;


import org.junit.jupiter.api.*;
import com.epam.tat.module4.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


@Execution(ExecutionMode.CONCURRENT)
public class CalculatorDoubleSumTest {

    Calculator calculator;
    @BeforeEach
    public void setUp(){
        calculator = new Calculator();
    }

    @DisplayName("Adding two doubles test")
    @ParameterizedTest
    @ValueSource(doubles = {0,1,0.1,42.42,-5})
    public void doubleSumTest(double param){

        double expectedValue = 1.01 + param;
        Assertions.assertEquals(expectedValue, calculator.sum(1.01, param));
    }

    @AfterAll
    public static void closeClass(){
        System.out.println("Calculator double sum test finished on thread " + Thread.currentThread().getName());
    }
}
