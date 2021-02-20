package com.ft.first.writer;

/*
    续写和换行：
    续写和换行使用两个参数的构造方法：
        FileWriter(String fileName,boolean append)
        FileWriter(File file,boolean append)
        参数：String fileName，File file表示写入数据的目的地。
        boolean append：续写的开关  true：不会创建新的文件覆盖原来的文件，可以续写。false：创建新的文件覆盖原文件。
    换行：换行符号
        windows：\r\n
        linux：\n
        mac：\r
 */

import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;

public class WriterDemo03 {
    @Test
    public void writerFileTest() throws IOException {
        FileWriter fileWriter=new FileWriter("b.txt",true);
        for (int i = 0; i < 10; i++) {
            fileWriter.write("Hello,Word"+i);
            //写入换行符号
            fileWriter.write("\r\n");
        }
        fileWriter.close();
    }
}