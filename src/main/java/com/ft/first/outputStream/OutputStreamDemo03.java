package com.ft.first.outputStream;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;

public class OutputStreamDemo03 {
    /**
     * FileOutputStream(String name, boolean append):
     *      创建一个向具有指定 name 的文件中写入数据的输出文件流。
     * FileOutputStream(File file, boolean append):
     *      创建一个向指定 File 对象表示的文件中写入数据的文件输出流。
     * 参数：
     *      String name,File file：写入数据的目的地
     *      boolean append：追加写入的开关
     *          true：创建对象不会覆盖原文件，继续再后面追加写入
     *          false：创建对象时会覆盖原文件，即创建一个新文件覆盖原文件
     * 写换行符号：
     *      windows：\r\n
     *      Linux：\n
     *      mac：\r
     */
    @Test
    public void FileAppend() throws IOException {
        FileOutputStream fileOutputStream=new FileOutputStream("a.txt",true);
        fileOutputStream.write("你好棒呀！".getBytes());
        fileOutputStream.close();
    }
    @Test
    public void FileWritern() throws IOException {
        FileOutputStream fileOutputStream=new FileOutputStream("a.txt",true);
        for (int i = 0; i < 10; i++) {
            fileOutputStream.write("我换行啦".getBytes());
            fileOutputStream.write("\r\n".getBytes());
        }
        fileOutputStream.close();
    }
}
