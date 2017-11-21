package rest.model;

/**
 * Created by chaoshuai.li on 2017/11/21.
 */
public class Product {

    private String name;
    private int id;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "Product [name=" + name + ", id=" + id + "]";
    }
}
