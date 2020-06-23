package com.atguigu.java;

/**
 * @author Hewang
 * @create 2020-04-24 10:35
 * @title Thread类中的方法测试
 * 1、start();启动当前线程，调用当前线程的run()方法
 * 2、run();重写，需要执行的方法体
 * 3、currentThread();静态方法，返回执行当前代码的线程
 * 4、getName();获取当前线程的名字
 * 5、setName();设置当前线程的名字
 * 6、yield();释放当前CPU的执行权
 * 7、join();在线程A中调用B的join方法，A进入阻塞状态，直到B执行结束后A结束阻塞
 * 8、stop();已过时，强制结束当前线程
 * 9、sleep(long millis);让当前线程睡眠指定的ms数，期间为阻塞
 * 10、isAlive();判断当前线程是否存活
 *
 * 线程的优先级：
 * 1、
 * MAX_PRIORITY：10
 * MIN_PRIORITY：1
 * NORM_PRIORITY：5
 * 2、获取和设置
 * getPriority();
 * setPriority(int );
 * 声明：高优先级的线程要抢占低优先级的CPU的执行权，但是只是从概率上
 *      高优先级的线程高概率的占用CPU资源，并非一定为先高后低
 */
public class ThreadMethodTest {
    public static void main(String[] args) {
        Thread1 t1=new Thread1("线程1");
        t1.start();
        t1.setPriority(Thread.MAX_PRIORITY);
        Thread.currentThread().setName("主线程");
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        for(int i=0;i<100;i++){
            if(i%2==0) {
                System.out.println(Thread.currentThread().getName() +Thread.currentThread().getPriority()+ ":" + i);
            }
            if(i%30==0){
                Thread.currentThread().yield();
            }
//            if(i==20){
//                try {
//                    t1.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        }
//        System.out.println(t1.isAlive());
//        System.out.println(Thread.currentThread().isAlive());
    }
}
class Thread1 extends Thread{
    public Thread1(String name){
        super(name);
    }
    @Override
    public void run() {//父类中没有抛异常，因此子类也不可以
        for(int i=0;i<100;i++){
            if(i%2==0){
//                try {
//                    sleep(50);//ms
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(Thread.currentThread().getName()+getPriority()+":"+i);
            }
        }

    }
}
