package com.atguigu.java;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author Hewang
 * @create 2020-05-11 17:31
 * @title 小测验
 */
public class FileDemo {
    @Test
    public void test() throws IOException {
        File file=new File("D:\\IO\\test\\hi.txt");
        boolean newFile = file.createNewFile();
        File file1=new File(file.getParent(),"ha.txt");
        boolean newFile1 = file1.createNewFile();
    }
    //是否有后缀为.jpg的文件
    @Test
    public void test1(){
        File file =new File("F:\\Users\\Administrator\\Desktop\\英语作业");
        String[] list = file.list();
        for(String str:list){
            System.out.println(str);
            if(str.endsWith(".docx")){
                System.out.println(str);
            }
        }
    }
}
