package com.wangzhen.delegation.dynamicDelegation.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class App {


    public static void main(String[] args) {
        Website website = new WebsiteImpl();
        PorxyWebSite proxy = new PorxyWebSite();
        Website websiteProxy = proxy.getProxyInstance(website);

        websiteProxy.logIn("王震");

        websiteProxy.logIn("姜珊");

        websiteProxy.logIn("billGaets");

        websiteProxy.logOut("王震");

    }
}
