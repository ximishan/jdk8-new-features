package com.zhangf.java8.test1;

import org.junit.Test;

import java.util.Comparator;
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
     * 语法三：如果只有一个参数，该参数上的小括号可以不写。
     */
    @Test
    public void test2() {
        Consumer<String> consumer = (x) -> System.out.println(x);
        consumer.accept("这里是测试数据");
        System.out.println("----------------");
        Consumer<String> consumer1 = x -> System.out.println(x);
        consumer.accept("hahahhha");
    }

    /**
     * 语法四：有两个参数，有返回值，并且 Lambda 体中有多条语句
     *      Lambda 体的多条语句使用 {} 扩起来
     */
    @Test
    public void test3() {
        Comparator<Integer> comparable = (x, y) -> {
            System.out.println("hahahah");
            return Integer.compare(x,y);
        };
        System.out.println(comparable.compare(1,2));
        System.out.println(comparable.compare(1,1));
        System.out.println(comparable.compare(1,0));
    }

    /**
     * 语法五：如果 Lambda 体中只有一条语句， return 和 {} 都可以省略不写
     *
     */
    @Test
    public void test5() {
        Comparator<Integer> comparable = (x, y) -> Integer.compare(x,y);
        System.out.println(comparable.compare(1,2));
        System.out.println(comparable.compare(1,1));
        System.out.println(comparable.compare(1,0));
    }

    /**
     * 语法六：lambda 表达式中的括号中的参数类型可以忽略不写，JVM编译器会根据上下文判断出数据类型，即"类型判断"
     * 要不都写，要不都不写
     *
     */
    @Test
    public void test6() {
        Comparator<Integer> comparable = (x, y) -> Integer.compare(x,y);

//        Comparator<Integer> comparable1 = (Integer x, y) -> Integer.compare(x,y);

        Comparator<Integer> comparable2 = (Integer x,Integer y) -> Integer.compare(x,y);

    }
}
