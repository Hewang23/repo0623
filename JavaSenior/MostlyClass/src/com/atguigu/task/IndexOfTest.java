package com.atguigu.task;

import java.util.Arrays;

/**
 * @author Hewang
 * @create 2020-04-28 21:30
 * @title
 */
public class IndexOfTest {
    public static void main(String[] args) {
        IndexOfTest test=new IndexOfTest();
        String str="belayugdeugdugbelay";
        int[] arr=test.search1(str,"ug");
        System.out.println(Arrays.toString(arr));


    }
    public int[] search1(String str,String target){
        int[] arr=new int[str.length()];
        int index=-1;
        for(int i=0;i<str.length();i++){
            index=str.indexOf(target,index+1);
            if(index==-1)break;
            arr[i]=index;
            if(index==-1||i!=0&&arr[i]==arr[i-1]){
                break;
            }
        }
        return arr;
    }
    //返回特定字符串出现次数  indexOf
    public int search2(String mainStr,String subStr){
        int count=0;
        int index=0;
        if(mainStr.length()<subStr.length())return 0;
            //方式一：通过子字符串的形式来查
            while ((index=mainStr.indexOf(subStr))!=-1){
                count++;
                mainStr=mainStr.substring(index+subStr.length());//优化点为内存
            }
            //方式二：通过原有字符串查
            while((index=mainStr.indexOf(subStr,index))!=-1){
                count++;
                index+=subStr.length();
            }
           
        return count;
    }
}
