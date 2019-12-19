package client;

import java.util.List;

import lombok.Data;
import utils.GsonUtils;

public class Test {

    public static void main(String[] args) {
        String json = "[1,1,2,2,3]";
        System.out.println(GsonUtils.parseList(json, List.class));
        String assignee = "{\"person\":[12,23]}";
        Assignee assignee1 = GsonUtils.parseObject(assignee, Assignee.class);
        System.out.println(GsonUtils.toJson(assignee1));

    }

    @Data
    static class Assignee {
        private List<String> person;
    }
}
