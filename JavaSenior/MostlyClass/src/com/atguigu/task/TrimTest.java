package com.atguigu.task;

/**
 * @author Hewang
 * @create 2020-04-28 17:04
 * @title 实现trim的供能
 * trim即去除首尾的空格部分
 */
public class TrimTest {
    public static void main(String[] args) {
        TrimTest test=new TrimTest();
        String res=test.trim(" jj  l ");
        System.out.println("--"+res+"--");

    }
    public String trim(String str){
        if(str==null||str.length()==0)return null;
        char[] chars = str.toCharArray();
        int begin=-1;
        for(int i=0;i<chars.length;i++){
            begin++;
            if(chars[i]!=' ')break;

        }
        int end=chars.length;
        for(int i=chars.length-1;i>0;i--){
            end--;
            if(chars[i]!=' ')break;
        }
        char[] result=new char[end-begin+1];
        for(int i=0;i<result.length;i++){
            result[i]=chars[begin];
            begin++;
        }

        return new String(result);


    }

}
