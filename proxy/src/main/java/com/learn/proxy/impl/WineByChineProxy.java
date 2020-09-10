package com.learn.proxy.impl;

import com.learn.proxy.SaleWine;

/**
 * @author chaoshuai.li
 * @date 2020/9/10
 * @description
 */
public class WineByChineProxy implements SaleWine {
    @Override
    public void sell(double price) {
        System.out.println("current wine price is " + price);
    }
}
