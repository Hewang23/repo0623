package com.atguigu.java;

/**
 * @author Hewang
 * @create 2020-04-24 9:31
 * @title 关于Thread类的创建和使用测试
 * 1、继承于Thread类的子类，重写run方法，
 * 构建子类实例调用父类的start方法
 *   例子：遍历一百以内所有的偶数
 */
public class ThreadTest {
    public static void main(String[] args) {
        //线程的创建和调用都是通过主线程实现的
        MyThread test=new MyThread();
        //start方法的作用
        //1、启动当前线程
        //2、调用当前线程的run方法
        test.start();
        //问题一：不能通过对象.run();实现线程的启动
        //test.run();只是实现通过类调用run方法没有开启新线程
        //问题二：再启动一个线程遍历100以内的偶数
        //test.start();不可以让已经start的线程再执行stat();
        //需要重新创建新的线程对象
        MyThread test2=new MyThread();
        test2.start();
        //如下操作在main线程中执行
        for(int i=0;i<=100;i++){
            if(i%2!=0){
                System.out.println(Thread.currentThread().getName()+":"+i+"**");
            }
        }
    }
}
class MyThread extends Thread{
    //将线程要完成的工作写入run方法中
    @Override
    public void run() {
        for(int i=0;i<=100;i++){
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}
