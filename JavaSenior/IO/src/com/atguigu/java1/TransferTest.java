package com.atguigu.java1;

import org.junit.Test;

/**
 * @author Hewang
 * @create 2020-05-15 0:17
 * @title  转换流
 * 编码和解码
 * InputStreamReader： 输入字节流转字符流为解码
 * OutputStreamWriter：输出字符流转字节流为编码
 * 可实现将UTF-8编码格式的文件输出为GBK编码格式的文件
 *
 * 关于字符集：涉及到编解码的问题
 *            ASCII码：占一个字节，只用了七位标识
 *            ISO8859-1：拉丁码表，欧洲码表，一个字节，8位
 *            GB2312：中文编码表，最多两个字节编码
 *            GBK：融合更多中文符号，最多两个字节编码
 *            Unicode：国际标准码，目前人类的所有字符，都用两个字节来表示
 *                     具体落地实现为UTF-8/UTF-16等
 *            UTF-8：变长的编码方式
 * 若一个字节首位为零则表示一个字符；
 */
public class TransferTest {
    @Test
    public void test(){
//        FileInputStream fis=new FileInputStream("");
    }
}
