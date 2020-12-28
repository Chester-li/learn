package option;

import java.util.Optional;

/**
 * @author chaoshuai.li
 * @date 2020/12/7
 * @description
 */
public class OptionTest {

    public static void main(String[] args) {
        String hello = "hello";
        String name = null;
        Optional.ofNullable(name).ifPresent(s -> {
            System.out.println(hello + name);
        });

        Optional.of(name).ifPresent(s -> {
            System.out.println(hello + name);
        });
    }

}
