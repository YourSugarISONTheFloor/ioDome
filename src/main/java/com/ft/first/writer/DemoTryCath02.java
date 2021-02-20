package com.ft.first.writer;
/*
    JDK9的新特性
    try的前边我们可以定义流对象
    在try后边的()中可以直接引用流对象(变量名)
    在try代码执行完毕之后，流对象也可以释放掉，不用写finally
    格式：
        A a=new A();
        B b=new B();
        try(a,b){
            可能产生异常的代码
        }catch(异常类变量 变量名){
            异常处理逻辑
        }
 */

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DemoTryCath02 {
    @Test
    public void TestDemoTry() throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("D:\\aaa.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\workPaper\\aaa.jpg");
//        try(fileInputStream;fileOutputStream){
//            byte[] bytes = new byte[1024 * 1024];
//            //一读一写
//            int rest = 0;//每次读取的有效字节个数
//            while ((rest = fileInputStream.read()) != -1) {
//                fileOutputStream.write(bytes, 0, rest);
//            }
//        }catch (IOException e){
//            System.out.println(e);
//        }
    }
}
