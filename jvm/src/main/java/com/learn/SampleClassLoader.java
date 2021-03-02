package com.learn;

import java.net.URL;

/**
 * @author chaoshuai.li
 * @date 2021/3/1
 * @description
 */
public class SampleClassLoader {

    public static void main(String[] args) {
        //查看当前类的类加载器
        ClassLoader loader= SampleClassLoader.class.getClassLoader();
        while(loader!=null){
            System.out.println(loader);
            loader=loader.getParent();
        }
        System.out.println(loader);


        //Bootstrap 类加载器的jar加载目录下的内容
        System.out.println(System.getProperty("sun.boot.class.path"));


        // Bootstrap 类加载器加载的核心类库
        URL[]urls=sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for(int i=0;i<urls.length;++i){
            System.out.println(urls[i].toExternalForm());
        }
    }
}
