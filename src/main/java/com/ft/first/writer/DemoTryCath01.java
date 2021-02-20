package com.ft.first.writer;
/*
    JDk7的新特性
    再try的后边可以增加一个()，在括号中可以定义流对象
    那么这个流对象的作用域就在try中有效
    try中的代码执行完毕，会自动把流对象释放，不用写finally
    格式：
        try(定义流对象;定义流对象……){
            可能产生异常的代码块
        }catch(异常类变量 变量名){
            异常处理的逻辑
        }
 */

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DemoTryCath01 {
    @Test
    public void TryTest() {
        //这样流对象就不用关闭，它会自动关闭，作用域只在try的大括号中
        try (FileInputStream fileInputStream = new FileInputStream("D:\\aaa.jpg");
             FileOutputStream fileOutputStream = new FileOutputStream("D:\\workPaper\\aaa.jpg")) {
            byte[] bytes = new byte[1024 * 1024];
            //一读一写
            int rest = 0;//每次读取的有效字节个数
            while ((rest = fileInputStream.read()) != -1) {
                fileOutputStream.write(bytes, 0, rest);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}