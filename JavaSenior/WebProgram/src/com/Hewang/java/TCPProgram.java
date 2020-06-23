package com.Hewang.java;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Hewang
 * @create 2020-05-15 18:24
 * @title
 * 实现TCP的网络编程
 */
public class  TCPProgram {
    /*
    实现客户端向服务端发送信息
     */
    //客户端
    @Test
    public void client() {
        Socket socket= null;
        OutputStream os = null;
        try {
            InetAddress inet=InetAddress.getByName("127.0.0.1");
            socket = new Socket(inet,8899);
            os = socket.getOutputStream();
            os.write("Hello!".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //服务端
    @Test
    public void server()  {
        ServerSocket ss= null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos= null;
        try {
            ss = new ServerSocket(8899);
            socket = ss.accept();
            is = socket.getInputStream();
//          不建议该写法，会出现乱码（字符和字节）
        byte[] bytes = new byte[1024];
        int len;
        while ((len=is.read(bytes))!=-1){
            String str=new String(bytes,0,len);
            System.out.print(str);
        }
//            baos = new ByteArrayOutputStream();
//            byte[] bytes = new byte[20];
//            int len;
//            while ((len=is.read(bytes))!=-1){
//                baos.write(bytes,0,len);
                //自动存放在该类实例化时创建的空间中
//            }
//            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(baos!=null){

                    baos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(is!=null){

                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(socket!=null){

                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(ss!=null){

                    ss.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
