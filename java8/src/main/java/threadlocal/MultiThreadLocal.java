package threadlocal;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author chaoshuai.li
 * @date 2020/12/28
 * @description
 */
public class MultiThreadLocal {

    @Data
    @AllArgsConstructor
    public static class Person {
        private String name;
        private String id;
    }

    @Data
    @AllArgsConstructor
    public static class Dog {
        private String name;
    }

    public static ThreadLocal<Person> personThreadLocal = new ThreadLocal<>();
    public static ThreadLocal<Dog> dogThreadLocal = new ThreadLocal<>();


    public static void main(String[] args) {
        Person person = new Person("John", "1");
        Dog dog = new Dog("tom");
        personThreadLocal.set(person);
        dogThreadLocal.set(dog);

        System.out.println(personThreadLocal.get());
        System.out.println(dogThreadLocal.get());
    }

}
