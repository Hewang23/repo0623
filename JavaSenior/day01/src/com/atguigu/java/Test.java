package com.atguigu.java;

/**
 * @author Hewang
 * @create 2020-04-28 14:32
 * @title
 */
public class Test {
    private static int j;
    public void fun2(){
        int i=0;
        i++;
        System.out.println(i);
    }
    public void fun1(){
        j=5;
        j++;
        System.out.println(j);
    }

    public static void main(String[] args) {
        Test t=new Test();
        for(int k=0;k<10;k++){
            t.fun1();
            t.fun2();
        }
    }
}
