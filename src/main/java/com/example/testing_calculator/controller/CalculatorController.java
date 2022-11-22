package com.example.testing_calculator.controller;

import com.example.testing_calculator.exceptoin.IllegalNumberException;
import com.example.testing_calculator.service.CalculatorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @ExceptionHandler(value = IllegalNumberException.class)
    public ResponseEntity<String> illegalNumberHandler(IllegalNumberException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }


    @GetMapping("/")
    public String hello() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping("/plus")
    public String plus(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        int result = this.calculatorService.plus(num1, num2);
        return String.format("%d + %d = %d", num1, num2, result);

    }

    @GetMapping("/minus")
    public String minus(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        int result = this.calculatorService.minus(num1, num2);
        return String.format("%d - %d = %d", num1, num2, result);
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        int result = this.calculatorService.multiply(num1, num2);
        return String.format("%d * %d = %d", num1, num2, result);
    }

    @GetMapping("/divide")
    public String divide(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        int result = this.calculatorService.divide(num1, num2);
        return String.format("%d / %d = %d", num1, num2, result);

    }
}

