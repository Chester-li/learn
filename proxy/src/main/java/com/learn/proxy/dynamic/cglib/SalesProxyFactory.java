package com.learn.proxy.dynamic.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author chaoshuai.li
 * @date 2020/9/10
 * @description
 */
public class SalesProxyFactory implements MethodInterceptor {

    private Object realObject;

    public Object getProxyInstance(Object realObject){
        this.realObject = realObject;
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(realObject.getClass().getClassLoader());
        enhancer.setSuperclass(realObject.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        doSomethingBefore();
        Object result = methodProxy.invokeSuper(o, objects);
        doSomethingAfter();
        return result;
    }

    private void doSomethingBefore(){
        System.out.println("do something before");
    }

    private void doSomethingAfter(){
        System.out.println("do something after");
    }
}
