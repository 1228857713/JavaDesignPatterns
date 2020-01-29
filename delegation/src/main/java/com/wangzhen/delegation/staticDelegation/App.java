package com.wangzhen.delegation.staticDelegation;

public class App {
    public static void main(String[] args) {
        ProxyMan proxyMan = new ProxyMan();
        proxyMan.saleApple(10);
        proxyMan.salesOrange(5);
    }
}
