package com.atguigu.java;

/**
 * @author Hewang
 * @create 2020-04-24 12:04
 * @title 创建多线程的方式二：实现Runnable接口
 * 1、创建实现Runnable接口的类
 * 2、类中实现Runnable接口中的run方法
 * 3、创建实现类的对象
 * 4、将对象作为参数传入Thread类的构造器中，创建对象
 * 5、通过start()调用
 */
public class ThreadTest1 {
    public static void main(String[] args) {
        MThread mThread = new MThread();
        Thread thread1 = new Thread(mThread);
        thread1.start();//此时调用的run()为target赋值后对应得run();
        Thread thread2 = new Thread(mThread);
        thread2.start();
    }
}
class MThread implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}