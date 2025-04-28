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
public class CalculatorCtgTest {

    Calculator calculator;
    @BeforeEach
    public void setUp(){
        calculator = new Calculator();
    }

    @DisplayName("CoTangent test")
    @ParameterizedTest
    @ValueSource(doubles = {0,1,0.1,42.42,-5})
    public void doubleCtgTest(double param){

        double expectedValue = Math.tanh(param);
        Assertions.assertEquals(expectedValue, calculator.ctg(param));
    }

    @AfterAll
    public static void closeClass(){
        System.out.println("Calculator cotangent test finished on thread " + Thread.currentThread().getName());
    }
}
