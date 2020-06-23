package com.atguigu.java1;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Hewang
 * @create 2020-04-30 16:46
 * @title Java中对象的排序操作
 * 通过两个接口：Comparable或Comparator
 * Comparable接口的使用
 * 1、像String、包装类等实现了Comparable接口，重写了compareTo()方法
 *    实现两个对象比较的方式
 * 2、重写的规则：正整数、负整数和零
 * 3、重写的方法以后一般为从小到大的排序
 * 4、对于自定义类需要比较需要实现接口：
 * 4.1 自然排序（Comparable）
 * 4.2 定制排序（Comparator）
 *     当元素的类型没有实现comparable接口又不方便修改代码
 *     实现了接口后不适合当前类型的排序
 *     重写compare方法，包含两个参数
 * 4.3 自然排序适合一次实现，长期使用
 *     定制排序适合临时实现，临时使用
 *     
 *
 */
public class compareTest {
    @Test
    public void test1(){
        String[] arr={"AA","BB"};
        int i = arr[0].compareTo(arr[1]);
        System.out.println(i);
        String[] array={"AA","DD","FF","CC,","BB"};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }
    @Test
    public void test2(){
        Goods[] goods=new Goods[5];
        goods[0]=new Goods("huawei",8000);
        goods[1]=new Goods("xiaomi",7500);
        goods[2]=new Goods("leishen",7900);
        goods[3]=new Goods("hongji",10000);
        goods[4]=new Goods("jixieren",10000);
        Arrays.sort(goods);
        System.out.println(Arrays.toString(goods));

    }
    @Test
    public void test3(){
        String[] str={"AA","DD","CC","BB","EE"};
        Arrays.sort(str, new Comparator(){

                    @Override
                    public int compare(Object o1, Object o2) {
                        if(o1 instanceof String &&o2 instanceof String){
                            String str1= (String) o1;
                            String str2= (String) o2;
                            return -str1.compareTo(str2);
                        }
                        throw new RuntimeException("传入数据类型不一致");
                    }
                }
        );
    }
}
