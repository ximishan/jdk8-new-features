package com.zhangf.java8.test1;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @author zhangfeng
 * @date 2020/2/21 11:03 下午
 *
 * 一：基础语法：java8引入了新的操作符”->” 该操作符成为箭头操作符或 Lambda 操作符。
 *  箭头操作符将 Lambda 表达式拆分成两部分：
 *     左侧：表示参数列表。
 *     右侧：表达式中所需要执行的功能，即 Lambda 体。
 *
 * 二：Lambda 表达式需要"函数式接口"的支持。
 *      函数式接口：只有一个方法的接口。可以使用注解 @FunctionalInterface 检查是否是函数式接口，比如接口：Consumer
 *      函数式接口可以使用lambda 表达式实现：实现方式：(参数列表) -> 实现的功能。
 *
 */
public class TestLambda2 {

    /**
     * 需要，对一个数进行计算
     */
    @Test
    public void test1() {
        Integer i1 = operator(100, x -> x *10);
        // 分析一下： operator 方法需要传入两个参数，一个参数是 integer 值，另外一个参数是 MyFun 的实现类
        // 其中 x -> x *10 等于=======参数列表 -> 实现的功能
        System.out.println(i1);
    }

    public Integer operator(Integer num, MyFun myFun) {
        return myFun.getValue(num);
    }
}
