package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author Hewang
 * @create 2020-05-05 0:48
 * @title  Collection子接口之一：List
 * 元素有序，且可重复 -->动态数组
 * 集合中的每一个元素都有其对应的顺序索引-->元素有序性
 * 根据序号存取容器中的元素
 * 实现类：ArrayList、LinkedList、Vector
 *  ArrayList：JDK1.2 作为List接口的主要实现类，线程不安全的，效率高；底层为Object[]存储
 *  LinkedList：JDK1.2 对于频繁的插入和删除操作比ArrayList效率高；底层使用的为双向链表存储
 *  Vector：JDK1.0 作为List接口的古老实现类，线程安全的，效率低；底层为Object[]存储
 *  以上三者的异同：
 *  同：均实现类List接口存储数据的特点相同
 *  首先比较ArrayList和Vector的区别然后比较ArrayList和LinkedList的区别
 *  涉及到线程安全问题和底层存储结构问题以及实际扩容问题
 *
 *
 * 源码分析：
 * -->ArrayList：(JDK 8)
 *    从7-8的变化，JDK7中ArrayList对象的创建类似于单例的饿汉式，
 *    JDK8中ArrayList对象的创建类似于懒汉式，延迟了数组的创建，节省内存。
 * -->LinkedList：
 *    双向链表不涉及到扩容
 *方法层面，因为List为有序的可重复的结构，因此除通用方法外还涉及到关于索引操作的方法
 *常用方法：增删改查插长度遍历
 */
public class ListTest {
    @Test
    public void test1(){
        int[] arr=new int[]{};
        System.out.println(arr.length);
    }
    //List接口中的常用方法
    @Test
    public void test2(){
        ArrayList list = new ArrayList();
        //Collections中的方法
        list.add(123);
        list.add("ddd");
        list.add(new Date());
        list.add(new String("AA"));
        System.out.println(list);
        //[123, ddd, Wed May 06 10:36:10 CST 2020, AA]

        list.add(1,"OBJ");
        System.out.println(list);
        //[123, OBJ, ddd, Wed May 06 10:37:08 CST 2020, AA]
        List<Integer> integers = Arrays.asList(123, 66);
    }
    //练习题
    //区分重写的remove方法和Collections中的remove方法
    @Test
    public void test3(){
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);
    }
    private static void updateList(List list){
//        list.remove(2);//不会自动装箱
        list.remove(new Integer(2));

    }
}
