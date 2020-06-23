package com.atguigu.java1;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author Hewang
 * @create 2020-05-15 15:14
 * @title
 * 使得Person类的实例化对象为可序列化对象
 * 1、首先需要实现Serializable接口
 * （该接口为标识接口，即没有需要重写的方法）
 * 2、需要当前类提供全局常量serialVersionUID
 *    如果类中没有显示定义，Java运行时环境会根据类的内部细节自动生成
 *    即若类进行修改后，该serialVersionUID会发生变化，
 *    即之前的序列化数据的读取操作会出现异常
 * 3、除当前Person类继承接口外，其内部所有属性也必须为可序列化的；
 *    默认情况下：基本数据类型是可序列化的
 * 补充：不能序列化static以及transient修饰的属性
 */
public class Person implements Serializable {

    public static final long serialVersionUID = 454684768452L;
    private String name;
    private  int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
