package singleton;

public class HungryLoad {
    private static HungryLoad instance = new HungryLoad();

    private HungryLoad() {

    }

    public static HungryLoad getInstance() {
        return instance;
    }
}
