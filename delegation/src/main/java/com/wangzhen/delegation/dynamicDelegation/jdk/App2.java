package com.wangzhen.delegation.dynamicDelegation.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *  1.建立一个 Website 接口定义了 登录和登出功能
 *  2.WebsiteImpl 为真正实现登录和登出功能的接口
 *  3.这时候，如果我们想统计 网站的在线人数，有两种实现方法。
 *     - 3.1 修改WebsiteImpl里面的实现，当是这种方式对代码的侵入很大，不符合开闭原则（即对扩展开发，对修改关闭）
 *     - 3.2 通过动态代理的方式，将类的实现者传入，以切面的方式进行修改。不需要对原本的类做任何改变
 *
 *
 *
 *
 */
public class App2 {
    public static int count = 0;
    public static void main(String[] args) {
        // 实现登录登出网站的具体对象
        final Website websiteImpl = new WebsiteImpl();


        /*
         1.按照老师的说法 Proxy.newProxyInstance() 方法其实就是在代码运行的时候动态的
         在内存中创建了了一个 Website 接口的实现实现了。
         2.实现动态创建需要参
            - 2.1 类加载器
            - 2.2 接口的方法
            - 2.3 方法如何实现（一帮都是对方法的更改，或者增加方法）


         */
        Website websiteProxy = (Website) Proxy.newProxyInstance(App2.class.getClassLoader(), WebsiteImpl.class.getInterfaces(), new InvocationHandler() {

            /*
               1.这个应该是具体的方法实现者，也就是方法被加强的地方
               2. proxy 这里为空
               3. method 应该是 Website 的具体的方法，这里可以通过对方法名称的判断，做出不同的行为，默认可以调用
                  被代理类websiteImpl 的实现。
               4. []args 是被调用方法的参数
               5. 这里通过放射调用了 websiteImpl 的方法
             */
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                   method.invoke(websiteImpl,args);
                //System.out.println(proxy);
                if(method.getName().equalsIgnoreCase("logIn")){
                    count ++;
                }

                if(method.getName().equalsIgnoreCase("logOut")){
                    count --;
                }

                System.out.println("现在网站上有"+count+"个人");
                return null;
            }
        });

        websiteProxy.logIn("王震");

        websiteProxy.logIn("姜珊");

        websiteProxy.logIn("billGaets");

        websiteProxy.logOut("王震");;
    }
}
