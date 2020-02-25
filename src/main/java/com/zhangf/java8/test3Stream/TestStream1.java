package com.zhangf.java8.test3Stream;

import com.zhangf.java8.test2.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author zhangfeng
 * @date 2020/2/25 10:46 下午
 *
 *  Stream 流的三种操作
 *
 *  1。创建Stream流
 *  2。中间操作
 *  3。终止操作。
 */
public class TestStream1 {

    // 创建流
    @Test
    public void test() {
        // 1. 通过Collection 系列集合提供的 stream() 或 parallelStream() 方法
        List<String> list1 = new ArrayList<>();
        Stream<String> stream1 = list1.stream();

        // 2.通过 Arrays 中的静态方法 stream() 获取数组流
        Employee[] employees = new Employee[10];
        Stream<Employee> stream2 = Arrays.stream(employees);

        // 3. 通过 Stream 类中的静态方法 of()
        Stream<String> stream3 = Stream.of("aa","bb","cc");

        // 4. 创建无限流
        // 迭代
        Stream<Integer> stream4 = Stream.iterate(0, (x) -> x+2);
        stream4.limit(10)
                .forEach(System.out::println);
        // 生成
        Stream.generate(()-> Math.random())
                .limit(5)
                .forEach(System.out::println);
    }
}
