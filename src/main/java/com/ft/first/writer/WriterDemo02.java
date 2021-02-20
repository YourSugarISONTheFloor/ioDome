package com.ft.first.writer;
/*
    字符输出流写数据的其他方法
        void write(char[] a)：写入字符数组
        abstract  void  write(char[]  a,int  off,int  len)：写入字符数组的某一部分，off数组的开始索引，len写的字符个数。
        void  write(String  str)：写入字符串。
        void  write(String  str,int  off,int  len)：写入字符串的某一部分，off表示字符串的开始索引，len写的字符串的字符个数。

 */

import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;

public class WriterDemo02 {
    @Test
    public void fileWrite() throws IOException {
        FileWriter fileWriter = new FileWriter("b.txt");
        char[] chars = {'a', 'b', 'c', 'd', 'e'};
        //void write(char[] a)：写入字符数组
        fileWriter.write(chars);//abcde
        //abstract  void  write(char[]  a,int  off,int  len)：写入字符数组的某一部分，off数组的开始索引，len写的字符个数。
        //从第一个索引开始写，写入3个字符
        fileWriter.write(chars, 1, 3);
        //void  write(String  str)：写入字符串。
        fileWriter.write("你好");
        //void  write(String  str,int  off,int  len)：写入字符串的某一部分，off表示字符串的开始索引，len写的字符串的字符个数。
        fileWriter.write("今天又是掉头发的一天",4,3);
        //属性缓冲区
        fileWriter.flush();
        //关闭流对象
        fileWriter.close();
    }
}
