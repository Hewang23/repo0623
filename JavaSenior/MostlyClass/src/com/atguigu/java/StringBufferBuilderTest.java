package com.atguigu.java;

import org.junit.Test;

/**
 * @author Hewang
 * @create 2020-04-28 17:18
 * @title 关于两个新类的使用
 */
public class StringBufferBuilderTest {
    /*
    三者的异同：
    都是使用char[]作为底层存储
    String：不可变
    StringBuffer：可变，JDK1.0 线程安全的效率偏低（多线程问题，存在线程安全问题）
    StringBuilder：可变，JDK1.5 非线程安全的效率高（不存在线程安全问题）
    源码分析
    问题一：
    问题二：

     */
    /*
    StringBuffer的常用方法：
    总结：
    增append
    删delete
    改replace、setCharAt
    查charAt
    插insert
    长度length
     */
    /*
    效率来看StringBuilder>StringBuffer>String
     */
    @Test
    public void test2(){
        StringBuffer s1=new StringBuffer("aaaa");//16字符的空间
        s1.append('s');
        s1.append("sss");
//        s1.delete(1,4);//左闭右开
//        s1.replace(1,3,"kk");
//        s1.insert(2,false);
        s1.reverse();//String做不到
        String s2 = s1.substring(1, 3);
        System.out.println(s1);
//        System.out.println(s1.length());

    }
    @Test
    public void test1(){
        String s1=new String();
        //可变
        StringBuffer sb1=new StringBuffer("abc");
        sb1.setCharAt(0,'v');
        System.out.println(sb1);

    }


}
