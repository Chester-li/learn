package string;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

import java.util.List;

public class StringTest {
    public static void main(String[] args) {
        String s = ",";
        List<String> strings = Splitter.on(",").splitToList(s);
        strings.stream().forEach(item -> System.out.println("==="+item+"==="));
        System.out.println(s.split(",").length);
        String testLimit = "aaa,bb,cc,,";
        System.out.println(Lists.newArrayList(testLimit.split(s)));
        System.out.println(Lists.newArrayList(testLimit.split(s , 7)));
        System.out.println(Lists.newArrayList(testLimit.split(s , 2)));
        System.out.println(Lists.newArrayList(testLimit.split(s , 0)));
    }
}
