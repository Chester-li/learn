package string;

import java.util.List;

public class StaticTest {

    static class MyList{

        private boolean colorEnable;
        private List<String> fullMethods;

        public Boolean needMethodColor(String fullMethod) {

            if (colorEnable) {
                if(fullMethods.contains(fullMethod)){
                    return true;
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {

    }
}
