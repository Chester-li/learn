package prototype;

import com.google.gson.Gson;

import com.alibaba.fastjson.JSONObject;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class ConcretePrototype extends Prototype {


    @Override
    public Prototype clone() {
        Prototype prototype = new ConcretePrototype();
        prototype.attribute = this.attribute;
        prototype.pairs = new HashMap<String, String>(pairs);
        prototype.person = new Person();
        person.setName(this.getPerson().getName());
        person.setAge(this.getPerson().getAge());
        return prototype;
    }

    public Prototype deepCloneByObjectStream() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(this);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        return (Prototype) objectInputStream.readObject();
    }

    public Prototype deepCloneByJsonSerialize() {
        JSONObject json = JSONObject.parseObject(JSONObject.toJSONString(this));
        return JSONObject.toJavaObject(json, ConcretePrototype.class);
    }

    public Prototype deepCloneByGsonSerialize() {
        Gson gson = new Gson();
        return gson.fromJson(gson.toJson(this), ConcretePrototype.class);
    }
}
