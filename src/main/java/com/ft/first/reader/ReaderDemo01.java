package com.ft.first.reader;

import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;

/*
    java.io.Reader:字符输入流，是字符输入流的最顶层的父类，定义了一些共性的成员方法。是一个抽象类

    共性的成员方法：
        int read()：读取单个字符并返回读取到的字符。
        int reade(char[] a)：一次读取多个字符，将字符读入到char数组中。
        void close()：关闭该流并释放与之关联的所有资源。

    java.io.FileReader  extends InputStreamReader   extend  Reader
    FileReader：文件字符输入流
    作用：把硬盘文件中的数据，以字符的方式读取到内存中。
    构造方法：
        FileReader(String fileName)：
        FileReader(File file)：
        参数：读取文件的数据源
            String fileName：文件的路径。
            File file：就是一个文件。
    FileReader构造方法的作用：
        1.会创建一个FileReader对象。
        2.会把FileReader对象指向一个要读取的文件。

    字符输入流的使用步骤：
        1.创建FileReader对象，构造方法中绑定要读取的数据源。
        2.使用FIleReader对象中的read读取文件。
        3.释放资源。
 */
public class ReaderDemo01 {

    @Test
    public void ReaderDemo01() throws IOException {
        FileReader fileReader = new FileReader("a.txt");
//        int rest = 0;
//        while ((rest = fileReader.read()) != -1) {
//            System.out.println((char)rest);
//        }
        
        char[] chars=new char[1024];//用来存储读取到的多个字符
        int rest=0;//记录的每次读取到的有效字符个数
        while ((rest=fileReader.read(chars))!=-1){
            /*
                String类的构造方法
                String(char[] value) 把字符数组转换成字符串
                String(char[] value,int offset,int count) 把字符数组中一部份转换成字符串，offset数组的开始索引，count转换的字符串个数。
            */
            System.out.println(new String(chars,0,rest));
        }
        //释放资源
        fileReader.close();
    }
}
