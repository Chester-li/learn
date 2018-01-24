package string;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

import java.util.List;

public class StringTest {
    public static void main(String[] args) {
        String s = ",";
        List<String> strings = Splitter.on(",").splitToList(s);
        System.out.println(strings+" "+strings.size());
//        String[] stringArr = s.split(",");
//        System.out.println(JsonUtil.toJson(stringArr));
//        Iterable<String> split = Splitter.on(s).trimResults().split(",");
//        System.out.println(split);
//        System.out.println("============");
//        char splitChar = ',';
//        strings = Splitter.on(splitChar).splitToList(s);
//        System.out.println(strings+" "+strings.size());

        String testLimit = "aaa,bb,cc,,";
        System.out.println(Lists.newArrayList(testLimit.split(s)));
        System.out.println(Lists.newArrayList(testLimit.split(s , 7)));
        System.out.println(Lists.newArrayList(testLimit.split(s , 2)));
        System.out.println(Lists.newArrayList(testLimit.split(s , 0)));
    }
}
