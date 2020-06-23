package com.atguigu.java1;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hewang
 * @create 2020-05-06 15:03
 * @title  关于Map接口的部分
 * >Map接口：双列数据，存储具有映射关系的集合<key-value>--->高中函数
 * >Map结构：
 *      key：无序的不可重复的，通过set存储 所在类重写equals和hashCode
 *      value：无需的可重复的 所在类重写equals
 *      一个键值对：key-value构成一个Entry对象
 *      Entry对象：无序的不可重复的，通过set存储
 * 实际put的值为key和value结合的entry类的对象，通过set存储
 *     >HashMap：Map的主要实现类，线程不安全，效率高，存储null的key和value
 *     用户没有填，默认为null，健壮性好
 *          >LinkedHashMap：保证在遍历map元素时，按照添加的顺序实现
 *          添加了一对引用指向前一元素和后一元素
 *          对于频繁的遍历操作，执行效率较高
 *     >TreeMap:保证按照添加的key-value实现排序遍历
 *     按照key排序，底层使用红黑树
 *     >Hashtable:Map的古老实现类，线程安全，效率低
 *          >Properties:常用来处理配置文件，key和value都是String类型
 *Map中定义的方法：
 *
 *面试题：
 * 1、HashMap的底层实现原理？
 *   >JDK7：实例化后，底层创建了长度为16的Entry[]
 *          执行过多次添加后，map.put(key1,value1);首先调用key所在类的hashCOde()
 *          计算哈希值，在经过算法后，得到数组中的存放位置，比较哈希值决定是否添加
 *          若存在和该哈希值相同的数据，则通过key所在类的equals方法比较，若相同
 *          则替换掉原来该位置上的元素。
 *    若key的哈希值不同，或者哈希值相同而equals返回false，则和原来的数据以链表的形式存在
 *   涉及扩容：大概超出临界值时且待添加元素位置上不为空，扩容为原来容量的2倍，然后复制数据
 *   >JDK8不同于JDK7的点在于：
 *   实例化底层没有创建长度为16的数组，且数组为Node类型的数组
 *   首次调用put时底层创建数组
 *   7的底层结构为数组+链表
 *   8的底层结构为数组+链表+红黑树
 *   若数组的某一个索引位置上的元素以链表形式存在的数据个数>8且当前数组的长度>64
 *   此时此索引位置上的所有数据改为红黑树存储。
 *  LinkedHashMap:
 *
 *
 * 2、HashMap和Hashtable的异同？
 * */
public class MapInfo {
    //Map中定义的方法
    @Test
    public void test1(){
        Map map=new HashMap();
        map.put("AA",123);
        map.put("AD",13);
        map.put("DA",113);
        map.put("DD",173);
        map.put("DD",133);

        Map map1=new HashMap();
        map1.put("EE",123);
        map.putAll(map1);
        System.out.println(map);
    }
    //查询操作
    @Test
    public void test2(){
        Map map=new HashMap();
        map.put("AA",123);
        map.put("AD",13);
        map.put("DA",113);
        map.put("DD",173);
        map.put("DD",133);
        System.out.println(map.get("DA"));
        boolean ad = map.containsKey("AD");
        boolean b = map.containsValue(173);

    }
    //遍历操作
    //因为Map中没有iterator，因此需要通过生成Collections实现类调用
    @Test
    public void test3(){
        //keySet()
        //values()
        //entrySet()   keySet()+Map.get(Object key)
    }
}
