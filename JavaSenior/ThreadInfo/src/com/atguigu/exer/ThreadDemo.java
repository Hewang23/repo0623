package com.atguigu.exer;

/**
 * @author Hewang
 * @create 2020-04-24 10:05
 * @title 线程创建的练习
 * 创建两个分线程，其中一个遍历100以内的偶数，一个遍历100以内的奇数
 */
public class ThreadDemo {
    public static void main(String[] args) {
        Thread1 t1=new Thread1();
        t1.start();
        Thread2 t2=new Thread2();
        t2.start();
        //创建Thread类的匿名子类
        new Thread(){
            @Override
            public void run() {
                for(int i=0;i<100;i++){
                    if(i%2==0){
                        System.out.println(Thread.currentThread().getName()+":"+i);
                    }
                }
            }
        }.start();
    }
}
class Thread1 extends Thread{
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            if(i%2==0){
                System.out.println("偶数项："+i);
            }
        }
    }
}
class Thread2 extends Thread{
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            if(i%2 !=0){
                System.out.println("奇数项"+i);
            }
        }
    }
}
