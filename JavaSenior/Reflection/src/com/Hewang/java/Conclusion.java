package com.Hewang.java;

import org.junit.Test;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author Hewang
 * @create 2020-05-17 10:17
 * @title 关于反射的总结
 * A、反射的使用终究是要落实到动态性上，因此从Class类源头的创建最好可以体现动态性
 * 因此：Class clzz=String.class;属于编译时就写死了的，如果String写错编译就报错
 * 即编译时期就会校验是否存在这个类；动态性是指在运行期根据需要创建Class对象
 * Class实例其实就是对应的运行时类本身；Class clzz=person.getClass();即通过对象
 * 获取类，实际上在重写equals()方法时会优先比较两个对象的类是否相同
 * Class clzz=Class.forName(String classPath);体现反射的动态性
 * 即编译的时候仅可以校验出classPath为一个字符串，运行时才会解析字符串内容的含义
 * B、Class类的理解
 * Class实例对应的是加载到内存中的一个运行时类（或其他结构）；
 * 通过Class实例可以调用该运行时类的你内部结构；
 * C、创建Class实例对应的运行时类对象的通用方法
 * clazz.newInstance();创建对象  要求必须有空参的构造器，且构造器的权限足够
 * D、在工程或者module下加载配置文件
 * E、实现方法的调用
 * F、常见类对象的方式？
 * 方式一：new+构造器
 * 方式二：创建Xxx类的对象，可以考虑通过Xxx、Xxxs、XxxFactory、XxxBuilder类中
 * 查看是否有静态方法的存在，通过调用静态方法实现创建对象
 * 方式三：通过反射
 */
/*
    1、Java反射机制描述
      Java语言本身是静态语言，通过反射机制可以实现动态性；
      反射机制允许程序在执行期间借助于ReflectionAPI取得任何类的内部信息；
      并能直接操作任意对象的内部属性和方法。
      java.lang.Class
      java.lang.reflect.*
      框架=发射+注解+设计模式
    2、理解Class类并获取Class类的实例
    3、类的加载和ClassLoader的理解
      类加载器的作用为：将class文件加载到内存中，并将这些静态数据转换为方法区中的
      运行时数据结构，然后在堆中生成一个代表这个类的java.lang.Class独享，作为
      方法区中类数据的访问入口，即实际的访问是访问方法区中的内容，Class实例作为
      接口出现？

      通过ClassLoader实现配置文件内容的获取
    4、创建运行时类的对象
    5、获取运行时类的完整结构
    6、调用运行时类的指定结构(属性、方法、构造器)组合要是方法
      静态方法的调用的主体可以使用null代替
    7、反射的应用：动态代理
 */
public class Conclusion {
    @Test
    public void test() throws Exception {
        Class clazz=Class.forName("com.Hewang.java.Person");
        Person person= (Person) clazz.newInstance();
        Method show = clazz.getDeclaredMethod("show");
        show.setAccessible(true);
        show.invoke(person);
    }
    //实现配饰文件内容的获取 通过类加载器
    @Test
    public void test1() throws Exception {
        //1、首先得到处理配置文件的对象
        //   可以通过源码查看相应的方法
        Properties pro=new Properties();
        //2、该类中定义的load方法是对流的输入流的操作，即读取操作
        //   通过类加载器加载配置文件可以得到输入流，然后通过load()实现配置文件的加载
        ClassLoader classLoader=Conclusion.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc.properties");
        pro.load(is);

        //3、加载配置文件完成之后，即可通过类中定义的方法实现配置文件中内容的获取
        String name = pro.getProperty("name");
        System.out.println(name);

    }
}
