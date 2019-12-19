package prototype;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

public abstract class Prototype implements Cloneable, Serializable {

    protected String attribute;

    protected Map<String, String> pairs;

    protected Person person;

    public void setPerson(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public void setPairs(Map<String, String> pairs) {
        this.pairs = pairs;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getAttribute() {
        return attribute;
    }

    public Map<String, String> getPairs() {
        return pairs;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Prototype deepCloneByObjectStream() throws IOException, ClassNotFoundException, CloneNotSupportedException {
        return (Prototype) this.clone();
    }

    public Prototype deepCloneByJsonSerialize() throws CloneNotSupportedException {
        return (Prototype) super.clone();
    }

    public Prototype deepCloneByGsonSerialize() throws CloneNotSupportedException {
        return (Prototype) super.clone();
    }
}
