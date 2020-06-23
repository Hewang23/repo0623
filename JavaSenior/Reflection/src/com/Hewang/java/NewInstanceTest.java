package com.Hewang.java;

import org.junit.Test;

import java.util.Random;

/**
 * @author Hewang
 * @create 2020-05-16 17:32
 * @title 通过反射创建对应的运行时类的对象
 * 实际上创建对应运行时类的对象方法多样
 * 方式一：通过Class实例来获取指定构造器进行newInstance实现
 * 方式二：通过Class实例直接进行newInstance实现，此时使用的为空参构造器
 *
 * 首先需要声明的是：类的加载过程，类经过编译后生成字节码文件，运行时将该字节码文件加载到内存中
 * 此时在堆内存的方法区生成Class对象，即在运行时才会得到Class对象；
 * 因为编译后才生成.class文件，因此实际上类的确定是在编译之后，即在运行时确定，因此为动态性
 *
 */
public class NewInstanceTest {
    @Test
    public void test1() throws IllegalAccessException, InstantiationException {
        Class class1=Person.class;
        Person p1= (Person) class1.newInstance();
        System.out.println(p1);
        /*
        此时抛出的两个异常：限定使用默认空参构造器的形式
        IllegalAccessException：非法访问即该运行时类空参构造器的访问类型不同
        InstantiationException：实例化错误即该运行时类无空参构造器

        在javabean中要求提供public的空参构造器原因为：
        1、便于通过反射创建运行时类的对象
        2、便于子类继承此运行时类时，若默认调用super()时，保证父类有该构造器
         */
    }
    public Object getInstance(String classPath) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class aClass = Class.forName(classPath);
        return aClass.newInstance();
    }
    @Test
    public void test2(){
        int num=new Random().nextInt(3);
        String classPath="";
        switch (num){
            case 0:
                classPath="java.util.Date";
            case 1:
                classPath="java.lang.Object";
            case 2:
                classPath="com.Hewang.java.Person";
        }
        Object instance = null;
        try {
            instance = getInstance(classPath);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        System.out.println(instance);
    }
    @Test
    public void test3(){
        int num=new Random().nextInt(3);
        switch (num){
            case 0:
                Object object=new java.util.Date();
                System.out.println(object);
                break;
            case 1:
                Object object1=new Person();
                System.out.println(object1);
                break;
            case 2:
                Object object2=new Object();
                System.out.println(object2);
                break;
        }

    }
}
