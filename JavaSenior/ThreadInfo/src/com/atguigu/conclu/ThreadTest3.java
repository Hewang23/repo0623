package com.atguigu.conclu;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Hewang
 * @create 2020-04-26 11:02
 * @title 实现allable接口的方式创建线程--JDK5.0
 * callable相较于runnable的优点在于：
 * 1、有返回值
 * 2、有抛出异常
 * 3、支持泛型
 */
//1、创建一个Callable接口的实现类
class NumThread implements Callable{
    //2、实现call方法，将线程实现方法声明
    @Override
    public Object call() throws Exception {
        int sum=0;
        for(int i=0;i<=100;i++){
            sum+=i;
        }
        return  sum;//Integer类
    }
}
public class ThreadTest3 {
    public static void main(String[] args) {
        //3、创建NumThread对象
        NumThread numThread=new NumThread();
        //4、作为参数创建futuretask对象（实现了runnable接口的类）
        FutureTask futureTask=new FutureTask(numThread);
        Object o = null;
        //5、futuretask对象作为参数创建thread对象
        Thread thread = new Thread(futureTask);
        thread.start();
        try {
            o = futureTask.get();
            System.out.println(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

}
