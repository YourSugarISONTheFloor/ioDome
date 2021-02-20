package com.ft.first.reverseStream;

import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;

/**
 * FileReader可以读取默认编码格式(UTF-8)的文件
 * FileReader读取系统，默认编码（中文GBK）会产生乱码
 */
public class DemoFileStream {
    @Test
    public void Test() throws IOException {
        FileReader fileReader=new FileReader("helloGBK.txt");
        int len=0;
        while ((len=fileReader.read())!=-1){
            System.out.println((char) len);
        }
        fileReader.close();
    }
}
