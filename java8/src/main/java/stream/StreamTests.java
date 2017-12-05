package stream;

import com.google.common.collect.Lists;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTests {

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
}
