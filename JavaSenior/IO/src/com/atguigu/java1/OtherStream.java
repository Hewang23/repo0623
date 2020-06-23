package com.atguigu.java1;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Hewang
 * @create 2020-05-15 0:40
 * @title 其他流的使用
 * 1、标准的输入输出流
 * 2、打印流
 * 3、数据流
 *
 */
public class OtherStream {
    /*
    1、标准的输入输出流
    1.1 System.in：默认从键盘输入
        System.out：默认从控制台输出
    1.2 System类的setIn(InputStream is)/setOut(PrintStream ps)方法重新指定输入和输出的位置
    1.3 从键盘读取字符串，并转换为大写输出
    世道输入e或者exit时退出程序
     */
    @Test
    public void test1(){
        BufferedReader br= null;
        try {
            InputStreamReader isr=new InputStreamReader(System.in);
            br = new BufferedReader(isr);
            while(true){
                System.out.println("请输入字符串：");
                String data=br.readLine();
                if("e".equalsIgnoreCase(data)||"exit".equalsIgnoreCase(data)){
                    break;
                }
                String s = data.toUpperCase();
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
    @Test
    public void test(){
//        Scanner scanner=new Scanner(System.in);
//        boolean confirmExit=false;
//        System.out.print("请输入：");
//        while (true){
//            String str=scanner.nextLine();
//            switch (str){
//                case "e":
//                    confirmExit=true;
//                    break;
//                case "exit":
//                    confirmExit=true;
//                    break;
//                default:
//                    System.out.println(str.toUpperCase());
//                    break;
//            }
//            if(confirmExit){
//                break;
//            }
//        }
    }
    /*
    2、打印流：PrintStream、PrintWriter
     */
    /*
    3、数据流：DataInputStream、DataOutputStream
    用于读取或写出基本数据类型的变量或字符串
    可以在程序运行时将一些基本数据以及字符串的数据进行保存到硬盘中
    避免随着程序的结束而删除，以备后续使用
    注意：
    读取文件时只能通过流实现且按照存取顺序读取
    且可以通过flush()方法将以写入文件存储到硬盘中
     */
}
