package com.example.springcalculator.component;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Calculator {

    private final ICalculator iCalculator;


    public int sum(int x, int y) {
        return iCalculator.sum(x, y);
    }

    public int minus(int x, int y) {
        return iCalculator.minus(x, y);
    }

    public int multiply(int x, int y) {
        return iCalculator.multiply(x, y);
    }

    public int division(int x, int y) {
        return iCalculator.division(x, y);
    }
}