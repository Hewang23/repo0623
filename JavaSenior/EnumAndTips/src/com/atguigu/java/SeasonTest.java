package com.atguigu.java;

import java.util.Arrays;

/**
 * @author Hewang
 * @create 2020-05-04 12:06
 * @title  通过enum关键字实现枚举类的创建
 * 定义的枚举类继承于 java.lang.Enum
 */
public class SeasonTest {
    public static void main(String[] args) {
        Season1 summer = Season1.SUMMER;
        System.out.println(summer);
        System.out.println(Season1.class.getSuperclass());
        Season1[] values = Season1.values();
        System.out.println(Arrays.toString(values));
        Thread.State[] values1 = Thread.State.values();
        System.out.println(Arrays.toString(values1));
        //如果每日有objName类的对象会抛异常
        Season1 fall = Season1.valueOf("AUTUMN");
        System.out.println(fall);
    }
}
interface info{
    void show();
}
//通过enum
enum Season1 implements info{
    //1、提供多个枚举类的对象
     SPRING("春天","春风习习"){
        @Override
        public void show() {
            System.out.println("");
        }
    },
     SUMMER("夏天","烈日炎炎"){
         @Override
         public void show() {
             System.out.println("");

         }
     },
     AUTUMN("秋天","秋风瑟瑟"){
         @Override
         public void show() {
             System.out.println("");

         }
     },
     WINTER("冬天","白雪皑皑"){
         @Override
         public void show() {
             System.out.println("");

         }
     };
    //2、声明当前枚举类的属性
    //final类型的变量可以显式赋值、构造器赋值、代码块赋值
    private final String seasonName;
    private final String seasonInfo;
    //3、私有化类的构造器，并给对象属性赋值
    private Season1(String seasonName,String seasonInfo){
        this.seasonInfo=seasonInfo;
        this.seasonName=seasonName;
    }
    //获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }
    public String getSeasonInfo() {
        return seasonInfo;
    }

//    @Override
//    public void show() {
//        System.out.println("这是一个季节");
//    }
//    //toString()  不需要重写
//    @Override
//    public String toString() {
//        return "Season{" +
//                "seasonName='" + seasonName + '\'' +
//                ", seasonInfo='" + seasonInfo + '\'' +
//                '}';
//    }
}