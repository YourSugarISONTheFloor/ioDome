package com.ft.first.inputStream;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * 字节输入流一次可以读取多个字节的方法。
 *      int read(byte[] b)：从此输入流中将最多 b.length 个字节的数据读入一个 byte 数组中。
 * 明确两件事情：
 *      1.方法的参数byte[]的作用？
 *          起到缓冲作用，存储每次读取到的多个字节
 *          数组长度一般定义为1024(1kb)或者是1024的整数倍
 *      2.方法的返回值int是什么？
 *          每次读取到的有效字节个数
 *String类的构造方法：
 *  String(byte[] bytes)：通过使用平台的默认字符集解码指定的 byte 数组，构造一个新的 String。
 *  把字节数组转为字符串。
 *  String(byte[] bytes, int offset, int length)：通过使用平台的默认字符集解码指定的 byte 子数组，构造一个新的 String
 *  把字节数组的一部分转为字符串。
 *  offset：表示数组的开始位置、length：表示转换的字节个数
 */

public class InputStreamDemo02 {
    @Test
    public void TestDemo01() throws IOException {
        //创建FileInputStream对象，构造方法中绑定要读取的数据源
        FileInputStream fileInputStream=new FileInputStream("a.txt");//内容为ABCDE
        //使用FileInputStream对象中的方法read读取文件
        //int read(byte[] b)：从此输入流中将最多 b.length 个字节的数据读入一个 byte 数组中。
        byte[] bytes=new byte[2];
        //byte[] bytes=new byte[1024];
        //数组：起缓冲作用，存储读取到的多个字节
        int read = fileInputStream.read(bytes);//read：读取的有效字节个数
        System.out.println(read);//2,每次读取字节的个数
        System.out.println(Arrays.toString(bytes));//[65,66]
        System.out.println(new String(bytes));//AB

        read = fileInputStream.read(bytes);
        System.out.println(read);//2
        System.out.println(new String(bytes));//CD

        read = fileInputStream.read(bytes);
        System.out.println(read);//1
        System.out.println(new String(bytes));//ED
        read = fileInputStream.read(bytes);
        System.out.println(read);//-1
        System.out.println(new String(bytes));//ED


        /**
         * 发现以上读取的是一个重复的过程，可以使用循环优化
         * 不知道文件中有多少字节，所以使用while循环
         * while循环的结束的条件：读取到-1结束
         */
        byte[] bytes1=new byte[1024];//1kb 存储读取到的多个字节
        int len=0;//记录每次读取的有效字节个数
        while ((len=fileInputStream.read(bytes1))!=-1){
            //0,len代表读到了好多个字节就输出好多，或者会有多余的空格
            //把字节数组的一部分转为字符串。
            System.out.println(new String(bytes1,0,len));
        }

        //释放资源
        fileInputStream.close();

    }
}
