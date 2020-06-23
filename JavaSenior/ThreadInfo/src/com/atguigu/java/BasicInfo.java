package com.atguigu.java;
/**
 * @author Hewang
 * @create 2020-04-24 0:21
 * @title Thread
 * A、关于线程的基础知识介绍
 * 程序：（完成特定任务，通过语言编写的一组指令的集合，一段静态的代码）
 * 进程：（程序的一次执行过程，将程序的代码加载到内存中，即正在执行的一个程序。）
 *          即为动态的过程，有产生、生存和消亡的过程：生命周期
 *          进程作为资源分配的单位，系统在运行时会为每个进程分配不同的内存区域
 * 线程：（进程的进一步细化，是一个程序内部的一条执行路径
 *      ，若一个进程同一时间执行多个线程，则为支持多线程的）
 *      线程作为调度和执行的单位，每个线程有独立的运行栈和程序计数器
 *          线程切换的开销小
 *          一个进程中的线程共享相同的内存单元/内存空间（堆和方法区）
 *          从同一个堆中分配对象，可以访问相同的变量和对象，使得线程通信便捷
 *          多个线程操作共享的系统资源会有安全隐患。
 * B、单核CPU和多核CPU的理解
 * 单核CPU：假多线程，因为CPU的主频很高，虽然同一个时间段只可以做一件事
 *         但是执行效率高，因此感觉单核CPU在同时进行多个进程也为多个线程
 * 多核CPU：现有服务器为多核实现更好的多线程（多个核的主频不同）
 * 一个Java应用程序java.exe至少三个线程：main主线程，gc垃圾回收线程，异常处理线程
 *C、并行与并发
 * 并行：多个CPU同时执行多个任务，多个人同时做不同的事情
 * 并发：一个CPU（采用时间片）同时执行多个任务
 * D、使用多线程的优点？
 * 单核CPU中单个线程先后完成多个任务要比多个线程来完成时间更短，因为避免CPU切换
 * 优点在于：1、提高应用程序的相应，增强用户体验，同时进行听音乐和看文献两个进程里的线程
 *             随着主频提高，切换速度块，用户体验也尚可
 *          2、提高CPU的利用率
 *          3、改善程序结构，长且复杂的进程分为多个线程，独立运行，便于理解和修改
 * E、何时需要多线程
 *          1、程序需要同时执行两个或多个任务，比如main方法和gc垃圾回收以及异常处理
 *          2、程序需要实现需要等待的任务，比如刷新一个商品，文本信息和图片信息为不同的线程
 *          3、需要后台执行的程序时
 * F、线程的创建和使用
 *  1、创建Thread类的子类，然后重写类中的run方法，创建子类对象调用start方法
 * G、线程的主要方法
 * H、线程的调度，一般为时间片策略，会出先优先级策略
 * I、线程的优先级等级为：MAX：10、MIN：1、NORM：5；
 * J、比较创建Thread的两种方式优劣？
 *    1、开发中优先选择实现接口的方式，实现的方式没有类的单继承性的限制
 *    2、实现的方式更适合实现多个线程有共享数据的情况
 *    3、Thred类本身实现了接口
 *    4、两种方式都要重写run()，将线程要实现的逻辑声明在run中
 * I、线程通信的三个主要方法：wait()\notify()\notifyAll()定义在Object中
 * J、线程的分类：用户线程和守护线程
 *    守护线程用于服务用户线程，在start()方法前被调用
 *    通过.setDaemon(true)将一个用户线程变为也守护线程
 *    Java垃圾回收即为典型的守护线程
 * K、线程的生命周期
 *    线程的状态：Thread.State类定义：新建、就绪、运行、阻塞、死亡
 * L、线程的同步
 *    多个线程执行的不稳定性会引起执行结果的不稳定
 *    多个线程对数据的共享会造成操作的不完整性，会破坏数据
 * M、通过同步代码块以及同步方法分别解决两种实现多线程中的安全隐患
 * N、线程的死锁问题：多个同步锁的情况
 */


public class BasicInfo {
}
