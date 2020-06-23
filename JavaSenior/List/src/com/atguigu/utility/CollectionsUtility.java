package com.atguigu.utility;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Hewang
 * @create 2020-05-07 0:21
 * @title Collections工具类  用于操作Set、List和Map等集合的工具类
 * 工具类中的方法和类中定义的方法不同
 */
public class CollectionsUtility {
    @Test
    public void test1(){
        //排序操作相关  和Set无关
        List list = new ArrayList();
        list.add(75);
        list.add(123);
        list.add(56);
        list.add(98);
        System.out.println(list);
//        Collections.reverse(list);//反转
//        Collections.shuffle(list);//随机
//        Collections.sort(list);//可自然可定制排序
//        Collections.swap(list,0,2);//交换两索引位置的元素
//        Collections.frequency(list,56);//某元素出现的频率
        List list1= Arrays.asList(new Object[list.size()]);

        Collections.copy(list1,list);//后者为供体，前者为受体
        System.out.println(list1);
    }
    //线程安全方法
}
