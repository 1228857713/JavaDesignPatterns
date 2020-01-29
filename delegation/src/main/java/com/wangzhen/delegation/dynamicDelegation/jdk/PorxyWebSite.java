package com.wangzhen.delegation.dynamicDelegation.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class PorxyWebSite implements InvocationHandler {

    public static int count = 0;
    public Object target ;
    public <T> T getProxyInstance(Object target){
        this.target = target;
        //ClassLoader classLoader = target.getClass().getClassLoader();
        Class<?> [] interfaces = target.getClass().getInterfaces();
        return (T)Proxy.newProxyInstance(this.getClass().getClassLoader(),interfaces,this);

    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object r;
        // 执行实际处理的方法
        r = method.invoke(target,args);
        if(method.getName().equalsIgnoreCase("logIn")){
            count++;
        }
        if(method.getName().equalsIgnoreCase("logOut")){
            count--;
        }
        printCount();
        return  r;
    }

    public void printCount(){
        System.out.println("现在网站上有"+count+"个人");
    }
}
