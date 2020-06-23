package com.atguigu.java;

/**
 * @author Hewang
 * @create 2020-05-04 18:21
 * @title Java集合框架概述
 * A、Java容器：集合、数组都是对多个数据进行存储操作的结构
 *    此时的存储主要为内存层面的存储，不涉及到持久化的存储（.txt,.jpg，etc）
 *
 * 引出：对多个对象的操作中通过数组实现的特点和弊端：
 * 特点：
 *  >数组初始化后长度固定
 *  >数组的元素类型随着数组的定义确定，只能操作指定类型或其子类的数据
 * 弊端：
 *  >初始化后长度不可修改
 *  >数组中提供的方法有限，对于删除、插入等操作非常不便
 *  >获取数组中实际元素的个数的需求，无属性和方法可用
 *  >数组中数据存储满足有序、可重复性对于无序、不可重复的需求不能满足
 * B、Java集合可分为Collection和Map两种体系
 *  >Collection接口：单列数据，定义了存储一组对象的方法的集合
 *      >List：元素有序、可重复的集合--->"动态"数组
 *          >ArrayList、LinkedList、Vector
 *      >Set：元素无序、不可重复的集合--->高中的集合
 *          >HahSet、LinkedHashSet、TreeSet
 *  >Map接口：双列数据，存储具有映射关系的集合<key-value>--->高中函数
 *          >HashMap、LinkedHashMap、TreeMap、Hashtable、Properties
 * 面试题：底层描述
 *
 * C、Collection接口中的API中方法的使用
 *
 */
public class ListInfo {

}
