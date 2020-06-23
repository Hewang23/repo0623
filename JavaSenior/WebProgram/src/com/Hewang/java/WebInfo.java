package com.Hewang.java;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Hewang
 * @create 2020-05-15 16:36
 * @title
 * 计算机网络
 * 网络编程：直接或间接地通过网络协议与其他计算机实现数据交换进行通信
 * 问题：如何准确地定位网络上一台后多台主机；定位主机上的特定应用或进程
 *      找到主机后如何可靠高效地进行数据传输
 * 网络通信要素：
 * >通信双方地址：
 *  >IP：主机地址 唯一的标识Internet上的计算机（通信实体）
 *      1、InetAddress类来表示一个IP
 *      2、IP地址分类方式1：IPV4和IPV6
 *         >IPV4：4个字节组成即4个0-255，已经用尽
 *         >IPV6；16个字节组成，8个无符号整数标识，每一个整数通过4个十六进制位标识
 *                数之间通过：分割；（可以作为实现万物互联的基础）
 *         IP地址分类方式2：公网地址（万维网）和私有地址（局域网）
 *         >192.168.开头的为私有地址192.168.0.0-192.168.255.255为组织机构内部使用
 *      3、域名
 *         >实际中通过地址来表示IP过于抽象，因此通过域名
 *          即在网络中访问时，输入域名后，主机通过在本地检索域名对应的IP地址，若未检索到
 *          则通过DNS解析出域名地址，进行访问；
 *      4、本地回路地址：127.0.0.1 对应：localhost
 *  >端口号：区分主机上的应用程序
 *      1、不同的进程有不同的端口号
 *      2、16位的整数：0-65535
 *      3、端口分类：
 *         >公认端口：0-1023，被预先定义的服务通信占用
 *          FTP：21；Telnet：23；HTTP：80
 *         >注册端口：1024-49151，分配给用户进程或应用程序
 *          Tomcat：8080；MySQL：3306；Oracle：1521
 *         >动态/私有端口：49152-65535
 *  >端口号与IP地址的组合得到网络套接字：Socket
 * >网络通信协议：对速率、传输代码、代码结构、传输控制步骤、出错控制等指定标准
 *  传输层协议：
 *  >TCP协议：需要建立连接，大数据量的传输，可靠的
 *           三次握手、四次挥手
 *           打电话
 *           数据流的格式发送和接收 
 *           涉及到IO流的阻塞问题
 *  >UDP协议：将数据、源、目的地封装到数据包，不需要建立连接，每个数据包的大小，不可靠的
 *           发送短信、发电报
 *           数据包的格式发送和接收
 *  网络层协议：
 *  >URL网络编程：URL位统一资源定位符，标识Internet某一资源的地址
 *           基本结构：<传输协议>://<主机名>:<端口号>/<文件名>#片段名?参数列表
 *                      http://localhost:8080/examples/hello.txt?username=Tom
 *
 *
 *
// *  OSI：
 *  TCP/IP：应用、传输、网络、物理+数据链路
 */
public class WebInfo {
    public static void main(String[] args) {
        //通过IP地址访问
        try {
            //实例化
            InetAddress inet1= InetAddress.getByName("192.168.0.4");
            System.out.println(inet1);
            InetAddress inet2=InetAddress.getByName("www.baidu.com");
            System.out.println(inet2);
            InetAddress inet3=InetAddress.getByName("localhost");
            System.out.println(inet3);
            InetAddress inet4=InetAddress.getLocalHost();
            System.out.println(inet4);
            //对象的两个方法
            System.out.println(inet2.getHostName());
            System.out.println(inet2.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
