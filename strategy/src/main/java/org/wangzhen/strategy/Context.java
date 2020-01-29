package org.wangzhen.strategy;

public class Context {
    public Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategyOperation(int a,int b){
        return strategy.doOperation(a,b);
    }
}
