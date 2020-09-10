package com.learn.proxy.dynamic.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author chaoshuai.li
 * @date 2020/9/10
 * @description
 */
public class SellProxyFactory implements InvocationHandler {

    private Object realObject;

    public SellProxyFactory(Object realObject){
        this.realObject = realObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        doSomethingBeforeInvoke();
        Object result = method.invoke(realObject, args);
        doSomethingAfterInvoke();
        return result;
    }

    private void doSomethingBeforeInvoke(){
        System.out.println("do something before invoke");
    }

    private void doSomethingAfterInvoke(){
        System.out.println("do something after invoke");
    }
}
