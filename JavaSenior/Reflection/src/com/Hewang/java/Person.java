package com.Hewang.java;

/**
 * @author Hewang
 * @create 2020-05-16 14:42
 * @title
 */
public class Person {
    private String name;
    public int age;
    public Person(){

    }
    public Person(String name,int age){
        this.age=age;
        this.name= name;
    }
    private Person(String name){
        this.name=name;
    }
    public void show(){
        System.out.println("我是代恶人");
    }
    private String getNation(String nation){
        System.out.println("来自："+nation);
        return nation;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
//    public void setAge(int age){
//        this.age=age;
//    }
//    public int getAge(){
//        return age;
//    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
