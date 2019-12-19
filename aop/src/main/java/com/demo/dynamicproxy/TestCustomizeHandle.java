package com.demo.dynamicproxy;

import java.lang.reflect.Proxy;

public class TestCustomizeHandle {

    public static void main(String[] args) {
        ClassLoader classLoader = ISubject.class.getClassLoader();
        CustomizeHandle customizeHandle = new CustomizeHandle(new ISubjectImpl());
        ISubject iSubject  = (ISubject)Proxy.newProxyInstance(classLoader,
                ISubjectImpl.class.getInterfaces(), customizeHandle);
        iSubject.execute();
    }
}
