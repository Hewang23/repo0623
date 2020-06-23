package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hewang
 * @create 2020-05-11 13:39
 * @title
 * 1、泛型在继承方面的体现
 * 2、通配符的使用
 *
 */
public class GenericTest {
    //泛型在继承方面的体现
    /*
    1、类A是类B的父类；G<A>和G<B>为并列关系不为子父类关系，编译不通过
       反证法：
     */
    @Test
    public void test1(){
        Object obj=null;
        String str=null;
        obj=str;
        List<Object> list1=null;
        List<String> list2=null;
//        list1=list2; 不具有子父类关系


    }
    //通配符的使用（对于上述问题的解决方案）  通配符：？
    /*
    A是类B的父类；G<A>和G<B>为并列关系不为子父类关系；
    二者共同的父类为：G<?>
     */
    @Test
    public void test2(){
        List<Object> list1=null;
        List<String> list2=null;
        List<?> list=null;
        list=list1;
        list=list2;
        List<String> list3=new ArrayList<>();
        list3.add("AA");
        //对于List<?>不能再向其内部添加除null以外的数据
//        list.add();
        list.add(null);
        //读取的数据类型为Object
        Object o = list.get(0);
    }
    //有限制条件的通配符的使用
    /*
    <? extends A>  上限为A
    <? super B>    下限为B
    读取数据的规则相应变化
    添加数据要考虑多态的性质
     */
}
