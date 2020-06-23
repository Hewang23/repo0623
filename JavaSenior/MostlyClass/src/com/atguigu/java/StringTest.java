package com.atguigu.java;

/**
 * @author Hewang
 * @create 2020-04-27 0:32
 * @title String的使用
 */
public class StringTest {
    /*
    String
    1、声明为final即不可被继承
    2、实现了几个接口
    3、String内部定义了final char[] value 用于存储字符传数据
    4、不可变特性
    5、通过字面量的方式渎职，次啊是字符串声明在字符串常量池中
    6、常量池中不会存储相同内容的字符串的

     */
    /*
    结论：
    1、常量与常量的拼接结果在常量池，且在常量池中不存在相同的内容
    2、只要其中有一个是变量，结果就在堆中
    3、若调用intern()方法则返回常量池中地址
     */
   String str=new String("good");
   char[] ch={'t','e','s','t'};
   public void change(String str,char[] ch){
       str="sssss";
       ch[0]='i';
   }

    public static void main(String[] args) {
        StringTest test=new StringTest();
        test.change(test.str,test.ch);
        System.out.println(test.str);
        System.out.println(test.ch);
    }
}
