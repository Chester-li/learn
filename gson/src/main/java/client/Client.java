package client;

import java.util.List;

import lombok.Data;
import utils.GsonUtils;

public class Client {
    public static void main(String[] args) {
        String json = "{\"people\":[1231,12312,123121]}";
        People people = GsonUtils.parseObject(json , People.class);
        System.out.println(GsonUtils.toJsonWhitNull(people));

        String json2 = "{\"people\":[\"1231\",\"12312\",\"123121\"]}";
        PeopleInt peopleInt = GsonUtils.parseObject(json2, PeopleInt.class);
        System.out.println(GsonUtils.toJsonWhitNull(peopleInt));

    }
}

@Data
class People{
    private List<String> people;
}

@Data
class PeopleInt{
    private List<Integer> people;
}