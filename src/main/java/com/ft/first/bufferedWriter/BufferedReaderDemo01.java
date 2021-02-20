package com.ft.first.bufferedWriter;
/*
    java.io.BufferedReader extends Reader
    继承自父类的共性成员方法：
        int read()：读取单个字符并返回读取到的字符。
        int reade(char[] a)：一次读取多个字符，将字符读入到char数组中。
        void close()：关闭该流并释放与之关联的所有资源。
    构造方法：
        BufferedReader(Reader in)：创建一个使用默认大小输入缓冲区的缓冲字符输入流。
        BufferedReader(Reader in,int size)：创建一个使用指定大小输入缓冲区的字符输入流。
        参数：
            Reader in：字符输入流，我们可以传递FileReader，缓冲流会给FileReader增加一个缓冲区，会提高FileReader的读取效率。
        特有的成员方法：
            public String readLine()：读取一行文本。读取一行数据。
            行的终止符号：通过下列字符之一即可认为某行已经结束：换行('\n')、回车('\r')或回车后面跟着换行('\r\n')
        返回值：包含该行内容，不包含任何终止符号，如果已经到达流末尾，则返回null。

        使用步骤：
            1.创建一个字符缓冲输入流，构造方法中传递字符输入流。
            2.使用字符缓冲输入流对象中的方法read/readLine读取文本。
            3.释放资源。
 */

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderDemo01 {
    @Test
    public void TestBufferedReader() throws IOException {
        //创建一个字符缓冲输入流，构造方法中传递字符输入流。
        BufferedReader bufferedReader = new BufferedReader(new FileReader("c.txt"));
        //使用字符缓冲输入流对象中的方法read/readLine读取文本。
        String line = null;
        line = bufferedReader.readLine();
        System.out.println(line);
        line = bufferedReader.readLine();
        System.out.println(line);
        line = bufferedReader.readLine();
        System.out.println(line);
        line = bufferedReader.readLine();
        System.out.println(line);

        //发现以上读取是一个重复的过程，可以使用while循环，不知道读取到那代表读取完毕？
        //while的结束判断为，读取到null代表读取完了。
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        //释放资源。
        bufferedReader.close();
    }
}
