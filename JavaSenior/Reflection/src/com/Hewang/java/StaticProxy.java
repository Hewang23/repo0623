package com.Hewang.java;

/**
 * @author Hewang
 * @create 2020-05-17 15:14
 * @title  静态代理
 * 代理类和被代理类在编译期间就被确定
 */
//1、首先定义接口

interface ClothFactory{
    void produceCloth();
}
class ProxyClothFactory implements ClothFactory{
private ClothFactory clothFactory;
public ProxyClothFactory(ClothFactory clothFactory){
    this.clothFactory=clothFactory;
}
    @Override
    public void produceCloth() {
        System.out.println("代理商做准备工作");
        clothFactory.produceCloth();
        System.out.println("代理商做后续工作");
    }
}
class NikeClothFactoy implements ClothFactory{
    @Override
    public void produceCloth() {
        System.out.println("Nike做实际的工作");
    }
}

public class StaticProxy {
    public static void main(String[] args) {
        NikeClothFactoy nikeClothFactoy=new NikeClothFactoy();
        ProxyClothFactory proxyClothFactory=new ProxyClothFactory(nikeClothFactoy);
        proxyClothFactory.produceCloth();
    }



}
