package com.ft.first.outputStream;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

public class OutputStreamDemo02 {
    /*
    void write(byte[] b)：将 b.length 个字节从指定的 byte 数组写入此输出流。
    void write(byte[] b, int off, int len)：将指定 byte 数组中从偏移量 off 开始的 len 个字节写入此输出流。
    */
    @Test
    public void FileOutputStream01() {
        try {
            //创建FileOutputStream对象，构造方法中绑定要写入数据的目的地
            FileOutputStream fos = new FileOutputStream("b.txt");
            //调用FileOutputStream对象中的方法write，把数据写入到文件中
            //在文件中显示100，写几个字节？

            fos.write(49);
            fos.write(48);
            fos.write(48);
            /*
            void write(byte[] b)：将 b.length 个字节从指定的 byte 数组写入此输出流。
            一次写多个字节：
                如果写的第一个字节是正数(0-127),那么显示的时候会查询ASCII表
                如果写的第一个字节是负数,那第一个字节会和第二个字节，两个字节组成一个中文显示，系统查询默认编码表(GBK)
            */
            byte[] bytes = {65, 66, 67, 68, 69};
            //byte[] bytes={-65,-66,-67,68,69};
            fos.write(bytes);
            /*
            void write(byte[] b, int off, int len)：将指定 byte 数组中从偏移量 off 开始的 len 个字节写入此输出流。
                int off:数组的开始索引
                int len：写几个字节
            */
            //索引从0开始
            fos.write(bytes, 1, 2);

            /*
            写入字符的方法：可以使用String类中的方法把字符串，转换成字节数组
            byte[] getBytes():把字符串转换为字符数组
            */
            //UTF-8中3个字节是一个中文，GBK中2个字节是一个中文
            byte[] byte2="你好".getBytes();//你好==[-28, -67, -96, -27, -91, -67]
            System.out.println(Arrays.toString(byte2));
            fos.write(byte2);
            //释放资源
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
