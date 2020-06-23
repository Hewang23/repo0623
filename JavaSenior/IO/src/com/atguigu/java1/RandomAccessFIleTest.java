package com.atguigu.java1;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author Hewang
 * @create 2020-05-15 15:33
 * @title 随机存取文件流
 * 1、声明在io包下，继承于Object类；实现了DataInput和DataOutput接口
 * 2、既可以作为一个输入流也可以做一个输出流
 * 3、如果作为输出流，写出到的文件不存在，则自动创建
 *    若存在，则从开始覆盖要写入的内容（默认）可以通过seek方法改变覆盖的位置、
 *    通过seek()取文件长度可以实现文件内容的添加
 *
 *    若要实现文件内容的插入则需要：
 *
 */
public class RandomAccessFIleTest {
    @Test
    public void test2() throws IOException {
        //实现文件数据的插入
        RandomAccessFile raf=new RandomAccessFile(new File("hello.txt"),"rw");
        raf.seek(3);
        byte[] readContent=new byte[20];
        StringBuilder builder=new StringBuilder((int) new File("hello.txt").length());
        int len;
        while ((len=raf.read(readContent))!=-1){
            builder.append(new String(readContent,0,len));
        }
        raf.seek(3);
        raf.write("qwer".getBytes());
        raf.write(builder.toString().getBytes());
        raf.close();
    }
    @Test
    public void test1(){
        RandomAccessFile raf1= null;
        RandomAccessFile raf2= null;
        try {
            raf1 = new RandomAccessFile(new File("download.jpg"),"r");
            raf2 = new RandomAccessFile(new File("download2.jpg"),"rw");

            byte[] buffer=new byte[1024];
            int len;
            while ((len=raf1.read(buffer))!=-1){
                raf2.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(raf1!=null){

                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(raf2!=null){

                try {
                    raf2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
