package com.ft.first.inputStream;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * java.io.InputStream：字节输入流
 * 此抽象类是表示字节输入流的所有超类
 * <p>
 * 定义了所有子类的共性方法
 * int read():从输入流中读取数据的下一个字节
 * int read(byte[] b)：从此输入流中将最多 b.length 个字节的数据读入一个 byte 数组中。
 * long skip(long n)： 从输入流中跳过并丢弃 n 个字节的数据。
 * int read(byte[] b, int off, int len)：从此输入流中将最多 len 个字节的数据读入一个 byte 数组中。
 * void close()：关闭此文件输入流并释放与此流有关的所有系统资源。
 * <p>
 * java.io.FileInputStream extends InputStream
 * FileInputStream：文件字节输入流
 * 作用：把硬盘文件中的数据读取到内存中
 * 构造方法：
 * FileInputStream(String name)：
 * FileInputStream(File file)：
 * 参数：就是读取文件的数据原
 * String name：文件的路径。
 * File file：读取的文件
 * 构造方法的作用：
 * 1.创建一个FileInputStream对象。
 * 2.会把FileInputStream对象指向构造方法中要读取的文件。
 * 读取数据的原理(硬盘-->内存)：
 * java程序-->JVM-->OS-->OS读取方法-->读取文件
 * 字节输入流的使用步骤（重点）：
 * 1.创建FileInputStream对象，构造方法中绑定要读取的数据源
 * 2.使用FIleInputStream对象中的read，读取文件
 * 3.释放资源
 */

public class InputStreamDemo01 {

    @Test
    public void inputOne() throws IOException {
        //创建FileInputStream对象，构造方法中绑定要读取的数据源
        FileInputStream fileInputStream = new FileInputStream("b.txt");//b.txt文件内容为  abc
        //使用FIleInputStream对象中的read，读取文件
        //int read()读取文件中的一个字节并返回，读取到文件的末尾它会返回-1
        int read = fileInputStream.read();
        System.out.println(read);//返回字节对应的编码数字      97
        int read1 = fileInputStream.read();
        System.out.println(read1);//98
        int read2 = fileInputStream.read();
        System.out.println(read2);//99
        int read3 = fileInputStream.read();
        System.out.println(read3);//-1

        /**
         * 发现以上读取文件是一个重复的过程，所以可以使用循环
         * 不知道文件中有多少个字节，可以使用while循环
         * while循环结束条件，读取到-1的时候结束，及没有字节可以读取了
         *
         * 布尔表达式：(len=fileInputStream.read())!=-1
         *  1.fileInputStream.read()：读取字节。
         *  2.len=fileInputStream.read()：把读取到的字节赋值给len。
         *  3.(len=fileInputStream.read())!=-1：判断变量len是否不等于-1.
         */
        //定义一个int数据，记录读取到的字节
        int len;
        while ((len = fileInputStream.read()) != -1) {
            System.out.print((char) len);
        }
        //释放资源
        fileInputStream.close();
    }
}
