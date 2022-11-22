package com.example.testing_calculator.service;

import com.example.testing_calculator.exceptoin.IllegalNumberException;
import org.springframework.stereotype.Controller;

@Controller
public class CalculatorService {


    public int plus(int num1, int num2) {
        return num1+num2;
    }

    public int minus(int num1, int num2) {
        return num1-num2;
    }

    public int multiply(int num1, int num2) {
        return num1*num2;
    }

    public int divide(int num1, int num2) {
       if (num2 == 0){
           throw new IllegalNumberException("НЕ ДЕЛИТСЯ НА НОЛЬ");
       }
       return num1 / num2;
    }
}
