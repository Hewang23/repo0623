package com.atguigu.task;

/**
 * @author Hewang
 * @create 2020-04-29 0:26
 * @title 将一个字符串的部分进行反转
 * 思路：将字符串转换为字符数组
 *
 */
public class ReverseTest {
    public static void main(String[] args) {
        ReverseTest test=new ReverseTest();
        String belaydebug = test.reverse2("belaydebug", 2, 5);
        System.out.println(belaydebug);

    }
    //方式一：通过字符数组实现
    public String reverse(String str,int start,int end){
        char[] chars;
        if(str!=null&&str.length()!=0){
            chars=str.toCharArray();
            int mid=(start+end)/2;
            char temp=' ';
            /*
            for(int x=start,y=end;x<y;x++,y--){
                char temp=arr[x];
                arr[x]=arr[y];
                arr[y]=temp;
            }
             */
            for(int i=start;i<=mid;i++){
                temp=chars[i];
                chars[i]=chars[end];
                chars[end]=temp;
                end--;
            }
            String string=new String(chars);
            return string;
        }else return null;
    }
    //方式二：通过子字符串再通过reverse实现？
    public String reverse2(String str,int start,int end){
        String str1=str.substring(start,end);
        StringBuffer str2=new StringBuffer(str1);
        str2=str2.reverse();
        str2=new StringBuffer(str.substring(0,start)).
                append(str2).append(new StringBuffer
                (str.substring(end,str.length())));
        return    new String(str2);
    }
    //方式三：通过subString以及字符串的拼接
    public String reverse3(String str,int start,int end){
        if(str==null)return null;
        if(str.length()==0)return "";
        String reverseStr=str.substring(0,start);
        for(int i=end;i>=start;i++){
            reverseStr+=str.charAt(i);
        }
        reverseStr+=str.substring(end+1,str.length());
        return reverseStr;
    }
    //方式四？基于方式三的改进 自行解决
}
