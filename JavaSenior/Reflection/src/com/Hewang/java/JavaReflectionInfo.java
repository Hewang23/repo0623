package com.Hewang.java;

import org.junit.Test;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author Hewang
 * @create 2020-05-16 14:29
 * @title  Java反射机制
 * Reflection为被视为动态语言的关键，反射机制允许程序在执行期
 * 借助于Reflection API取得任何类的内部信息，并能操作任意对象的内部属性和方法
 * 加载完类之后，在堆内存的方法区中出现Class类型的对象，一个类只有一个Class类型对象
 * 该对象包含了完整的类的结构信息，通过该对象得到类的结构
 * 正常方式：引入需要的包类名称、通过new实例化、取得实例化对象
 * 反射方式：实例化对象、getClass()方法、得到完整的包类名称
 *
 * 动态语言：在运行时可以改变其结构的语言：新的函数、对象、甚至代码可以被引进
 * 静态语言：
 * Java时准动态语言，通过反射机制、字节码操作获得类似动态语言的特征
 */
public class JavaReflectionInfo {
    //反射前对Person类的操作
    @Test
    public void test1(){
        //1、创建Person类的对象
        Person p1=new Person("Tom",16);
        //2、通过对象调用内部的属性和方法
        p1.age=15;
        System.out.println(p1.toString());
        p1.show();
        //3、在Person类外部，不能通过Person类的对象调用内部私有结构
    }
    //反射后对Person类的操作
    @Test
    public void test2() throws Exception {
        //通过反射可以得到属性、方法、构造器等类的结构，运行时类的父类
        //1、通过反射创建Person类对象
        Class personClass = Person.class;
        Constructor constructor = personClass.getConstructor(String.class, int.class);
        Object tom = constructor.newInstance("Tom", 14);
        System.out.println(tom);
        //2、通过反射调用Person类的属性和方法
        //调用属性
        Field age = personClass.getDeclaredField("age");
        age.set(tom,10);
        //调用方法
        Method show=personClass.getDeclaredMethod("show");
        show.invoke(tom);
        //3、通过反射可以调用Person类的私有结构
        //私有的构造器
        Constructor cons= personClass.getDeclaredConstructor(String.class);
        cons.setAccessible(true);
        Person p= (Person) cons.newInstance("Jerry");
        System.out.println(p);
        //私有属性
        Field name = personClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p,"Jerrrrr");
        //私有方法
        Method getNation = personClass.getDeclaredMethod("getNation", String.class);
        getNation.setAccessible(true);
        String natoin = (String) getNation.invoke(p, "China");

        //疑问？
        /*
        问题一：通过new的方式或反射的方式都可以调用公共的结构，开发时选择？
            建议：直接new的方法
            如果通过直接new的方式则在编译时就确定了要创建的类
            而有一部分情况下在编译时期也不能确定要创建的类
            举例：服务器开启之后，浏览器或者客户端通过注册或者登录功能访问服务器时
                 需要创建不同的对象，此时即为运行时创建对象的情景
        问题二：反射机制与面向对象中的封装性存在的矛盾？
            其实不矛盾。封装性提供建议，反射提供可能
         */
        /*
        关于java.lang.Class类的理解
        1、类的加载过程
        编译：程序经过Javac.exe命后生成一个或多个字节码文件（.class）
        加载运行：通过java.exe命令对某一个字节码文件进行解释运行，将某个
                 字节码文件加载到内存中即为类的加载。加载到内存中的类
                 即为运行时类，此运行类即为Class的一个实例。
                 即类本身作为一个对象。
        万事万物皆对象
        2、Class的实例对应一个运行时类，加载到内存中的运行时类会缓存一定的时间
           此时间段内可以通过不同的方式来获取此运行时类
        3、Class实例的获取：4种方法
        4、Class实例可以是那些类型结构：
        外部类、内部类、匿名内部类
        接口、注解、枚举类、void、基本数据类型、数组、Class本身
        数组：只要数组的类型和维度相同则为同一Class，与数组长度无关

         */
    }
    @Test
    public void test3() throws ClassNotFoundException {
        //Class实例的获取：
        //1、通过运行时类的属性
        //编译时写死了，即如果类名失误写错编译时就不通过
        Class class1 = Person.class;
        System.out.println(class1);
        //2、通过运行时类的对象的调用
        Person p=new Person();
        Class class2 = p.getClass();
        System.out.println(class2);
        //3、通过Class的静态方法  用的比较多
        //即使类名错误，编译时也不会出错，运行时才会报错
        //更好体现反射的动态性，即运行时的动态性
        Class class3= Class.forName("com.Hewang.java.Person");
        System.out.println(class3);
        System.out.println(class1==class2);
        System.out.println(class1==class3);
        //4、通过类的加载器（了解即可）
        ClassLoader classLoader = JavaReflectionInfo.class.getClassLoader();
        Class class4 = classLoader.loadClass("com.Hewang.java.Person");
        System.out.println(class4);
        System.out.println(class1==class4);
    }
    //读取配置文件的方式
    @Test
    public void test4() throws Exception {
        Properties pros = new Properties();
        //读取配置文件的方式一：
        //配置文件默认在module下检索
        FileInputStream fis=new FileInputStream("jdbc.properties");
        pros.load(fis);
        //读取配置文件的方式二：
        //配置文件默认在module中src下检索
//        ClassLoader classLoader = JavaReflectionInfo.class.getClassLoader();
//        InputStream resourceAsStream = classLoader.getResourceAsStream("jdbc.properties");
//        pros.load(resourceAsStream);

        String name = pros.getProperty("name");
        String password = pros.getProperty("password");
        System.out.println("user="+name+",password="+password);


    }
}
