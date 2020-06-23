package com.atguigu.java;

/**
 * @author Hewang
 * @create 2020-04-24 11:53
 * @title 通过该实例引出第二种创建线程的方法
 * 创建3个窗口卖票，总票数为100张  通过继承类的方式实现的
 * 目前存在线程安全问题，待解决
 * 通过继承实现的Thread中线程安全问题的同步机制解决办法
 *
 * 补充：在继承创建多线程的方式中，慎用this充当同步监视器，考虑使用当前类充当同步监视器
 *
 */
public class WindowTest {
    public static void main(String[] args) {
        Window w1=new Window();
        w1.setName("窗口1");
        Window w2=new Window();
        w2.setName("窗口2");
        Window w3=new Window();
        w3.setName("窗口3");
        w1.start();
        w2.start();
        w3.start();
    }
}
class Window extends Thread{
    private static int ticket=100;//几个实例对象共享操作该属性
    private static Object obj=new Object();
    public void run() {
        while(true){
//            synchronized (obj) {
            synchronized (Window.class){//类也是对象  因为类只加载一次，对象可以多次构建
                if(ticket>0) {
                    try {
                        sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName() + "（卖票），票号为：" + ticket);
                    ticket--;
                }else{
                    break;
                }
            }
        }
    }
}