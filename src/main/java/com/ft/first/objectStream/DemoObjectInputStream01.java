package com.ft.first.objectStream;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * java.io.ObjectInputStream extends InputStream
 * ObjectInputStream:对象反序列化流
 * 作用：把文件保存的对象，以流的方式读取出来使用
 *
 * 构造方法：
 *      ObjectInputStream(InputStream in):创建一个指定InputStream读取的ObjectInputStream
 *      参数：
 *          InputStream in：字节输入流。
 * 特有的方法：
 *      Object readObject()：从ObjectInputStream读取对象
 * 使用步骤：
 *      1.创建ObjectInputStream对象，构造方法中传递字节输入流。
 *      2.使用ObjectInputStream对象的方法readObject读取保存对象的文件
 *      3.释放资源
 *      4.使用读取出来的对象(打印)
 * readObject()声明抛出了ClassNotFoundException(class文件找不到异常)
 * 当不存在对象的class文件时抛出此异常
 * 反序列化的前期：
 *      1.类必须实现Serializable
 *      2.必须存在类对应的class文件
 */
public class DemoObjectInputStream01 {
    @Test
    public void TestObjectInputStream() throws IOException, ClassNotFoundException {
        //创建ObjectInputStream对象，构造方法中传递字节输入流。
        ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream("student.txt"));
        //使用ObjectInputStream对象的方法readObject读取保存对象的文件
        Object obj=objectInputStream.readObject();
        //释放资源
        objectInputStream.close();
        //使用读取出来的对象(打印)
        System.out.println(obj);
        Student student=(Student) obj;
        System.out.println(student.getName());
        System.out.println(student.getAge());

    }
}
