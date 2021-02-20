package com.ft.first.reverseStream;

import org.apache.coyote.http11.InputFilter;
import org.junit.Test;

import java.io.*;

/**
 * java.io.InputStreamReader extends Reader
 * InputStreamReader:是字节流通向字符流的桥梁，它使用指定charset 读取字节并转为字符(解码)
 * 共性的成员方法：
 * int read()：读取单个字符并返回读取到的字符。
 * int reade(char[] a)：一次读取多个字符，将字符读入到char数组中。
 * void close()：关闭该流并释放与之关联的所有资源。
 * 构造方法：
 * InputStreamReader(InputStream in)创建一个使用默认字符集的InputStream
 * InputStreamReader(InputStream in,String charName)创建一个使用指定字符集的InputStream
 * 参数：
 * InputStream in:字节输入流，用来读取文件中保存的字节
 * String charName:指定的编码表名称，不区分大小写。我们可以是utf-8/UTF-8,……不指定默认使用UFT-8
 * 使用步骤：
 * 1.创建一个 InputStreamReader对象，构造方法中传递字节输入流和指定编码表的名称
 * 2.使用 InputStreamReader对象中的reader读取文件
 * 3.关闭资源
 * 注意事项：
 * 构造方法中指定的编码表的名称要和文件的编码相同，否则会发送乱码
 */
public class DemoInputStreamReader {
    @Test
    public void Test() throws IOException {
        //reader_utf_8();
        reader_GBK();
    }

    /**
     * 使用转换流inputStreamReader读取UTF-8格式的文件
     */
    public void reader_utf_8() throws IOException {
        //创建一个 InputStreamReader对象，构造方法中传递字节输入流和指定编码表的名称
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("utf-8.txt"), "utf-8");
        //使用 InputStreamReader对象中的reader读取文件
        int len=0;
        while ((len=inputStreamReader.read())!=-1){
            System.out.println((char) len);
        }
        //是释放资源
        inputStreamReader.close();
    }

    private void reader_GBK() throws IOException {
        //创建一个 InputStreamReader对象，构造方法中传递字节输入流和指定编码表的名称
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("utf-8.txt"), "GBK");
        //使用 InputStreamReader对象中的reader读取文件
        int len=0;
        while ((len=inputStreamReader.read())!=-1){
            System.out.println((char) len);
        }
        //是释放资源
        inputStreamReader.close();
    }
}
