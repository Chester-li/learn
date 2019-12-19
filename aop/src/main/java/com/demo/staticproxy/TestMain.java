package com.demo.staticproxy;

public class TestMain {

    public static void main(String[] args) {
        InterfaceA interfaceA = new ProxyImplement();
        interfaceA.exec();
    }

}
