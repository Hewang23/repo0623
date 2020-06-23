package com.atguigu.java1;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Hewang
 * @create 2020-04-28 18:33
 * @title JDK8之前的日期API测试
 * 1
 */
public class TimeAPI {
    //1 System类中的方法
    @Test
    public void test1(){
        //返回当前时间与1970年1月1日0时0分0秒间以毫秒为单位的时间差
        long time1=System.currentTimeMillis();
        System.out.println(time1);
    }
    //2.1 java.util.Date类
    /*
    1、两个构造器的使用
    2、两个方法的使用
       >toString()显示当前的具体时间
       >获取毫秒数
     */
    @Test
    public void test2(){
        Date date1 = new Date();//创建对应当前时间的Date对象
        System.out.println(date1.toString());
        System.out.println(date1.getTime());
        Date date2 = new Date(1588070472180L);//创建指定毫秒数的对象
        System.out.println(date2);
    }
    //2.2 java.sql.Date类对应数据库中的日期类的变量

    /*
    如何实例化？
    两个Date对象实现转换
     */
    @Test
    public void test3(){
        java.sql.Date date3=  new java.sql.Date(1588070472180L);
        System.out.println(date3);
        //将父类对象转换为子类对象
        //情况一：
        Date date1=new java.sql.Date(1588070472180L);
        java.sql.Date date2= (java.sql.Date) date1;
        //情况二：
        Date date=new Date();
        java.sql.Date date5=new java.sql.Date(date.getTime());
    }
    //3 SImpleDateFormat的使用：对日期Date类的格式化和解析
    /*
    1 两个操作
    1.1 格式化：日期-->字符串
    1.2 解析：字符串-->日期
    2 类的实例化
     */
    @Test
    public void test4() throws ParseException {
        //使用默认构造器
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        Date date=new Date();
        System.out.println(date);
        String format = simpleDateFormat.format(date);
        System.out.println(format);

        String time="20-4-29 下午3:31";//默认识别格式
        Date parse = null;
        try {
            parse = simpleDateFormat.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(parse);
        System.out.println("*****************************");
        //使用参数构造器
        //格式化
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(dateFormat.format(date));
        //解析
        String date1="2019-12-23 11:23:55";//指定识别格式
        System.out.println(dateFormat.parse(date1));
    }

    //练习一：字符串“1997-04-14”转换为java.sql.Date类的对象
    @Test
    public void test5() throws ParseException {
        String birth="1997-04-14";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse(birth);
        //sql和util类的转换
        java.sql.Date birthDate=new java.sql.Date(date.getTime());
        System.out.println(birthDate);
    }
    //练习二：“三天打鱼两天晒网” 1990-01-01 xxxx-xx-xx 打鱼？晒网？
        //方式一：通过毫秒数计算
        //方式二：通过天数计算

    //4 calendar日历类的使用
    @Test
    public void test6(){
        //实例化：通过子类创建对象或者通过静态方法
        Calendar calendar = Calendar.getInstance();//实际还是通过子类构造器实现
        //常用方法
        //get()
        int day = calendar.get(calendar.DAY_OF_MONTH);
        System.out.println(day);
        //set()
        calendar.set(calendar.DAY_OF_MONTH,8);
        day=calendar.get(calendar.DAY_OF_MONTH);
        System.out.println(day);
        //add
        calendar.add(calendar.DAY_OF_MONTH,-1);
        day=calendar.get(calendar.DAY_OF_MONTH);
        System.out.println(day);
        //getTime()
        Date date = calendar.getTime();
        //setTime()
        Date date1 = new Date();
        calendar.setTime(date1);
        day=calendar.get(calendar.DAY_OF_MONTH);
        System.out.println(day);

    }

}
