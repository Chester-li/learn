package com.learn.proxy.impl;

import com.learn.proxy.SellApple;

/**
 * @author chaoshuai.li
 * @date 2020/9/10
 * @description
 */
public class AppleByChinaProxy implements SellApple {

    private ChinaProducer chinaProducer;

    public AppleByChinaProxy(ChinaProducer chinaProducer){
        this.chinaProducer = chinaProducer;
    }

    @Override
    public void saleApple(double price) {
        doSomethingBeforeSell();
        chinaProducer.saleApple(price);
        doSomethingAfterSell();
    }

    @Override
    public double updatePrice(double price) {
        return price * 2;
    }

    private void doSomethingBeforeSell(){
        System.out.println("China proxy before sell");
    }

    private void doSomethingAfterSell(){
        System.out.println("China proxy after sell");
    }
}
