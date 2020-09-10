package com.learn.proxy.constatic;

import com.learn.proxy.impl.ChinaProducer;
import com.learn.proxy.impl.AppleByChinaProxy;

/**
 * @author chaoshuai.li
 * @date 2020/9/10
 * @description
 */
public class Entrance {
    public static void main(String[] args) {
        AppleByChinaProxy appleByChinaProxy = new AppleByChinaProxy(new ChinaProducer());
        appleByChinaProxy.saleApple(100);
    }
}
