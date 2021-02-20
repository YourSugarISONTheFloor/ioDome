package com.ft.first.writer;
/*
    在JDK1.7之前我们使用try catch finally处理流中的异常
    格式：
        try{
            可能产生异常的代码块
        }catch(异常类的变量 变量名){
            异常的处理原则
        }finally{
            一定会执行的代码
            资源释放
        }
 */

import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;

public class DemoTryCath {
    @Test
    public void TryTest() {
        //提高fileWriter的作用域，让finally可以使用
        //变量在定义的时候可以没有值，但是在使用的时候它必须有值
        //fileWriter=new FileWriter("b.txt",true);执行失败的话fileWriter就没有值，fileWriter。close()就会报错。
        FileWriter fileWriter = null;
        try {
            //可能产生异常的代码块
            fileWriter = new FileWriter("b.txt", true);
            for (int i = 0; i < 10; i++) {
                fileWriter.write("你好" + i + "\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e);
        } finally {
            //一定会执行的代码
            //创建对象失败了，fileWriter的默认值是null，null是不能调用方法的，会抛出NullPointerException，需要增加一个判断，不是null再把资源释放。
            if (fileWriter != null) {
                try {
                    //fileWriter.close();方法声明抛出了IOException异常对象，所有我们就处理这个异常对象，要么throws，要么try……catch
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}