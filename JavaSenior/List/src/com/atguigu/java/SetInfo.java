package com.atguigu.java;

import org.junit.Test;

import java.util.*;

/**
 * @author Hewang
 * @create 2020-05-06 10:53
 * @title
 * >Set：元素无序、不可重复的集合--->高中的集合
 *     >HahSet:Set接口的主要实现类，线程不安全，可以存储null值
 *      >LinkedHashSet:HashSet的子类，遍历器内部数据是可以顺序遍历
 *     >TreeSet:可以按照添加对象的属性进行排序，因此对象需一致
 *
 *
 */
public class SetInfo {
    /*
    Set：无序和不可重复
    接口中没有定义额外的方法，使用的为实现接口中定义的方法
要求：
    向Set中添加的数据，其所在的类一定要重写hashCode()方法和equals()方法
    重写的两个方法尽可能保持一致性，相等的对象必须有相等的散列码

    1、无序：不为随机性，指相较于List中添加元素时按照索引依次添加
            Set中添加元素时为随机添加，没有索引的概念，按照数据的hash值添加
            因此重复数据不会重复出现
    2、不可重复：保证添加的元素按照equals方法判断时不能返回true，相同的元素
                只能添加一个。（过滤重复数据）
    3、添加元素的过程，以HashSet为例：
        HashSet底层为数组，同ArrayList在7-8中的变化
        根据添加元素属性调用hashCode()计算哈希值，
        并通过哈希值计算索引位置
        若后续添加元素所计算索引值已有元素(以链表形式存在的一个或多个元素)，
        则比对哈希值，若哈希值不同，则通过链表添加到该索引
        若哈希值相同，通过equals比对结果为false，则同上

        在已有元素情况下添加成功通过链表添加
        JDK7中为要添加的元素A放入数组中并指向原来的元素
        JDK8中为原来的元素放入数组中并指向要添加的元素A

        Object中的hashCode方法为随机计算，即便为两个相同的对象计算的哈希值
        会不相同，因此需要重载该方法
    4、HashSet底层实际为数组＋链表的结构



     */
    @Test
    public void test1(){
        Set set = new HashSet();
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new Date());
        set.add(456);
        set.add(123);//实际没有添加成功
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());//输出为无序的
        }

    }
    @Test
    public void test2(){
        Set set = new LinkedHashSet();
        //作为HashSet的子类，在添加数据的同时维护了两个引用
        //记录此数据的前一数据和后一数据
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new Date());
        set.add(456);
        set.add(123);//实际没有添加成功
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());//输出为无序的
        }

    }
}
