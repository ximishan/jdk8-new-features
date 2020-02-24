package com.zhangf.java8.test2;

/**
 * @author zhangfeng
 * @date 2020/2/22 4:34 下午
 */
public class Employee {
    private int id;
    private String name;
    private int age;
    private double salary;

    public Employee(int id) {
        this.id = id;
    }

    public Employee(int id, int age) {
        this.id = id;
        this.age = age;
    }

    public Employee() {

    }

    public Employee(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
