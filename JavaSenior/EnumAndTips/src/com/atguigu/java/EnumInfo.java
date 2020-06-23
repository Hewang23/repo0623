package com.atguigu.java;

/**
 * @author Hewang
 * @create 2020-05-04 11:42
 * @title 枚举类的介绍
 * A、
 * 定义：类的对象为有限个且为确定的（尤其定义一组常量时）
 * 如果只有一个对象，可以作为单例模式的实现
 * B、
 * 如何定义枚举类？
 *  jdk5.0之前自定义枚举类
 *  jdk5.0之后通过enum关键字自定义枚举类
 * C、Enum类中的常用方法
 *  values()
 *  valueOf()
 *  toString()
 * D、使用关键字定义枚举类实现接口
 *  每个对象调用实现的接口方法的效果不同
 *
 */
public class EnumInfo {
    public static void main(String[] args) {
        Season spring=Season.SPRING;
        System.out.println(spring);
    }
}
class Season{
    //属性
    //final类型的变量可以显式赋值、构造器赋值、代码块赋值
    private final String seasonName;
    private final String seasonInfo;

    //构造器
    private Season(String seasonName,String seasonInfo){
        this.seasonInfo=seasonInfo;
        this.seasonName=seasonName;
    }
    //构建对象 public static final
    public static final Season SPRING=new Season("春天","春风习习");
    public static final Season SUMMER=new Season("夏天","烈日炎炎");
    public static final Season AUTUMN=new Season("秋天","秋风瑟瑟");
    public static final Season WINTER=new Season("冬天","白雪皑皑");
    //获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }
    public String getSeasonInfo() {
        return seasonInfo;
    }
    //toString()

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonInfo='" + seasonInfo + '\'' +
                '}';
    }
}