package com.Hewang.java;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * @author Hewang
 * @create 2020-05-15 21:09
 * @title
 */
public class URLTest {
    public static void main(String[] args) throws IOException {
//        URL url = null;
//        try {
//            url = new URL("https://www.bilibili.com/video/BV1zE41197bw?p=753");
//            System.out.println(url.getProtocol());
//            System.out.println(url.getPort());
//            System.out.println(url.getHost());
//            System.out.println(url.getPath());
//            System.out.println(url.getFile());
//            System.out.println(url.getQuery());
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
        URL url = new URL("https://www.bilibili.com/video/BV1zE41197bw?p=753");
        HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
        urlConnection.connect();
        InputStream inputStream = urlConnection.getInputStream();

    }

}
