package com.example.springcalculator.component;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DollarCalculator implements ICalculator{

    private int price = 0;
    private final MarketApi marketServer;

    public void init(){
        this.price = marketServer.price();
    }

    @Override
    public int sum(int x, int y) {
        x *= price;
        y *= price;
        return x + y ;
    }

    @Override
    public int minus(int x, int y) {
        x *= price;
        y *= price;
        return x - y;
    }

    @Override
    public int multiply(int x, int y) {
        x *= price;
        y *= price;
        return x * y;
    }

    @Override
    public int division(int x, int y) {
        x *= price;
        y *= price;
        return x / y;
    }
}
