package org.wangzhen.strategy;

public class StrategyAdd implements Strategy {
    @Override
    public int doOperation(int a, int b) {
        return a+b;
    }
}
