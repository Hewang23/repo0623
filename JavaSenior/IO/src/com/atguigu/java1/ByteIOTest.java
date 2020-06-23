package com.atguigu.java1;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Hewang
 * @create 2020-05-11 23:54
 * @title 字节流的基本流
 */
public class ByteIOTest {
    /*
    在字符集中ASCII码中一个字母对应的为一个字节即8位  应该为256实际为128
    即一个字节可以存放，a=97 可存取范围为：0-127
    如果是汉字的话则一个字节存放不下，需要三个字节
    结论：
    对于文本文件(.txt,.java,.c,.cpp)适用字符流处理
    对于非文本文件(.jpg,.mp3,.mp4,.avi,.doc,.ppt)适用字节流处理

     */
    @Test
    public void test1()  {
        FileInputStream fis= null;
        try {
            //1、输入文件
            File file1=new File("hello.txt");
            //2、选定流
            fis = new FileInputStream(file1);
            //3、读数据
            byte[] buffer=new byte[5];
            //If the content of this file is english word,
            //there will be run correctly;if it contains chinese,
            //there will be error.Because a english word can been
            //replace by 8 bits,a chinese word will not.
            int len=0;
            while((len=fis.read(buffer))!=-1){
                String str=new String(buffer,0,len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4、关闭流
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    /*
      实现对图片的复制：通过字节流
     */
    @Test
    public void test2()  {
        FileInputStream fis= null;
        FileOutputStream fos= null;
        try {
            File srcFile=new File("download.jpg");
            File desFile=new File("download1.jpg");
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(desFile);
            byte[] bytes=new byte[5];
            int readLen;
            while((readLen=fis.read(bytes))!=-1){
                fos.write(bytes,0,readLen);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //指定路径下文件的复制封装为方法
    public void copyFile(String srcFileName,String desFileName){
        FileInputStream fis= null;
        FileOutputStream fos= null;
        try {
            File srcFile=new File(srcFileName);
            File desFile=new File(desFileName);
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(desFile);
            byte[] bytes=new byte[1024];
            int readLen;
            while((readLen=fis.read(bytes))!=-1){
                fos.write(bytes,0,readLen);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    public void test4(){
        long start=System.currentTimeMillis();
        String srcPath="F:\\Users\\Administrator\\Desktop\\爱情公寓1.mp4";
        String desPath="F:\\Users\\Administrator\\Desktop\\爱情公寓2.mp4";
        copyFile(srcPath,desPath);
        long end=System.currentTimeMillis();
        System.out.println("复制需要的时间为："+(end-start));
    }
}
