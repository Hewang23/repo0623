package com.atguigu.java;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @author Hewang
 * @create 2020-04-28 15:47
 * @title String类和其他数据类型的转换
 */
public class StringToSome {
    /*
    关于String声明的内存解析
    常量和常量拼接在常量池实现，涉及到对象在堆空间实现
     */
    @Test
    public void test4(){
        String s1="belaydebug";
        String s2="belay";
        String s3=s2+"debug";
        System.out.println(s1 == s3);//fasle
        final String s4="belay";
        String s5=s4+"debug";
        System.out.println(s1 == s5);//true

    }
    /*
    String和字节数组的转换
    编码：String-->byte[]  字符-->字节 通过getBytes方法
    解码：byte[]-->String  字节-->字符 通过String构造器
    解码使用的字符集需要和编码使用的字符集一致
     */
    @Test
    public void test3() throws UnsupportedEncodingException {
        String s1="abc123北来";
        byte[] bytes = s1.getBytes();//使用默认字符集,中文占用3个字符
        System.out.println(Arrays.toString(bytes));
        byte[] bytes1=s1.getBytes("gbk");
        System.out.println(Arrays.toString(bytes1));
        String str1=new String(bytes);
        String str2=new String(bytes1);//会出现乱码


    }
    /*
    String和char型数组的转换
    String-->char[]
    char[]-->String
     */
    @Test
    public void test2(){
        String s1="belaydebug";
        char[] array = s1.toCharArray();
        System.out.println(array);
        for(int i=0;i<array.length;i++){
            System.out.println(array[i]);
        }
        char[] arr=new char[]{'s','s','r'};
        String str=new String(arr);
    }
    /*
    String和基本数据类型、包装类之间的转换
    String-->基本数据类型、包装类:调用包装类的静态方法
    基本数据类型、包装类-->String:String的valueOf
     */
    @Test
    public void test1(){
        String s1="123";
        int i1=Integer.parseInt(s1);
        int i2=3254;
        String s2=String.valueOf(i2);
        String s3=i2+"";
    }

}
