package com.atguigu.java1;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author Hewang
 * @create 2020-05-07 0:11
 * @title  Properties常用来处理配置文件
 */
public class PropertiesTest {
    public static void main(String[] args) throws Exception{
        Properties properties = new Properties();
        FileInputStream fis=new FileInputStream("jdbc.properties");
        properties.load(fis);
        String name = properties.getProperty("name");
        String password = properties.getProperty("password");
        System.out.println(name+"-->"+password);
    }
}
