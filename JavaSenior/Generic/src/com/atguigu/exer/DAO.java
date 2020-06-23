package com.atguigu.exer;

import java.util.List;

/**
 * @author Hewang
 * @create 2020-05-11 11:19
 * @title 操作数据库对象的工具类
 * 因为实际数据库中的内容通过表的结构存放
 * 实际对表中数据进行操作时，操作的对象类不同
 * 因此需要通过泛型来实现对所有表中数据的统一操作
 *
 * 子类继承父类时对于泛型的继承关系：几种
 */
public class DAO<T> {
    //增删改查
    public void add(T t){

    }
    public boolean remove(T t){
        return false;
    }
    public void update(int index,T t){

    }
    public T show(int index){
        return null;
    }
    public List<T> get(int begin,int end){
        return null;
    }
    //泛型方法：即声明在方法返回值类型或者方法参数类型为不确定情况
    //举例：获取表中一共有多少条记录？long型数据；
    public <E> E getValue(){
        return null;
    }
}
