package com.mockit.test.demo2;

import org.junit.Assert;
import org.junit.Test;

import mockit.Expectations;
import mockit.Mocked;
import mockit.Verifications;

public class TestMockPerson {

    //添加Mocked注解之后，该对象会自动被实例化
    @Mocked
    Person person;

    @Test
    public void testPersonName(){
        new Expectations(){
            {
                person.getAddress();
                result = "beijing";
            }
        };

        Assert.assertEquals("beijing",person.getAddress());

        //判断方法调用次数 ，当前只是调用了一次，如果time为2的话会出现异常
        new Verifications(){
            {
                person.getAddress();
                times = 2;
            }
        };
    }

}
