package com.ft.first.bufferedStream;
/*
    java.io.BufferedInputStream extends InputStream
    BufferedInputStream：字节缓冲输出流
    继承自父类的成员方法：
        int read():从输入流中读取数据的下一个字节
        int read(byte[] b)：从此输入流中将最多 b.length 个字节的数据读入一个 byte 数组中。
        long skip(long n)： 从输入流中跳过并丢弃 n 个字节的数据。
        int read(byte[] b, int off, int len)：从此输入流中将最多 len 个字节的数据读入一个 byte 数组中。
        void close()：关闭此文件输入流并释放与此流有关的所有系统资源。
    构造方法：
        BufferedInputStream(InputStream in)：创建一个BufferedInputStream并保存其参数，即输入流in，以便将来使用。
        BufferedInputStream(InputStream in,int size)：创建具有指定缓冲区大小的BufferedInputStream并保存其参数，即输入流in，以便将来使用。
        参数：
            InputStream in：我们可以传递FileInputStream对象，缓冲流会给FileInputStream增加一个缓冲区，提高FileInputStream的读取效率
            int size：指定缓冲流的内部缓冲区大小，不指定就是默认大小
    使用步骤：
        1.创建一个FileInputStream对象，构造方法中绑定要读取的数据源
        2.创建BufferedInputStream对象，构造方法中传递FileInputStream对象，提高FileInputStream的读取效率
        3.使用BufferedInputStream对象中的方法read，读取文件
        4。释放资源
 */
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class BufferedInputStreamTest {
    @Test
    public void TestBufferedInputStream01() throws IOException {
        //创建一个FileInputStream对象，构造方法中绑定要读取的数据源
        FileInputStream fileInputStream = new FileInputStream("c.txt");
        //创建BufferedInputStream对象，构造方法中传递FileInputStream对象，提高InputStream的读取效率
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        //使用BufferedInputStream对象中的方法read，读取文件
        int len = 0;
        while ((len = bufferedInputStream.read()) != -1) {
            System.out.println(len);
        }
        //存储每次读取的数据
        byte[] bytes = new byte[1024];
        //记录每次读取的有效字节个数
        int aaa = 0;
        while ((aaa = bufferedInputStream.read(bytes)) != -1) {
            //把数组转换为字符串，从0开始到有效的字节个数
            System.out.println(new String(bytes, 0, aaa));
        }
        //关闭缓冲流，基本流就会跟着关闭
        bufferedInputStream.close();
    }
}