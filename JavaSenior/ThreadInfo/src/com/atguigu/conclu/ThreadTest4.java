package com.atguigu.conclu;

import java.util.concurrent.*;

/**
 * @author Hewang
 * @create 2020-04-26 11:16
 * @title 创建线程的方式四：线程池
 * 背景：经常创建和销毁，使用量特别大的资源
 * 思路：提前创建好多个线程放入内存池中，使用时获取，使用完放回池中
 *      避免频繁创建和销毁，实现重复利用，类似于公共交通工具
 * 好处：
 * 提高相应速度（减少了创建新线程的时间）
 * 降低资源损耗（重复利用线程池中线程，不需要每次使用都创建）
 * 便于线程管理（规定最大线程数，以及工作时间以及终止状态）
 *
 */
class RunThread implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<=100;i++){
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }

    }
}
class RunThread1 implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<=100;i++){
            if(i%2!=0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }

    }
}
class CallThread implements Callable{
    @Override
    public Object call() throws Exception {
        int sum=0;
        for(int i=0;i<=100;i++){
            sum+=i;
        }
        System.out.println(Thread.currentThread().getName());
        return sum;
    }
}
public class ThreadTest4 {
    public static void main(String[] args){
        ExecutorService service = Executors.newFixedThreadPool(10);
        //设置线程池的属性
        System.out.println(service.getClass());//接口的属性为常量
        ThreadPoolExecutor service1=(ThreadPoolExecutor) service;//实现接口的子类的强转
        service1.setCorePoolSize(15);
        //因为接口中的属性为常量，因此需要获相关属性需要通过实现子类来实现调用
        CallThread callThread = new CallThread();
        FutureTask futureTask=new FutureTask(callThread);
        service.execute(new RunThread());//适用于runnable接口
        service.execute(new RunThread1());
        service.submit(futureTask);//适用于callable接口
        try {
            Object o = futureTask.get();
            System.out.println(Thread.currentThread().getName()+":"+o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        service.shutdown();
    }
}
