package com.learn.proxy.impl;

import com.learn.proxy.SellApple;

/**
 * @author chaoshuai.li
 * @date 2020/9/10
 * @description
 */
public class ChinaProducer implements SellApple {
    @Override
    public void saleApple(double price) {
        System.out.println("this apple sell by China, price is "+price);
    }

    @Override
    public double updatePrice(double price) {
        System.out.println("current price is "+ price * 1.1);
        return price * 1.1;
    }
}
