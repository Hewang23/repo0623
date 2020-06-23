package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * @author Hewang
 * @create 2020-05-05 0:36
 * @title 增强for循环用于遍历Collection和数组结构
 */
public class ForTest {
    @Test
    public void test1(){
        Collection coll=new ArrayList();
        //add(Object obj)
        coll.add("AA");
        coll.add(123);//自动装箱成为包装类
        coll.add(new Date());
        coll.add(new String("Tom"));

        //for(集合中的数据类型 数据:集合对象)
        //内部仍为调用迭代器
        for(Object obj:coll){
            System.out.println(obj);
        }
    }
    @Test
    public void test2(){
        //通过for实现数组的遍历
        int[] arr=new int[]{1,2,6,5,8,4};
        for(int i:arr){
            System.out.println(i);
        }
    }
    @Test
    public void test3(){
        String[] arr=new String[]{"AA","AA","AA"};
        //方式一：
        for(int i=0;i<arr.length;i++){
            arr[i]="BB";
        }
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
        String[] arr1=new String[]{"AA","AA","AA"};
        //方式二：
        for(String str:arr1){
            str="BB";
        }
        for(String str:arr1){
            System.out.println(str);
        }


    }
}
