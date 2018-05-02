package singleton;

import org.junit.Test;

import static org.junit.Assert.*;

public class HungryLoadTest {

    @Test
    public void getInstance() {
        System.out.println(HungryLoad.getInstance());
    }
}