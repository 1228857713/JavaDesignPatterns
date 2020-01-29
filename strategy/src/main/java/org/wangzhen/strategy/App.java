package org.wangzhen.strategy;

public class App {
    public static void main(String[] args) {
        // 加法
        Context context = new Context(new StrategyAdd());
        System.out.println(context.executeStrategyOperation(5,4));
        // 减法
        context = new Context(new StrategySub());
        System.out.println(context.executeStrategyOperation(5,4));
        // 乘法
        context = new Context(new StrategyMultiply());
        System.out.println(context.executeStrategyOperation(5,4));
    }
}
