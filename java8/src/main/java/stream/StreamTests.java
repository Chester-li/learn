package stream;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTests {

    private static Gson gson = new GsonBuilder().create();

    @Test
    public void filter() {
        //1. stream 不会存储元素，元素可能被存储在底层的集合中
        //2. stream 不会改变原对象
        //3. stream 在使用的时候才会执行
        List<String> words = Lists.newArrayList("a", "b", "c");
        long count = words.stream().filter(word -> word.contains("a")).count();
        System.out.println(count);

        //创建空的stream
        Stream<String> stream = Stream.empty();
        // 枚举值方式创建stream
        stream = Stream.of("a");
        // 根据已知数组创建stream
        stream = Arrays.stream((String[]) words.toArray());
        Stream<Double> doubleStream = Stream.generate(Math::random);
    }

    @Test
    public void toMap() {
        Map<String, String> map1 = Maps.newHashMap();
        map1.put("key", "aaa");
        Map<String, String> map2 = Maps.newHashMap();
        map2.put("key", "bbb");
        List<Map<String, String>> mapList = Lists.newArrayList();
        mapList.add(map1);
        mapList.add(map2);

        //将listMap转换成map 新值替换value
        Map<Object, Object> map = mapList.stream().collect(Collectors.toMap(i -> i.get("key"), i -> "aaa"));
        System.out.println(gson.toJson(map));
        //将listMap转换成map 原有值作为value
        Map<Object, Object> mapI = mapList.stream().collect(Collectors.toMap(i -> i.get("key"), i -> i));
        System.out.println(gson.toJson(mapI));
    }

    @Test
    public void construct() {
        // 1. 枚举值
        Stream stream = Stream.of("a", "b", "c");

        // 2. 使用数组创建
        String[] strArray = new String[]{"a", "b", "c"};
        stream = Stream.of(strArray);
        stream = Arrays.stream(strArray);

        // 3. Collections
        List<String> list = Arrays.asList(strArray);
        stream = list.stream();

        IntStream.of(new int[]{1, 2, 3}).forEach(System.out::println);
        IntStream.range(1, 3).forEach(System.out::println);
        IntStream.rangeClosed(1, 3).forEach(System.out::println);

    }

    @Test
    public void commonUse() {
        ArrayList<String> stringList = Lists.newArrayList("hello", "world");
        stringList.stream().map(String::toUpperCase).collect(Collectors.toList()).forEach(System.out::println);

        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        nums.stream().map(n -> n * n).collect(Collectors.toList()).forEach(System.out::println);

        Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6)
        );
        inputStream.flatMap(Collection::stream).forEach(System.out::println);


        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        // 字符串连接，concat = "ABCD"
        String concat = Stream.of("A", "B", "C", "D").reduce("", String::concat);
        // 求最小值，minValue = -3.0
        double minValue = Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double.MAX_VALUE, Double::min);
        // 求和，sumValue = 10, 有起始值
        int sumValue = Stream.of(1, 2, 3, 4).reduce(0, Integer::sum);
        // 求和，sumValue = 10, 无起始值
        sumValue = Stream.of(1, 2, 3, 4).reduce(Integer::sum).get();
        // 过滤，字符串连接，concat = "ace"
        concat = Stream.of("a", "B", "c", "D", "e", "F").
                filter(x -> x.compareTo("Z") > 0).
                reduce("", String::concat);

        // limit & skip
        List<Integer> intList = Lists.newArrayList();
        for (int i = 0 ; i < 1000; i++){
            intList.add(i);
        }
        intList.stream().limit(10).skip(3).collect(Collectors.toList()).forEach(System.out::println);

        //stream 中的 max
        System.out.println(intList.stream().max(Comparator.comparing(Integer::intValue)).get());
    }
}
