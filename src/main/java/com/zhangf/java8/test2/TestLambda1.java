package com.zhangf.java8.test2;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author zhangfeng
 * @date 2020/2/22 4:35 下午
 */
public class TestLambda1 {

    List<Employee> list = Arrays.asList(
            new Employee(100, "张三", 18, 5888),
            new Employee(101, "李四", 20, 6888),
            new Employee(102, "王五", 25, 2888),
            new Employee(103, "赵六", 35, 3888),
            new Employee(104, "田七", 40, 8888)
    );

    @Test
    public void test1() {
        Collections.sort(list, (e1, e2) -> {
            if (e1.getAge() == e2.getAge()) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return Integer.compare(e1.getAge(), e2.getAge());
            }
        });

        list.forEach(System.out::println);

    }
}
