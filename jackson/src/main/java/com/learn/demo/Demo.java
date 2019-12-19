package com.learn.demo;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import com.alibaba.fastjson.JSONObject;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Demo {
    public static void main(String[] args) {
        List<FieldAndValue> fieldAndValueList = Lists.newArrayList();

        FieldAndValue fieldAndValue1 = new FieldAndValue("date", new Date());
        FieldAndValue fieldAndValue2 = new FieldAndValue("lone", 1000l);
        fieldAndValueList.add(fieldAndValue1);
        fieldAndValueList.add(fieldAndValue2);

        System.out.println(JSONObject.toJSONString(fieldAndValueList));

        Map<String, Object> response = Maps.newHashMap();
        for (int i = 0; i < fieldAndValueList.size(); i++) {
            response.put(fieldAndValueList.get(i).field,fieldAndValueList.get(i).value);
        }
        System.out.println(JSONObject.toJSONString(response));

    }

    @Data
    @AllArgsConstructor
    static class FieldAndValue{
        private String field;
        private Object value;
    }
}
