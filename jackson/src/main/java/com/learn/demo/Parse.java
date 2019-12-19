package com.learn.demo;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Parse {

    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Person person = new Person();
        person.setAge(10);
        person.setName("hello");
        System.out.println(objectMapper.writeValueAsString(person));


        List<Map<String, Set<String>>> list = Lists.newArrayList();
        Set<String> set = Sets.newHashSet("hello", "world");
        Map<String, Set<String>> map = Maps.newHashMap();
        map.put("first", set);
        list.add(map);
        String value = objectMapper.writeValueAsString(list);
        System.out.println(value);

        TypeReference<List<Map<String, Set<String>>>> typeReference =
                new TypeReference<List<Map<String, Set<String>>>>() {
                };
        List<Map<String, Set<String>>> copyList = objectMapper.readValue(value, typeReference);
        System.out.println(copyList.get(0).get("first").add("hello"));
    }
}
