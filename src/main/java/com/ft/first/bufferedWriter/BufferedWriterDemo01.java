package com.ft.first.bufferedWriter;
/*
    java.io.BufferedWriter extends Writer
    BufferedWriter：字符缓冲输出流
    继承自父类的共性成员方法
        void write(int c)：写入单个字符
        void write(char[] a)：写入字符数组
        abstract  void  write(char[]  a,int  off,int  len)：写入字符数组的某一部分，off数组的开始索引，len写的字符个数。
        void  write(String  str)：写入字符串。
        void  write(String  str,int  off,int  len)：写入字符串的某一部分，off表示字符串的开始索引，len写的字符串的字符个数。
        void  flush()：刷新该流的缓冲。
        void  close()：关闭此流，但是要先刷新它。
    构造方法：
        BufferedWriter(Writer out)：创建一个使用默认大小输出缓冲区的缓冲字符输出流。
        BufferedWriter(Writer out,int size)：创建一个使用给定大小输出缓冲区的新缓冲字符输出流。
        参数：
            Writer out：字符输出流，我们可以传递FileWriter，缓冲流会给FileWriter增加一个缓冲区，提高写入效率。
            int size：指定缓冲区的大小，不写即默认的大小。
    特有的一个成员方法：
        void newline()：写入一个行分隔符，会根据不同的操作系统来写入对应的分隔符。
    使用步骤：
        1.创建一个字符缓冲输出流，构造方法中传递字符输出流。
        2.调用字符输出流中的方法writer把数据写入到内存缓冲区中。
        3.调用字符缓冲输出流中的方法flush，把内存缓冲区中的数据刷新到文件中。
        4.释放资源。
 */

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterDemo01 {
    @Test
    public void TestBufferedWriter() throws IOException {
        //创建一个字符缓冲输出流，构造方法中传递字符输出流。
        BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("c.txt"));
        //调用字符输出流中的方法writer把数据写入到内存缓冲区中。
        for (int i = 0; i < 10; i++) {
            bufferedWriter.write("你好呀！");
            //写入换行符号
            //bufferedWriter.write("\r\n");
            bufferedWriter.newLine();
        }
        //调用字符缓冲输出流中的方法flush，把内存缓冲区中的数据刷新到文件中。
        bufferedWriter.flush();
        //释放资源
        bufferedWriter.close();
    }
}
