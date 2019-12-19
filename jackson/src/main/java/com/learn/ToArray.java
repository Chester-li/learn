package com.learn;

import com.google.gson.Gson;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ToArray {

    public static void main(String[] args) throws IOException {
        Gson gson = new Gson();
        List<String> stringList = new ArrayList<String>();
        stringList.add("hello");
//        String jsonStr = gson.toJson(stringList);
        String reJsonStr = gson.toJson(stringList);
        System.out.println(reJsonStr);

        List<String> strings = JSON.parseArray(reJsonStr, String.class);
        assert strings.size() != 0;

        ObjectMapper objectMapper = new ObjectMapper();
        People people = objectMapper.readValue("{\"TeamMember\":\"hello\"}", People.class);
        System.out.println(people);
    }

    //    @Data
    static class People {
        public String TeamMember;

        public void setTeamMember(String teamMember) {
            TeamMember = teamMember;
        }

        public String getTeamMember() {
            return TeamMember;
        }
    }
}
