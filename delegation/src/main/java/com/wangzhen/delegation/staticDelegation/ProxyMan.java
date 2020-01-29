package com.wangzhen.delegation.staticDelegation;

public class ProxyMan implements AppleSales ,OrangeSales{
    SalesAppleMan salesAppleMan;
    SalesOrangeMan salesOrangeMan;

    public void saleApple(int a) {
        salesAppleMan = new SalesAppleMan();
        survey();
        salesAppleMan.saleApple(a);
        delivery();
    }

    public void salesOrange(int a) {
        salesOrangeMan = new SalesOrangeMan();
        survey();
        salesOrangeMan.salesOrange(a);
        delivery();
    }

    // 在市场上需求调研
    public void survey(){
        System.out.println("收到你的市场需求开始调研");
    }
    // 一条龙服务，为你寄货
    public void delivery(){
        System.out.println("商品已经采购好了，为你寄货");
    }


}
