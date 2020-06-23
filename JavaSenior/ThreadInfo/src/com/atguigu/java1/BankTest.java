package com.atguigu.java1;

/**
 * @author Hewang
 * @create 2020-04-24 17:56
 * @title 同步机制实现线程安全的懒汉式单例模式
 * 实际上单例模式只创建一个实例，
 * 因此一个线程执行完后，后续线程无需进入直接返回即可
 */
public class BankTest {
    public static void main(String[] args) {
        Bank.getInstance();
    }
}
class Bank{
    private Bank(){

    }
    private static Bank instance=null;
//    public static synchronized Bank getInstance(){//两个线程同时调用该方法时
//                                                    会出现访问共享数据的情况存在线程安全问题
    public static Bank getInstance(){
        //方式一：效率较差
//        synchronized (Bank.class) {
//            if(instance==null){
//                instance=new Bank();
//            }
//            return instance;
//        }
        //方式二：效率稍高
        if(instance==null){
            synchronized (Bank.class) {
                if(instance==null){
                    instance=new Bank();
                }
            }
        }
        return instance;
    }
}