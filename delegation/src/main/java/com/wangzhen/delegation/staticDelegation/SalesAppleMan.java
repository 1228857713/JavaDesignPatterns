package com.wangzhen.delegation.staticDelegation;

public class SalesAppleMan implements AppleSales {
    public void saleApple(int a) {
        System.out.println("已经为你在国外购买"+a+"个苹果。");
    }
}
