package com.ft.first.reverseStream;

import org.junit.Test;

import java.io.*;

public class TestFileCharName {
    @Test
    public void textFile() throws IOException {
        //创建InputStreamReader对象，构造方法中传递字节输入流和指定的编码表名称
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("GBK.txt"), "GBK");
        //创建OutputStreamWriter对象，构造方法中传递字节输出流和指定的编码表名称UTF-8
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("UTF_8.txt"), "UTF-8");
        //使用InputStreamReader对象的reader方法读取文件
        int len = 0;
        while ((len = inputStreamReader.read()) != -1) {
            //使用OutputStreamWriter对象中的writer方法，把读取到的数据写入到文件中
            outputStreamWriter.write(len);
        }
        //释放资源
        outputStreamWriter.close();
        inputStreamReader.close();
    }
}
