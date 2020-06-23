package com.atguigu.java;

/**
 * @author Hewang
 * @create 2020-04-24 17:06
 * @title
 * 同步方法实现解决线程安全问题
 */
public class WindowTest2 {
    public static void main(String[] args) {
        Window3 w1 = new Window3();
        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w1);
        Thread t3 = new Thread(w1);
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();


    }
}
class Window3 implements Runnable{
    private  int ticket=100;
    Object obj=new Object();
    @Override
    public void run() {
        while(ticket>0){//因为该方法中存在不是直接对共享数据操作的语句
            //因此不能作为同步方法
            show();

        }
    }
    private synchronized void show(){//同步监视器为this
        if(ticket>0){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"（卖票），票号为："+ticket);
            ticket--;
        }
    }
}

