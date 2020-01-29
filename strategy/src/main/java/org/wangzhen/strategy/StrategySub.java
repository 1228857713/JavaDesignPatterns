package org.wangzhen.strategy;

public class StrategySub implements Strategy {
    @Override
    public int doOperation(int a, int b) {
        return a-b;
    }
}
