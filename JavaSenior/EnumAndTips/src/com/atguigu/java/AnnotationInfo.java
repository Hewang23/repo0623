package com.atguigu.java;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.util.ArrayList;

/**
 * @author Hewang
 * @create 2020-05-04 16:30
 * @title 开发基于注解：框架=注解+反射+设计模式
 * A、生成文档相关的注解
 * B、编译时进行格式检查
 *    Override
 *    Desperated
 *    SuppressWarnings
 * C、跟踪代码依赖性，实现替代配置文件功能
 *
 * 自定义注解：参照SuppressWarnings
 *  A、注解声明为@interface
 *  B、内部定义成员，通常使用value表示
 *  C、可指定成员的默认值，使用default定义
 *  D、自定义注解没有成员，表明为一个标识作用
 *  如果注解有成员，使用时需要指明成员的值
 *  自定义注解必须配上信息处理流程才有意义（通过反射）
 *  自定义注解通常都会指明两个元注解：Retention和Target
 * JDK提供的
 * 元注解：修饰其他注解的注解
 *  Retention：指明修饰注解的生命周期：SOURCE、CLASS、RUNTIME
 *      只有声明为RUNTIME生命周期的注解才能通过反射获取
 *  Target：指定注解的修饰元素
 *  ********************出现频率较低********************
 *  Documented：指定被修饰的注解将被javadoc工具提取为文档，
 *              javadoc默认不包括注解
 *      即可以在API文档中不省略被修饰注解
 *      定义为Documented的注解必须设置为RUNTIME
 *  Inherited：指定被修饰的注解具有继承性，即被该注解修饰的类的子类自动具有该注解
 * 元数据：对现有数据的修饰的数据
 *
 * 通过反射获取注解信息
 *
 *
 *JDK8之后的新特性
 *A、可重复注解
 *JDK8之前：@MyAnnotations({,})
 *JDK8之后实现：
 * 在需要重复使用的注解上声明@Repeatable，成员值为该注解相关的注解数组
 * 该注解数组的@Target和@Retention声明同该注解，Inherited同定义
 *B、类型注解
 * TYPE_PARAMETER：用于使注解可以修饰泛型类型部分
 * TYPE_USE：使注解能使用在可使用类型的任何语句中
 */


public class AnnotationInfo {
    public static void main(String[] args) {
        @SuppressWarnings("unused")
        int num=10;
        @SuppressWarnings({"unused","rawtypes"})
        ArrayList list=new ArrayList();
        System.out.println("sss");
    }
    @Test
    public void test1(){
        Class studentClass = Student.class;
        Annotation[] annotations = studentClass.getAnnotations();
        for(int i=0;i<annotations.length;i++){
            System.out.println(annotations[i]);
        }

    }
}

@MyAnno
@MyAnno("hi")
class Person{

}
class Student extends Person{

}
class Genic<@MyAnno T>{
    public void show() throws @MyAnno RuntimeException{
        ArrayList<@MyAnno String> list=new ArrayList<>();
        int num=(@MyAnno int)10l;
    }
}