package com.zhangf.java8.test2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author zhangfeng
 * @date 2020/2/22 9:24 下午
 * Lambda 四大内置核心函数式接口
 *
 * Consumer<T>  消费型接口 消费对象 没有返回值
 *     void accept(T t);
 * Supplier<T>  供给型接口 生成对象
 *     T get();
 * Function<R,T>  函数型接口 指定特定功能
 *     R apply(T t);
 * Predicate<T>  断言型接口 进行条件判断
 *     boolean test(T t);
 */
public class TestLambda3 {


    // 消费型接口
    @Test
    public void test1 () {
        consumerT(1000, (i) -> System.out.println("消费了"+i + "元"));
    }
    public void consumerT(int money, Consumer<Integer> consumer) {
        consumer.accept(money);
    }

    // 供给型接口
    @Test
    public void test2 () {
        List<Integer> list = getIntegerList(10, ()-> (int)(Math.random()*101));
        for (Integer ii:list) {
            System.out.println(ii);
        }
    }

    public List<Integer> getIntegerList (int num, Supplier<Integer> sup) {
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<num;i++) {
            list.add(sup.get());
        }
        return list;
    }

    /**
     * 函数型接口
     */
    @Test
    public void test3 () {
        String result = strFun("  kslklks  ", (str) -> str.trim());
        System.out.println(result);

        result = strFun("kslklks  ", (str) -> str.substring(2,5));
        System.out.println(result);
    }

    public String strFun(String str1, Function<String,String> fun) {
        return fun.apply(str1);
    }

    //断言型接口
    @Test
    public void test4() {
        boolean boo = predicateT(10, x -> x>10 );
        System.out.println(boo);
    }

    public boolean predicateT (int num, Predicate<Integer> predicate) {
        return predicate.test(num);
    }


}
