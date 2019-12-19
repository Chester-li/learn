package com.demo.staticproxy;

public class ProxyImplement implements InterfaceA {

    private InterfaceA interfaceA;

    public ProxyImplement() {
        this.interfaceA = new ReadImplement();
    }

    public void exec() {
        System.out.println("before do something");
        interfaceA.exec();
        System.out.println("after do something");
    }
}
