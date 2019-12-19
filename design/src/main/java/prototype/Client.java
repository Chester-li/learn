package prototype;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Client {

    public static void main(String[] args)
            throws CloneNotSupportedException, IOException, ClassNotFoundException {
        Prototype prototype = new ConcretePrototype();
        prototype.setAttribute("110");
        Map<String, String> currentMap = new HashMap<String, String>();
        currentMap.put("hello", "world");
        prototype.setPairs(currentMap);
        Person person = new Person();
        person.setAge("10");
        person.setName("hello");
        prototype.setPerson(person);

        Prototype clone = (Prototype) prototype.clone();
        System.out.println("clone hash code: " + (clone.hashCode() == prototype.hashCode()));
        System.out.println("clone map :" + (clone.pairs.hashCode() == prototype.pairs.hashCode()));
        System.out.println("clone Person : " + (clone.person.hashCode() == prototype.person.hashCode()));

        Prototype deepCopyPrototype = prototype.deepCloneByObjectStream();
        System.out.println("deepCopyPrototype hash code: " + (deepCopyPrototype.hashCode() == prototype.hashCode()));
        System.out.println("deepCopyPrototype map :" + (deepCopyPrototype.pairs.hashCode() == prototype.pairs.hashCode()));
        System.out.println("deepCopyPrototype Person : " + (deepCopyPrototype.person.hashCode() == prototype.person.hashCode()));

        Prototype deepCloneByJsonSerialize = prototype.deepCloneByJsonSerialize();
        System.out.println("deepCloneByJsonSerialize hash code: " + (deepCloneByJsonSerialize.hashCode() == prototype.hashCode()));
        System.out.println("deepCloneByJsonSerialize map :" + (deepCloneByJsonSerialize.pairs.hashCode() == prototype.pairs.hashCode()));
        System.out.println("deepCloneByJsonSerialize Person : " + (deepCloneByJsonSerialize.person.hashCode() == prototype.person.hashCode()));

        Prototype deepCloneByGsonSerialize = prototype.deepCloneByGsonSerialize();
        System.out.println("deepCloneByGsonSerialize hash code: " + (deepCloneByGsonSerialize.hashCode() == prototype.hashCode()));
        System.out.println("deepCloneByGsonSerialize map :" + (deepCloneByGsonSerialize.pairs.hashCode() == prototype.pairs.hashCode()));
        System.out.println("deepCloneByGsonSerialize Person : " + (deepCloneByGsonSerialize.person.hashCode() == prototype.person.hashCode()));

    }
}
