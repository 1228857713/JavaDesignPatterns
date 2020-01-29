package com.wangzhen.delegation.staticDelegation;

public class SalesOrangeMan implements OrangeSales {
    public void salesOrange(int a) {
        System.out.println("已经为你采购"+a+"吨橘子");
    }
}
