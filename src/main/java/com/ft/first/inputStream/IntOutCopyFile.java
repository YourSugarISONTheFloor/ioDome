package com.ft.first.inputStream;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件复制练习：一读一写
 * 明确：
 * 数据源：D:\\aaa.jpg
 * 数据的目的地：D:\\workPaper\\aaa.jpg
 * 文件复制的步骤：
 * 1.创建一个字节输入流对象，构造方法中绑定要读取的数据源
 * 2.创建一个字节输出流对象，构造方法中绑定要写入的目的地
 * 3.使用字节输入流对象中的方法read读取文件
 * 4.使用字节输出流对象中的方法write，把读取到的字节写入到目的地的文件中
 * 5.释放资源
 */

public class IntOutCopyFile {

    @Test
    public void copyFile() throws IOException {
        //定义一个毫秒值记录程序消耗的时间
        long start = System.currentTimeMillis();

        //创建一个字节输入流对象，构造方法中绑定要读取的数据源
        FileInputStream fileInputStream = new FileInputStream("D:\\aaa.jpg");
        //创建一个字节输出流对象，构造方法中绑定要写入的目的地
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\workPaper\\aaa.jpg");
        //一次读取一个字节、一次写入一个字节

        //使用字节输入流对象中的方法read读取文件
        int len = 0;
        while ((len = fileInputStream.read()) != -1) {
            //使用字节输出流对象中的方法write，把读取到的字节写入到目的地的文件中
            fileOutputStream.write(len);
        }

        //使用数组缓冲读取多个字节，写入多个字节
        byte[] bytes = new byte[1024*1024];
        //一读一写
        int rest = 0;//每次读取的有效字节个数
        while ((rest = fileInputStream.read()) != -1) {
            //使用字节输出流对象中的方法write，把读取到的字节写入到目的地的文件中
            fileOutputStream.write(bytes, 0, rest);//写也写入有效的个数
        }
        //释放资源(先关闭写的流，再关闭读的流) 写完了一定读完了，但读完了不一定写完了
        fileOutputStream.close();
        fileInputStream.close();
        long end = System.currentTimeMillis();
        System.out.println("文件复制共耗时：" + (end - start) + "ms");
    }
}
