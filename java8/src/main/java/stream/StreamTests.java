package stream;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
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
    public void toMap(){
        Map<String , String> map1 = Maps.newHashMap();
        map1.put("key","aaa");
        Map<String , String> map2 = Maps.newHashMap();
        map2.put("key","bbb");
        List<Map<String , String>> mapList = Lists.newArrayList();
        mapList.add(map1);
        mapList.add(map2);

        //将listMap转换成map 新值替换value
        Map<Object, Object> map = mapList.stream().collect(Collectors.toMap(i -> i.get("key"), i -> "aaa"));
        System.out.println(gson.toJson(map));
        //将listMap转换成map 原有值作为value
        Map<Object, Object> mapI = mapList.stream().collect(Collectors.toMap(i -> i.get("key"), i -> i));
        System.out.println(gson.toJson(mapI));
    }
}
