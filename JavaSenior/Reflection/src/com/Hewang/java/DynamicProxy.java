package com.Hewang.java;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Hewang
 * @create 2020-05-17 15:05
 * @title  反射的应用：动态代理
 * 代理模式：通过代理将对象包装，然后通过该代理对象取代原始对象；
 *          任何对原始对象的调用都通过代理，代理对象决定是否以及何时将方法调用
 *          准到原始对象上。
 * 代理类和被代理类实现的为同一套接口
 * 之前提到的为静态代理，即代理类和被代理类都是在编译期间确定，不利于程序扩展
 * 同时每一个代理类只能为一个接口服务，即实现某特定功能
 * 程序开发中往往需要实现一个被代理类有多个代理实现功能，会占用过多资源且繁琐
 * 因此提出一个代理类实现全部的代理功能，即需要在编译期间不能确定实现的接口
 * 需要在运行时根据提供的被代理类动态的根据需求的接口创建代理类，即为动态代理
 *
 * 通用即灵活。
 */

//1、拟定一个定义需要实现的接口
interface Human{
    String getBelif();
    void eat(String food);
}
//2、拟定一个被代理类
class SuperMan implements Human{
    @Override
    public String getBelif() {
        return "I believe I can fly";

    }

    @Override
    public void eat(String food) {
        System.out.println("My favourite food is:"+food);
    }
}
//3、拟定通用的代理类
/*
要想实现动态代理需要解决的问题为：
问题一：如何根据加载到内存中的被代理类，动态地创建一个被代理类及其对象
问题二：当通过代理类的对象调用方法时如何动态地调用被代理类中地同名方法
 */
class ProxyFactory{
    //问题一的解决，通过一个静态方法返回一个代理类的对象
    public Object getProxyInstance(Object obj){
        MyInvocationHandler mih=new MyInvocationHandler();
        mih.bind(obj);
        //返回代理实例，该代理通过被代理类的类加载器加载，并继承了被代理类实现的所有接口
        //并且通过调用返回实例的方法可以进而调用被代理的方法，该部分由InvocationHandler实现
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),mih);
    }


}
class MyInvocationHandler implements InvocationHandler{
    private Object obj;
    public void bind(Object o){
        this.obj=o;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //method:代理类对象调用的方法，组为被代理类对象要调用的方法
        //obj:被代理类的对象
        Object invoke = method.invoke(obj, args);
        //上述方法的返回值即作为当前类中的返回值
        return invoke;
    }
}
public class DynamicProxy {
    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        ProxyFactory proxyFactory=new ProxyFactory();
        Human proxyInstance = (Human) proxyFactory.getProxyInstance(superMan);
        //调用方法自动调用被代理类中同名的方法
        System.out.println(proxyInstance.getBelif());

    }

}
