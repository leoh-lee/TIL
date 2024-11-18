package com.example.tdd_byexample.dollar;

public interface Expression {
    Expression plus(Expression addend);

    Expression times(int multiplier);

    Money reduce(Bank bank, String to);
}
