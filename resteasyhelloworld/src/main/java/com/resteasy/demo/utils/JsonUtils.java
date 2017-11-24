package com.resteasy.demo.utils;

import com.alibaba.fastjson.JSON;

/**
 * Created by chaoshuai.li on 2017/11/24.
 */
public class JsonUtils {


    public static String toJson(Object object){
        return JSON.toJSONString(object);
    }

//    public static <T> T parseObject(String jsonString){
//        TypeReference<T> typeReference = new TypeReference<T>() {};
//        return JSON.parseObject(jsonString,typeReference);
//    }

//    public static <T> T parseObject(String jsonString, Class<T> clazz){
//        TypeReference<T> typeReference = new TypeReference<T>() {};
//        return JSON.parseObject(jsonString, );
//    }
//
//    public static void main(String[] args) {
//        User user = new User(1, "charles", "li" , "/");
//        String userString = JsonUtils.toJson(user);
//        System.out.println(userString);
//        User user1 = JsonUtils.parseObject(userString);
//        System.out.println(user1.toString());
//    }

}
