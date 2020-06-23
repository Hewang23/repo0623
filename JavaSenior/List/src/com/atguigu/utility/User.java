package com.atguigu.utility;

import java.util.Objects;

/**
 * @author Hewang
 * @create 2020-05-06 13:20
 * @title
 */
public class User implements Comparable{
    private String name;
    private int age;
    public User(){

    }
    public User(String name,int age){
        this.name=name;
        this.age=age;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return this.name;
    }
    public void setAge(int age){
        this.age=age;
    }
    public int getAge(){
        return this.age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof User){
            User user=(User)o;
            int compareTo=this.name.compareTo(user.name);
            if(compareTo!=0){
                return compareTo;
            }else{
                return Integer.compare(this.age,user.age);
            }
        }else{
            throw new RuntimeException("数据类型不匹配");
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
