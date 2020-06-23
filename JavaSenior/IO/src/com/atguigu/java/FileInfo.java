package com.atguigu.java;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @author Hewang
 * @create 2020-05-11 15:40
 * @title  File类的使用
 * 1、File类的一个对象代表一个文件或者一个文件目录
 * 2、File类声明在java.io包下
 * 3、路径分隔符
 * 4、涉及到文件或文件目录的创建、删除、重命名、修改时间、文件大小
 * 5、没有涉及到写入和读取操作，需要通过IO流实现
 * 6、File类的对象作为参数传入流的构造器中，指明读取或写入的终点
 */
public class FileInfo {
    /*
        3种构造方式
     */
    @Test
    public void test1(){
        // 通过文件或文件目录的路径 String类型（相对路径、绝对路径）
        File file=new File("hello.txt");//相对于module的路径

        File file1=new File("D:\\workspaceidea\\JavaSenior\\IO\\he.txt");//绝对路径
        System.out.println(file);
        System.out.println(file1);

        File file2=new File("D:\\workspaceidea","JavaSenior");

        File file3=new File(file2,"hi.txt");
    }
    //File类本身具有的功能
    @Test
    public void test2(){
        File file=new File("hello.txt");//相对于module的路径
        File file1=new File("D:\\IO\\he.txt");//绝对路径
        System.out.println(file.getAbsoluteFile());
        System.out.println(file1.getAbsoluteFile());
        System.out.println(file.getPath());
        System.out.println(file.getName());
        System.out.println(file.getParent());
        System.out.println(file.length());
        System.out.println(new Date(file.lastModified()));
    }

    //适用于文件目录的方法
    @Test
    public void test3(){
        File file=new File("D:\\workspaceidea\\JavaSenior");
        String[] list = file.list();
        for(String str:list){
            System.out.println(str);
        }
        File[] files = file.listFiles();
        for(File fil:files){
            System.out.println(fil);//绝对路径形式
        }
        //重命名  file1.renameTo(files)
        //若返回true，需要file1存在内盘中，file2不能存在内盘中
        File file1=new File("hello.txt");
        File file2=new File("D:\\IO\\hi.txt");
        boolean renameTo = file1.renameTo(file2);
    }
    //有关判断的功能
    @Test
    public void teest4(){
        File file=new File("hello.txt");
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println(file.exists());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.isHidden());
    }
    //硬盘中文件的创建和删除
    @Test
    public void test5() throws IOException {
        File file=new File("hi.txt");
        if(!file.exists()){
            boolean newFile = file.createNewFile();
            System.out.println("创建成功");
        }else{
            file.delete();
            System.out.println("删除成功");
        }
        File file1=new File("D:\\IO\\test");
        boolean mkdir = file1.mkdir();
        if(mkdir){
            System.out.println("创建成功");
        }
        File file2=new File("D:\\IO\\java\\info");
        boolean mkdirs = file2.mkdirs();
        if(mkdirs){
            System.out.println("创建成功");
        }
        //文件目录删除成功的前提为内部无文件以及子目录
        System.out.println(file2.delete());
    }




}
