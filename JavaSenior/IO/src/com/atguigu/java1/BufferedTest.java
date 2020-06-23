package com.atguigu.java1;

import org.junit.Test;

import java.io.*;

/**
 * @author Hewang
 * @create 2020-05-13 21:50
 * @title 缓冲流（处理流的一种）对节点流的包装
 * 1、
 * BufferedInputStream
 * BufferedOutputStream
 * BufferedReader
 * BufferedWriter
 * 2、
 * 提高流的读取、写入的效率
 * 原因：内部提供了缓冲区
 */
public class BufferedTest {
    @Test
    public void test1(){
        FileInputStream fis= null;
        FileOutputStream fos= null;
        BufferedInputStream bis=null;
        BufferedOutputStream bos=null;
        try {
            File srcFile=new File("download.jpg");
            File desFile=new File("download1.jpg");
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(desFile);
            bis=new BufferedInputStream(fis);
            bos=new BufferedOutputStream(fos);
            byte[] bytes=new byte[5];
            int readLen;
            while((readLen=bis.read(bytes))!=-1){
                 bos.write(bytes,0,readLen);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流时先关闭缓冲流再关闭节点流
            //关闭缓冲流时自动管子节点流
            //因此关闭节点流的操作可以省略
            if(bis!=null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bos!=null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //实现文件复制的方法
    public void copyFileWithBuffer(String srcPath,String destPath){
        FileInputStream fis= null;
        FileOutputStream fos= null;
        BufferedInputStream bis=null;
        BufferedOutputStream bos=null;
        try {
            File srcFile=new File(srcPath);
            File desFile=new File(destPath);
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(desFile);
            bis=new BufferedInputStream(fis);
            bos=new BufferedOutputStream(fos);
            byte[] bytes=new byte[1024];
            int readLen;
            while((readLen=bis.read(bytes))!=-1){
                bos.write(bytes,0,readLen);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流时先关闭缓冲流再关闭节点流
            //关闭缓冲流时自动管子节点流
            //因此关闭节点流的操作可以省略
            if(bis!=null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bos!=null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void test3(){
        long start=System.currentTimeMillis();
        String src="F:\\Users\\Administrator\\Desktop\\爱情公寓1.mp4";
        String dest="F:\\Users\\Administrator\\Desktop\\爱情公寓3.mp4";
        copyFileWithBuffer(src,dest);
        long end=System.currentTimeMillis();
        System.out.println("本次复制需要的时间为："+(end - start));
    }
}
