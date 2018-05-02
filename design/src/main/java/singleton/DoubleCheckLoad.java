package singleton;

public class DoubleCheckLoad {

    private static volatile DoubleCheckLoad instance = null;

    private DoubleCheckLoad() {
    }

    public static DoubleCheckLoad getInstance() {
        if(instance == null){
            synchronized (DoubleCheckLoad.class) {
                if (instance == null) { //5
                    instance = new DoubleCheckLoad();//6
                }
            }
        }
        return instance;
    }
}
