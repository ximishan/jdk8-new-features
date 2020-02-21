package com.zhangf.java8.test1;

import org.junit.Test;

import java.util.function.Consumer;

/**
 * @author zhangfeng
 * @date 2020/2/21 11:03 下午
 *
 * 基础语法：java8引入了新的操作符”->” 该操作符成为箭头操作符或 Lambda 操作符。
 *  箭头操作符将 Lambda 表达式拆分成两部分：
 *     左侧：表示参数列表。
 *     右侧：表达式中所需要执行的功能，即 Lambda 体。
 *
 */
public class TestLambda1 {

    /**
     * 语法一：无参数，无返回值
     */
    @Test
    public void test1() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello Lambda!");
            }
        };
        runnable.run();

        System.out.println("----------------");
        Runnable runnable1 = () -> System.out.println("hello Lambda!");
        runnable1.run();

    }

    /**
     * 语法二：有一个参数，无返回值。
     *    如果只有一个参数，该参数上的小括号可以不写。
     */
    @Test
    public void test2() {
        Consumer<String> consumer = (x) -> System.out.println(x);
        consumer.accept("这里是测试数据");
        System.out.println("----------------");
        Consumer<String> consumer1 = x -> System.out.println(x);
        consumer.accept("hahahhha");
    }


}
