package com.atguigu.java1;

import org.junit.Test;

import java.io.*;

/**
 * @author Hewang
 * @create 2020-05-15 12:40
 * @title 处理流之对象流
 * 实现存储和读取基本数据类型和对象的处理流
 * 将Java对象写入数据源中，并还原
 * 序列化：用ObjectOutputStream类保存基本数据类型或对象的机制
 * 反序列化：用ObjectInputStream类读取基本数据类型或对象的机制
 *
 * 不能序列化static和transient修饰的成员变量
 *
 * 使一个Java对象为可序列化的需要满足：
 *
 *
 */
public class ObjectStreamTest {
    /*
    序列化过程：将内存中的Java对象保存到磁盘中或者通过网络传输出去

     */
    @Test
    public void test(){
        ObjectOutputStream oos= null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("Object.dat"));
            oos.writeObject(new String("dadadada"));
            oos.flush();
            oos.writeObject(new Person("belay",23));
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
            } catch (IOException e) {
                if(oos!=null){
                    e.printStackTrace();
                }
            }
        }
    }
    //反序列化过程：将磁盘文件中的对象还原为内存中的Java对象
    @Test
    public void test1(){
        ObjectInputStream ois= null;
        try {
            ois = new ObjectInputStream(new FileInputStream("Object.dat"));
            //按顺序读取
            Object o = ois.readObject();
            String str=(String)o;
            Object o1 = ois.readObject();
            Person p1=(Person)o1;
            System.out.println(str);
            System.out.println(p1);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
