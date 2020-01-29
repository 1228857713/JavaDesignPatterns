package com.wangzhen.delegation.dynamicDelegation.jdk;

public class WebsiteImpl implements Website {
    public void logIn(String name) {
        System.out.println(name+"登录了网站！");
    }

    public void logOut(String name) {
        System.out.println(name+"登出了网站！");
    }
}
