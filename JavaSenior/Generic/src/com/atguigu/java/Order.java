package com.atguigu.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hewang
 * @create 2020-05-11 10:10
 * @title 泛型类的构建
 *
 */
public class Order<T>{
    String orderName;
    int orderId;
    T orderT;
    public Order(){
        T[] arr= (T[]) new Object[10];
    }
    public Order(String orderName,int orderId,T orderT){
        this.orderId=orderId;
        this.orderName=orderName;
        this.orderT=orderT;
    }

    public T getOrderT() {
        return orderT;
    }
    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }

    @Override
    public String  toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", orderId=" + orderId +
                ", orderT=" + orderT +
                '}';
    }
    public <E> List<E> copyList(E[] arr){
        ArrayList<E> list=new ArrayList<>();
        for(E ele:arr){
            list.add(ele);
        }
        return list;
    }
}
