package com.learn.proxy.dynamic.cglib;

import com.learn.proxy.SaleWine;
import com.learn.proxy.SellApple;
import com.learn.proxy.impl.ChinaProducer;
import com.learn.proxy.impl.WineByChineProxy;

/**
 * @author chaoshuai.li
 * @date 2020/9/10
 * @description
 */
public class Entrance {
    public static void main(String[] args) {
        SalesProxyFactory salesProxyFactory = new SalesProxyFactory();
        SellApple proxyInstance =(SellApple) salesProxyFactory.getProxyInstance(new ChinaProducer());
        proxyInstance.saleApple(10000);


        SaleWine wineProxy = (SaleWine)salesProxyFactory.getProxyInstance(new WineByChineProxy());
        wineProxy.sell(2000);
    }
}
