package com.atguigu.java;

import org.junit.Test;

/**
 * @author Hewang
 * @create 2020-04-28 14:44
 * @title String常用方法  大小写严格区分
 */
public class StringMethodTest {
    @Test
    public void test4(){
        String s1="belaydebug";
        String s2=s1.replace('e','o');
        String s3=s1.replace("belay","o");
        System.out.println(s2);
        System.out.println(s3);
        String s4="12belay23debug65hahaha";
        String s5=s4.replaceAll("\\d+",",").replaceAll("^,|,$","");
        String s6=s4.replaceFirst("\\d+",",");
        System.out.println(s5);
        System.out.println(s6);
        s4="12325654";
        boolean mathes=s4.matches("\\d+");
        System.out.println(mathes);
        String mobileNumber="0571-4568792";
        boolean isIilegall=mobileNumber.matches("0571-\\d{7,8}");
        System.out.println(isIilegall);
        String str="belay|debug|hahaha";
        String[] str1=str.split("\\|");
        for(int i=0;i<str1.length;i++){
            System.out.print(str1[i]+"\t");
        }
    }
    @Test
    public void test3(){
        String s1="belaydebug";
        System.out.println(s1.endsWith("bug"));
        System.out.println(s1.startsWith("bel"));
        System.out.println(s1.startsWith("lay"));
        System.out.println(s1.startsWith("lay", 2));
        String s2="ayd";
        System.out.println(s1.contains(s2));
        System.out.println(s1.indexOf(s2));
        //可用于查找该部分出现次数，通过该方法的返回值+长度作为循环的输入
        System.out.println(s1.indexOf(s2, 2));
        String s3="belaydebugay";
        System.out.println(s3.lastIndexOf("ay"));
        System.out.println(s3.lastIndexOf("ay", 9));
    }
    @Test
    public void test2(){
        String s1="Heal The World";
        String s2="    heal the world";
        System.out.println(s1.equalsIgnoreCase(s2.trim()));
        String s3="abc";
        String s4="abd";
        System.out.println(s3.compareTo(s4));//涉及到字符串排序
        String s5="北京科技大学";
        String s6=s5.substring(2);
        String s7=s5.substring(2,4);//左闭右开
        System.out.println(s5);
        System.out.println(s6);
        System.out.println(s7);
    }
    @Test
    public void test1(){
        String s1="hello";
        System.out.println(s1.length());
        System.out.println(s1.charAt(1));//因为底层数组为private不能直接调用
        System.out.println(s1.isEmpty());
        String s2=s1.toUpperCase();
        System.out.println(s1);//s1不变
        System.out.println(s2);
        String s3="  some thing   ";
        String s4=s3.trim();
        System.out.println(s3);
        System.out.println(s4);
    }
}
