package com.ft.first.bufferedStream;

import org.junit.Test;

import java.io.*;

/**
 * 文件复制练习：一读一写
 * 明确：
 * 数据源：D:\\aaa.jpg
 * 数据的目的地：D:\\workPaper\\aaa.jpg
 * 文件复制的步骤：
 * 1.创建字节缓冲输入流对象，构造方法中传递字节输入流
 * 2.创建字节缓冲输出流对象，构造方法中传递字节输出流
 * 3.使用字节缓冲输出流对象中的方法read，读取文件
 * 4.使用字节缓冲输出流中的方法write，把读取的数据写入到内部缓冲区中
 * 5.释放资源(会把缓冲区的数据，刷新到文件中)
 */

public class BufferedCopyFile {
    @Test
    public void CopyFile() throws IOException {
        //获取开始的毫秒值
        long start = System.currentTimeMillis();
        //创建字节缓冲输入流对象，构造方法中传递字节输入流
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("D:\\aaa.jpg"));
        //创建字节缓冲输出流对象，构造方法中传递字节输出流
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("D:\\workPaper\\aaa.jpg"));
        //使用字节缓冲输出流对象中的方法read，读取文件
        //一次读取一个字节写入一个字节
        int len = 0;
        while ((len = bufferedInputStream.read()) != -1) {
            //一次写入一个字节
            bufferedOutputStream.write(len);
        }
        //使用数组缓冲区读取多个字节，写入多个字节
        byte[] bytes = new byte[1024];
        int size = 0;
        while ((size = bufferedInputStream.read(bytes)) != -1) {
            //一次写入一个数组的字节
            bufferedOutputStream.write(bytes, 0, size);
        }
        //释放资源
        bufferedOutputStream.close();
        bufferedInputStream.close();
        //获取结束时的毫秒值
        long end = System.currentTimeMillis();
        System.out.println("所花费的时间：" + (end - start) + "ms");
    }
}
