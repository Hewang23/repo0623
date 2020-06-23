package com.atguigu.java1;

import org.junit.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * @author Hewang
 * @create 2020-04-29 16:13
 * @title JDK8以后的时间API
 * 之前API中存在的问题：
 *  可变性；
 *  偏移性；
 *  格式化；
 *  线程安全问题；
 *  。。。
 */
public class TimeAPINew {
    /*
    LocalTime\LocalDate\LocalDateTime
    其中LocalDateTime常用
    类似于Calender
     */
    @Test
    public void test1(){
        //now()
        LocalDateTime ldt=LocalDateTime.now();//静态方法
        System.out.println(ldt);
        //of() 无偏移性
        LocalDateTime ldt2=LocalDateTime.of(2020,12,12,12,12);
        System.out.println(ldt2);
        //get()
        System.out.println(ldt.getDayOfMonth());
        //with() 具有不可变性
        LocalDateTime ldt3 = ldt.withDayOfMonth(3);
        //plus|minus
    }
    /*
    Instant的使用类似于java.util.Date类
     */
    @Test
    public void test2(){
        Instant now = Instant.now();//获取本初子午线的标准时间
        System.out.println(now);
        //根据时区添加偏移量
        OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);
        //获取指定参照点的毫秒数
        long l = now.toEpochMilli();
        System.out.println(l);
        //通过给定的毫秒数创建实例对象
        Instant instant = Instant.ofEpochMilli(1588235030335L);

    }

    /*
    DateTimeFormatter：格式化或解析日期、时间
    类似于SimpleDateFormat
     */
    @Test
    public void test3(){
        LocalDateTime ldt=LocalDateTime.now();
        DateTimeFormatter dtf=DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        //格式化操作
        String format = dtf.format(ldt);
        System.out.println(format);
        //指定形式
        DateTimeFormatter dtf1=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format1 = dtf1.format(LocalDateTime.now());
        System.out.println(format1);


    }

}
