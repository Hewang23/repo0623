package com.atguigu.exer;

import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Hewang
 * @create 2020-05-13 23:03
 * @title 文件的加密与解密(图片为例)
 */
public class FileProtect {
    //文件的加密
    @Test
    public  void test1(){
        FileInputStream fis= null;
        FileOutputStream fos= null;
        try {
            fis = new FileInputStream("download.jpg");
            fos = new FileOutputStream("download-protected.jpg");
            byte[]  bytes=new byte[20];
            int readLen;
            while((readLen=fis.read(bytes))!=-1){
                for(int i=0;i<readLen;i++){
                    bytes[i]=(byte)(bytes[i]^5);
                }
                fos.write(bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //文件的解密
    @Test
    public  void test2(){
        FileInputStream fis= null;
        FileOutputStream fos= null;
        try {
            fis = new FileInputStream("download-protected.jpg");
            fos = new FileOutputStream("download-Unprotected.jpg");
            byte[]  bytes=new byte[20];
            int readLen;
            while((readLen=fis.read(bytes))!=-1){
                for(int i=0;i<readLen;i++){
                    bytes[i]=(byte)(bytes[i]^5);
                }
                fos.write(bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //获取文本中每个字符出现的次数
    /*
    思路：通过Map实现
     */
    @Test
    public void test3(){
        FileReader fr= null;
        FileWriter fw= null;
        try {
            HashMap<Character, Integer> map = new HashMap<>();
            Set<Map.Entry<Character, Integer>> entries = map.entrySet();
            fr = new FileReader("F:\\Users\\Administrator\\Desktop\\belay.txt");
            fw = new FileWriter("F:\\Users\\Administrator\\Desktop\\belayResult.txt");
            int c;
            while ((c=fr.read())!=-1){
                char key=(char)c;
                if(!map.containsKey(key)){
                    map.put(key,1);
                }else{
                    map.put(key,map.get(key)+1);
                }
            }
            for(Map.Entry<Character,Integer> entry:entries){
                fw.write(entry.getKey()+"="+entry.getValue()+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fr!=null){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fw!=null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
