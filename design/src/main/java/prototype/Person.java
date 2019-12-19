package prototype;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

public class Person implements Serializable{
    private String name;
    private String age;

    public String getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Person person = new Person();
        person.setAge("10");
        person.setName("10");
        System.out.println(JSONObject.toJSONString(person));
    }
}
