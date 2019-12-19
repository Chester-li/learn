package builder;

import lombok.Data;

@Data
public class Person {

    private int age;
    private String name;

    public static class PersonBuilder {
        private int age;
        private String name;

        public PersonBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public PersonBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public Person build() {
            Person person = new Person();
            person.setName(name);
            person.setAge(age);
            return person;
        }
    }
}
