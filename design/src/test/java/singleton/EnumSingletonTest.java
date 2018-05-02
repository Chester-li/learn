package singleton;

import org.junit.Test;

import static org.junit.Assert.*;
import static singleton.EnumSingleton.instance;

public class EnumSingletonTest {

    @Test
    public void testEnumSingleton(){
        instance.getSingleton().sayHello();
    }

}