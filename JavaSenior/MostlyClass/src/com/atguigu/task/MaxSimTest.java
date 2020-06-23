package com.atguigu.task;

/**
 * @author Hewang
 * @create 2020-04-29 9:33
 * @title 获取两个字符串的最大相同子串
 * Tips：将较短的字符串进行长度递减的操作并将获得的字串依次与长串进行比较
 * 两个字符串的
 */
public class MaxSimTest {
    public String getSim1(String shortStr,String longStr){
        if(shortStr==null||longStr==null)return null;
        if(shortStr.length()>longStr.length()||shortStr.length()==0)return null;
        if(shortStr.length()==longStr.length()) return shortStr;
        //
        boolean isMatch=false;
        for(int i=0;i<shortStr.length();i++){
            isMatch=false;
            if(longStr.charAt(i)==shortStr.charAt(i)){
                isMatch=true;
            }else break;
        }
        return null;
    }
    //方法二：通过String的contains方法实现
    public String getSim2(String str1,String str2){
        String maxStr=(str1.length()>=str2.length()) ? str1: str2;
        String minStr=(str1.length()<str2.length()) ? str1: str2;
        for(int i=0;i<minStr.length();i++){
            for(int x=0,y=minStr.length()-i;y<=minStr.length();x++,y++){
                String subStr=minStr.substring(x,y);
                if(maxStr.contains(subStr)){
                    return subStr;
                }
            }
        }
        return null;

    }
}
