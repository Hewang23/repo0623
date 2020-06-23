package com.atguigu.java;

import org.junit.Test;

import java.util.*;

/**
 * @author Hewang
 * @create 2020-05-04 20:02
 * @title Collections接口中方法的使用
 * equals()方法重写的必要性
 *
 */
public class CollectionsTest {
    @Test
    public void test1(){
        Collection coll=new ArrayList();
        //add(Object obj)
        coll.add("AA");
        coll.add(123);//自动装箱成为包装类
        coll.add(new Date());
        coll.add(new String("Tom"));
        //size()
        System.out.println(coll.size());
        //addAll()
        Collection coll1=new ArrayList();
        coll1.add(56);
        coll1.addAll(coll);
        System.out.println(coll1.size());
        System.out.println(coll1);
        //clear()
//        coll.clear();
        System.out.println(coll);
        //isEmpty()
        System.out.println(coll.isEmpty());//清空不是置为null只是清空元素
        System.out.println(coll1.isEmpty());
        //contains(Object obj)
        System.out.println(coll.contains("AA"));//ture
        //通过equals比较，按照添加顺序依次比较
        System.out.println(coll.contains(new String("Tom")));
        //如果为自定义类的话则为false因为默认equals方法调用的为==
        //需要重写equals，String类中已进行重写
        //containsAll()
        boolean containsAll = coll1.containsAll(coll);
        System.out.println(containsAll);
    }
    @Test
    public void test2(){
        Collection coll=new ArrayList();
        //add(Object obj)
        coll.add("AA");
        coll.add(123);//自动装箱成为包装类
        coll.add(new Date());
        coll.add(new String("Tom"));
        //remove()从当前集合中移除obj元素，返回值为boolean类型
        boolean aa = coll.remove("AA");
        //先通过equals比较找到要移除的元素
        System.out.println(aa);
        System.out.println(coll);
        System.out.println(coll.remove(new String("Tom")));
        //removeAll()求差集
        Collection coll1= Arrays.asList(1234,"AA");
        coll.removeAll(coll1);
        System.out.println(coll);
        //retrainAll()求交集
        Collection coll2=Arrays.asList(123,"AA",56);
        coll.retainAll(coll2);
        System.out.println(coll);
    }
    @Test
    public void test3(){
        Collection coll=new ArrayList();
        //add(Object obj)
        coll.add("AA");
        coll.add(123);//自动装箱成为包装类
        coll.add(new Date());
        coll.add(new String("Tom"));

        Collection coll1=new ArrayList();
        //add(Object obj)
        coll1.add(123);//自动装箱成为包装类
        coll1.add("AA");
        coll1.add(new Date());
        coll1.add(new String("Tom"));
        //equals(Object obj) 当前集合和形参集合元素是否相同
        //因为该集合为有序类型因此如果更改元素顺序则两集合不相等
        System.out.println(coll.equals(coll1));
        //hashCode() 返回当前对象的hash值
        System.out.println(coll.hashCode());
        //toArray()
//        Object[] objects = coll.toArray();
//        for(int i=0;i<objects.length;i++){
//            System.out.println(objects[i]);
//        }
        //扩展：数组转换为集合
        List<String> arr = Arrays.asList(new String[]{"AA", "BB", "CC"});
        System.out.println(arr);
        List arr1 = Arrays.asList(new int[]{123,456});
        System.out.println(arr1.size());//1
        List arr2 = Arrays.asList(new Integer[]{123,456});
        System.out.println(arr2.size());//2
        //iterator()返回Iterator接口的实例  用于遍历集合元素
        Iterator iterator = coll.iterator();
        //方式一：
        for(int i=0;i<coll.size();i++){
            System.out.println(iterator.next());
        }
        //方式二：推荐方法
        //实例化对象后，可假设为存在指针指向集合第一个元素的前一个位置
        while(iterator.hasNext()){
            //调用next()方法时候，指针下移
            System.out.println(iterator.next());
        }
    }
    //测试迭代器的remove()
    @Test
    public void test4(){
        Collection coll=new ArrayList();
        //add(Object obj)
        coll.add("AA");
        coll.add(123);//自动装箱成为包装类
        coll.add(new Date());
        coll.add(new String("Tom"));
        System.out.println(coll);
        //remove()可以在遍历的时候删除集合中的元素  即需要搭配遍历实现
        Iterator iterator = coll.iterator();
        while(iterator.hasNext()){
            Object next = iterator.next();
            if("Tom".equals(next)){
                iterator.remove();
            }
        }
        System.out.println(coll);

    }
}
