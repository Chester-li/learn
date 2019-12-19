package com.learn;

import com.google.gson.Gson;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import lombok.Data;

public class TestMain {

    public static void main(String[] args) throws IOException {
        String s = "{\"number\":\"1\"}";

        Gson gson = new Gson();
        TestNumber gsonNumber = gson.fromJson(s, TestNumber.class);
        System.out.println(gsonNumber.number);

        TestNumber jsonObject = JSONObject.parseObject(s, TestNumber.class);
        System.out.println(jsonObject.number);

        ObjectMapper mapper = new ObjectMapper();
        TestNumber fastJson = mapper.readValue(s, TestNumber.class);
        System.out.println(fastJson.number);


    }

    @Data
    static class TestNumber {
        private Integer number;
    }
}
