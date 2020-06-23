package com.atguigu.java;

/**
 * @author Hewang
 * @create 2020-04-24 13:21
 * @title 第二种实现
 * 创建3个窗口卖票，总票数为100张  通过实现接口的方式实现的
 * 目前存在线程安全问题，待解决
 * 安全问题为：重票、错票问题
 * 出现原因为：当某个线程操作的过程中没有完成时，有其他线程进入方法
 * 解决方法为：线程在操作共享数据时，其他线程不能参与，直到该线程操作结束
 *            其他线程才开始操作，即使该线程出现阻塞也不能改变。
 * Java中通过同步机制解决线程安全问题：
 * 方式一：同步代码块
 *        synchronized(同步监视器){需要被同步的代码}
 *        操作共享数据的代码即为需要被同步的代码
 *        共享数据：多个线程共同操作的变量
 *        同步监视器：锁，任何一个类的对象都可以充当锁。
 *        要求：多个线程必须要用同一把锁
 *        补充：实现接口中创建多线程的方式中，可以考虑使用this充当同步监视器
 * 同步方法解决：保证了线程安全
 *              实际执行为单线程模式，效率较低
 *方法二：同步方法
 *        如果操作共享数据的代码完整的声明在一个方法中，则将该方法作为解决办法
 *        使用同步方法仍然涉及到同步监视器，不过此时不需要显示的声明
 *        说明：非静态的为this  静态的为当前类本身
 */
public class WindowTest1 {
    public static void main(String[] args) {
        Window2 w1 = new Window2();
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
class Window2 implements Runnable{
    private  int ticket=100;
    Object obj=new Object();
    @Override
    public void run() {
        while(true){
            synchronized (this){//boj
                if(ticket>0){
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"（卖票），票号为："+ticket);
                    ticket--;
                }else{
                    break;
                }
            }
        }
    }
}