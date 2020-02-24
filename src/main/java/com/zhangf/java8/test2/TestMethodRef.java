package com.zhangf.java8.test2;

import org.junit.Test;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.function.*;

/**
 * @author zhangfeng
 * @date 2020/2/24 9:22 下午
 *
 * 不建议使用，可读性太差
 *
 * 方法引用：若 Lambda 体中的内容方法已经实现了，我们可以使用方法引用（::）双冒号
 *
 * 主要有三种表达形式：
 *
 *  对象::实例方法名
 *  类::静态方法名
 *  类::实例方法名
 *
 *  注意：
 *  1.Lambda 体中调用方法的参数列表和返回值类型，要与函数式接口中的抽象方法的参数列表和返回值一致！
 *  2.若 Lambda 参数列表中的第一个参数是实例方法的调用者，而第二个参数是实例方法中的参数时，可以使用 类::方法名
 *      也就是说必须一一对应，调用者还是调用者，参数还是参数才可以。
 *
 *
 *  构造器引用
 *  格式：
 *  ClassName::new;
 *
 *  注意：需要调用的构造器的参数列表必须与函数式接口中的方法的参数列表保持一致！
 *
 *
 *
 *  数组引用:
 *  格式：
 *  Type[]::new;
 *
 */
public class TestMethodRef {

    // 数组引用
    @Test
    public void test8() {
        Function<Integer, String[]> function1 = (x) -> new String[x];
        String[] aa = function1.apply(10);
        System.out.println(aa.length);

        Function<Integer, String[]> function2 = String[]::new;
        String[] bb = function2.apply(20);
        System.out.println(bb.length);

    }


    // 构造器引用 1
    @Test
    public void test6() {
        Supplier<Employee> supplier1 = () -> new Employee();

        // 构造器引用
        Supplier<Employee> supplier2 = Employee::new;
        Employee employee = supplier2.get();
        System.out.println(employee);
    }

    // 构造器引用 2
    @Test
    public void test7() {
        Function<Integer, Employee> function1 = (x) -> new Employee(x);

        Function<Integer, Employee> function2 = Employee::new;
        Employee employee = function2.apply(11);
        System.out.println(employee);

        BiFunction<Integer, Integer, Employee> bf = Employee::new;

    }

    // 对象：：实例方法名
    @Test
    public void test1() {
        // println 方法的参数列表和返回值同 Consumer 一致
        // 方式一
        Consumer<String> con = (x) -> System.out.println(x);
        PrintStream ps = System.out;
        Consumer<String> con1 = (x) -> ps.println(x);
        con1.accept("1111111");

        //方式二
        Consumer<String> con2 = System.out::println;
        con2.accept("222222222");
    }

    // 对象：：实例方法名
    @Test
    public void test2() {
        Employee employee = new Employee();
        employee.setName("张三");
        employee.setAge(11);
        Supplier<String> str1 = () -> employee.getName();
        System.out.println(str1.get());
        // 获取姓名
        Supplier<String> str2 = employee::getName;
        System.out.println(str2.get());

        // 获取年龄
        Supplier<Integer> age = employee::getAge;
        System.out.println(age.get());
    }

    // 类：：静态方法名
    @Test
    public void test3() {
        Comparator<Integer> comparator = (x,y) -> Integer.compare(x,y);

        Comparator<Integer> comparator1 = Integer::compare;

    }

    // 类：：实例方法
    @Test
    public void test4() {
        BiPredicate<String, String> biPredicate1 = (x,y) -> x.equals(y);

        //
        BiPredicate<String, String> biPredicate2 = String::equals;

    }
}
