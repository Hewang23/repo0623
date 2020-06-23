package com.atguigu.conclu;

/**
 * @author Hewang
 * @create 2020-04-26 10:16
 * @title 关于多线程的应用：经典例题-生产者/消费者问题
 * 分析：
 * 1、是否多线程？有生产者和消费者两个线程
 * 2、是否有共享数据？产品的数量
 * 3、如何解决线程安全问题？同步机制三种方法
 * 4、线程通信问题？是
 */
public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk=new Clerk();
        Producer p1=new Producer(clerk);
        p1.setName("供应商1");
        Consumer c1=new Consumer(clerk);
        c1.setName("消费者1");
        Consumer c2=new Consumer(clerk);
        c2.setName("消费者2");
        p1.start();
        c1.start();
        c2.start();
    }
}
class Clerk{
    private int productCount=0;
    //生产产品
    public synchronized void produceProduct() {//同步监视器默认为this
        if(productCount<20){
            productCount++;
            System.out.println(Thread.currentThread().getName()
                    + ":开始生产第" + productCount + "个产品");
            notify();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void consumeProduct() {
        if(productCount>0){
            System.out.println(Thread.currentThread().getName()
                    + ":可以购买第" + productCount + "个产品");
            productCount--;
            notify();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Producer extends Thread{
    private  Clerk clerk=new Clerk();
    public Producer(Clerk clerk){
        this.clerk=clerk;
    }

    @Override
    public void run() {
        System.out.println(getName()+":开始生产");
        while(true) {
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.produceProduct();
        }
    }
}
class Consumer extends Thread{
    private  Clerk clerk=new Clerk();
    public Consumer(Clerk clerk){
        this.clerk=clerk;
    }

    @Override
    public void run() {
        System.out.println(getName()+":进行购买");
        while(true){
            try {
                sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consumeProduct();
        }
    }
}