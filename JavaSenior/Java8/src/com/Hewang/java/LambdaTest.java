package com.Hewang.java;


import org.junit.Test;

import java.util.Comparator;

/**
 * @author Hewang
 * @create 2020-05-17 16:30
 * @title Lambda表达式的使用举例
 * Comparator<Integer> com1= (o1,o2)->Integer.compare(o1,o2);
 * ->：ambda的操作符L
 * (o1,o2)：接口中的抽象方法的形参列表
 * Integer.compare(o1,o2)：重写抽象方法的方法体
 * Lambda表达式的使用：
 *  1、无参无返回值
 */
public class LambdaTest {
    @Test
    public void test1(){
        Comparator<Integer> com=new Comparator<Integer>() {
            @Override
            public int compare(Integer o1,Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        int comp=com.compare(12,23);
        System.out.println(comp);
        System.out.println("***************************");
        //通过Lambda表达式实现
        Comparator<Integer> com1= (o1,o2)->Integer.compare(o1,o2);
        int comp1=com.compare(12,23);
        System.out.println(comp1);
        System.out.println("***************************");
        //通过方法的引用实现
        Comparator<Integer> com2= Integer::compare;
        int comp2=com.compare(12,23);
        System.out.println(comp2);


    }
}
