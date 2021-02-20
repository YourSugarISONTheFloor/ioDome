package com.ft.first.reverseStream;

import org.junit.Test;

import java.io.*;

/**
 * java.io.OutputStreamWriter extends Writer
 * OutputStreamWriter:是字符通向字节的桥梁，可以使用指定的charName 将要写入的流中的字符编码转为字节（编码）
 * 继承自父类的共性方法：
 *         void write(int c)：写入单个字符
 *         void write(char[] a)：写入字符数组
 *         abstract  void  write(char[]  a,int  off,int  len)：写入字符数组的某一部分，off数组的开始索引，len写的字符个数。
 *         void  write(String  str)：写入字符串。
 *         void  write(String  str,int  off,int  len)：写入字符串的某一部分，off表示字符串的开始索引，len写的字符串的字符个数。
 *         void  flush()：刷新该流的缓冲。
 *         void  close()：关闭此流，但是要先刷新它。
 * 构造方法：
 *      OutputStreamWriter(OutputStream out)创建使用默认编码的OutputStreamWriter
 *      OutputStreamWriter(OutputStream out,String charName)创建使用指定的字符集的OutputStreamWriter
 *      参数：
 *          OutputStream out：字节输出流，可以用来些转换后的字节到文件中。
 *          String charName：指定的编码表名称，不区分大小写。我们可以是utf-8/UTF-8,……不指定默认使用UFT-8
 *      使用步骤：
 *          1.创建一个 OutputStreamWriter对象，构造方法中传递字节输出流和指定编码表的名称
 *          2.使用 OutputStreamWriter对象中的writer，把字符转换为字节存储到缓冲区中（编码）
 *          3.使用 OutputStreamWriter对象中的方法flush，把内存缓冲区中的字节刷新到文件中（使用字节流写字节的过程）
 *          4.关闭资源
 */
public class DemoOutputStreamWriter {
    @Test
    public void Test() throws IOException {
        //writer_utf_8();
        writer_GBK();
    }

    /**
     * 使用转换流OutputStreamWriter写UTF-8格式的文件
     */
    public void writer_utf_8() throws IOException {
        //创建一个 OutputStreamWriter对象，构造方法中传递字节输出流和指定编码表的名称
        OutputStreamWriter outputStreamWriter=new OutputStreamWriter(new FileOutputStream("utf-8.txt"),"utf-8");
        //使用 OutputStreamWriter对象中的writer，把字符转换为字节存储到缓冲区中（编码）
        outputStreamWriter.write("你好");
        //使用 OutputStreamWriter对象中的方法flush，把内存缓冲区中的字节刷新到文件中（使用字节流写字节的过程）
        outputStreamWriter.flush();
        //是释放资源
        outputStreamWriter.close();
    }

    private void writer_GBK() throws IOException {
        //创建一个 OutputStreamWriter对象，构造方法中传递字节输出流和指定编码表的名称
        OutputStreamWriter outputStreamWriter=new OutputStreamWriter(new FileOutputStream("utf-8.txt"),"GBK");
        //使用 OutputStreamWriter对象中的writer，把字符转换为字节存储到缓冲区中（编码）
        outputStreamWriter.write("你好");
        //使用 OutputStreamWriter对象中的方法flush，把内存缓冲区中的字节刷新到文件中（使用字节流写字节的过程）
        outputStreamWriter.flush();
        //是释放资源
        outputStreamWriter.close();
    }
}
