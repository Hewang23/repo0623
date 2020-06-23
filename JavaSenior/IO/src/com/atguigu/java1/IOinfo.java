package com.atguigu.java1;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Hewang
 * @create 2020-05-11 18:16
 * @title IO流（数据流）
 * 1、IO是相对的概念，在内存和硬盘（网络）中，立足内存来看；
 * 2、流的分类：
 *      ->流的角色：        节点流       处理流
 *      ->数据单位：        字节流       字符流
 *         （8bit 例如：图片、视频）（16bit 例如：文本数据）
 *      ->数据流向：输入流  InputStream  Reader
 *                 输出流 OutputStream  Writer
 * 基于以上四个抽象基类的子类：
 * 实际上对于文件的操作即读取和写入都是通过read和write，缓冲输入字符流中有对字符串的读取操作
 * 节点流：访问文件的4个流(文件流)
 * FileInputStream|FileOutputStream|FileReader|FileWriter
 * 处理流：缓冲流、
 * 缓冲流: BufferedInputStream|BufferedOutputStream|BufferedReader|BufferedWriter
 *        涉及到装饰设计模式
 * 转换流：
 */
public class IOinfo {
    //main方法中相对路径为相对工程
    //test方法中相对路径为Module
    /*
    异常的处理：
    1、不采用throws的方法，一旦抛出异常则后续程序不会执行
       即可能不会执行关闭流的操作，会造成资源泄露
    2、通过try-catch处理
    3、读入的文件一定要存在，否则会存在异常
     */
    @Test
    public void test1() {
        FileReader fr= null;
        try {
            //1、实例化File类的对象，指明要操作的文件
            File file=new File("hello.txt");
            //2、提供具体的流
            fr = new FileReader(file);
            //3、数据的读入
            int read = 0;//返回读入的字符，如果达到文件末尾返回-1
            read = fr.read();
            while(read!=-1){
                System.out.print((char)read+" ");
                read=fr.read();//每次只能读取一个字符
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //4、流的关闭
            try {
                if(fr!=null)
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /*
    从内容中读取和写入操作实现和硬盘的交互
    1、输出操作中对应的File可以不才存在且不会报异常
    2、通过重载构造器中的append参数，若无该参数构造器则默认为false
       若文件不存在则自动创建
       若文件存在且append为true则在原有的文件内容中添加
       若文件存在且append为false则覆盖原文件
    3、进行读取文件操作时则必须在硬盘中存在该文件
     */
    @Test
    public void test2(){
        FileReader fr=null;
        FileWriter fw=null;
        try{
            File file=new File("hello.txt");
            File file1=new File("ho.txt");
            fr=new FileReader(file);
            fw=new FileWriter(file1);
            char[] chars=new char[5];
            int readLen = 0;
            while((readLen=fr.read(chars))!=-1){
//            for(int i=0;i<readLen;i++){
//                System.out.println(chars[i]);
//            }
                String str=new String(chars,0,readLen);
//                System.out.println(str);
                fw.write(str);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //实现文件的复制
    @Test
    public void test3()  {
        FileReader fr= null;
        FileWriter fw= null;
        try {
            File file=new File("hello.txt");
            File file1=new File("hello1.txt");
            fr = new FileReader(file);
            fw = new FileWriter(file1);
            char[] chars=new char[5];
            int readLen;
            while((readLen=fr.read(chars))!=-1){
//                String str=new String(chars,0,readLen);
//                fw.write(str);
                fw.write(chars,0,readLen);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //try-catch实现了异常的处理
            //即会执行后续的程序
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
