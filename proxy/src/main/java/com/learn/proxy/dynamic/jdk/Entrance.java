package com.learn.proxy.dynamic.jdk;

import com.learn.proxy.SaleWine;
import com.learn.proxy.SellApple;
import com.learn.proxy.impl.ChinaProducer;
import com.learn.proxy.impl.WineByChineProxy;

import java.lang.reflect.Proxy;

/**
 * @author chaoshuai.li
 * @date 2020/9/10
 * @description
 */
public class Entrance {
    public static void main(String[] args) {
        ChinaProducer chinaProducer = new ChinaProducer();
        SellProxyFactory sellProxyFactory = new SellProxyFactory(chinaProducer);
        SellApple sellApple = (SellApple) Proxy.newProxyInstance(chinaProducer.getClass().getClassLoader(),
                chinaProducer.getClass().getInterfaces(), sellProxyFactory);
        sellApple.saleApple(10300);
        sellApple.updatePrice(20000);

        WineByChineProxy wineByChineProxy = new WineByChineProxy();
        sellProxyFactory = new SellProxyFactory(wineByChineProxy);
        SaleWine sellWine = (SaleWine) Proxy.newProxyInstance(wineByChineProxy.getClass().getClassLoader(),
                wineByChineProxy.getClass().getInterfaces(), sellProxyFactory);
        sellWine.sell(10000);
    }
}
