package com.example.testing_calculator;

import com.example.testing_calculator.exceptoin.IllegalNumberException;
import com.example.testing_calculator.service.CalculatorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class CalculatorServiceTests {

    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    public void plusTest1() {
        int num1 = 10;
        int num2 = 25;
        int result = 35;
        Assertions.assertEquals(result, calculatorService.plus(num1, num2));


    }

    @ParameterizedTest
    @MethodSource("plusTestSuites")
    public void plusTest(int num1, int num2, int result) {

        Assertions.assertEquals(result, calculatorService.plus(num1, num2));
    }

    @ParameterizedTest
    @MethodSource("minusTestSuites")
    public void minusTest(int num1, int num2, int result) {
        Assertions.assertEquals(result, calculatorService.minus(num1, num2));
    }

    @ParameterizedTest
    @MethodSource("divideTestSuites")
    public void divideTest(int num1,int num2 , int result){
        Assertions.assertEquals(result, calculatorService.divide(num1,num2));
    }

    @ParameterizedTest
    @MethodSource("multiplyTestSuites")
    public void multiplyTest(int num1, int num2, int result){
        Assertions.assertEquals(result, calculatorService.multiply(num1,num2));
    }

    @Test
    public void divideErrorThrowsExceprion(){
        Assertions.assertThrows(IllegalNumberException.class,() ->{
            calculatorService.divide(5,0);
        });
    }

    public static List<Arguments> plusTestSuites() {
        return List.of(
                Arguments.of(10, 25, 35),
                Arguments.of(25, 20, 45),
                Arguments.of(0, 0, 0)

        );
    }

    public static List<Arguments> minusTestSuites() {
        return List.of(
                Arguments.of(30, 25, 5),
                Arguments.of(25, 20, 5),
                Arguments.of(0, 0, 0)

        );
    }

    public static List<Arguments> multiplyTestSuites() {
        return List.of(
                Arguments.of(1, 2, 2),
                Arguments.of(5, 2, 10),
                Arguments.of(0, 0, 0)

        );
    }

    public static List<Arguments> divideTestSuites() {
        return List.of(
                Arguments.of(20, 20, 1),
                Arguments.of(-5, 1, -5),
                Arguments.of(10, 1, 10)

        );
    }
}
