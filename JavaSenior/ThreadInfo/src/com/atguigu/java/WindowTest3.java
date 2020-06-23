package com.atguigu.java;

/**
 * @author Hewang
 * @create 2020-04-24 17:37
 * @title 同步方法来处理Thread类的继承实现的线程安全问题
 */
public class WindowTest3 {
    public static void main(String[] args) {
        Window4 w1=new Window4();
        w1.setName("窗口1");
        Window4 w2=new Window4();
        w2.setName("窗口2");
        Window4 w3=new Window4();
        w3.setName("窗口3");
        w1.start();
        w2.start();
        w3.start();
    }
}
class Window4 extends Thread{
    private static int ticket=100;//几个实例对象共享操作该属性
    private static Object obj=new Object();
    public void run() {
        while(ticket>0){
            show();
        }
    }
    //private synchronized void show(){//默认同步监视器为w1,w2,w3
    private static synchronized void show(){//同步监视器为Window4，类是唯一的
        if(ticket>0) {
            try {
                sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "（卖票），票号为：" + ticket);
            ticket--;
        }
    }
}
