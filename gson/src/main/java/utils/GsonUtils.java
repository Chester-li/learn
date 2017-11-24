package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Date;

import model.Person;


/**
 * Created by chaoshuai.li on 2017/11/24.
 */
public class GsonUtils {

    private static Gson gson = new GsonBuilder().create();
    private static Gson gsonWithNull = new GsonBuilder().serializeNulls().create();
    private static Gson prettyJson = new GsonBuilder().setPrettyPrinting().create();

    public static String toJson(Object object) {
        return gson.toJson(object);
    }

    public static String toJsonWhitNull(Object object){
        return gsonWithNull.toJson(object);
    }

    public static String toPrettyJson(Object object){
        return prettyJson.toJson(object);
    }

    public static <T> T parseObject(String jsonStr, Class<T> clazz) {
        return gson.fromJson(jsonStr, clazz);
    }


    public static void main(String[] args) {
        Person person = new Person(1 , new Date() , "charles");
        String personStr = GsonUtils.toJson(person);
        System.out.println(personStr);
        Person person1 = GsonUtils.parseObject(personStr , Person.class);
        System.out.println(person1);

        person1.setBirth(null);
        System.out.println(GsonUtils.toJsonWhitNull(person1));
        System.out.println(GsonUtils.toPrettyJson(person1));
    }
}
