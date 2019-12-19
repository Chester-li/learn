package com.demo.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class CustomizeHandle implements InvocationHandler {

    private Object target;

    public CustomizeHandle(Object proxied) {
        this.target = proxied;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        this.before();
        System.out.println("proxy class :" + proxy.getClass());
        System.out.println("arg : "+Arrays.toString(args));
        System.out.println("method : "+method.getName());
        Object result = method.invoke(target , args);
        this.after();
        return result;
    }

    private void before() {
        System.out.println("handle before");
    }

    private void after() {
        System.out.println("handler after");
    }
}
