package com.ft.first.objectStream;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 练习：序列化集合
 * 当我们想在文件中保存多个对象的时候，可以把多个对象存储到一个集合中，对集合进行序列化和反序列化
 * 分析：
 * 1.定义一个存储Student对象的ArrayList集合
 * 2.往ArrayList集合中存储Student对象
 * 3.创建一个序列化流ObjectOutputStream对象
 * 4.使用ObjectOutputStream对象中的方法writeObject，对集合进行序列化
 * 5.创建一个反序列化ObjectInputStream对象
 * 6.使用ObjectInputStream对象中的方法readObject，读取文件中保存的集合
 * 7.把Object类型的集合转换为ArrayList类型
 * 8.遍历ArrayList集合
 * 9.释放资源
 */
public class DemoObjectInputStream02 {
    @Test
    public void testListStudent() throws IOException, ClassNotFoundException {
        //定义一个存储Student对象的ArrayList集合
        List list = new ArrayList();
        //往ArrayList集合中存储Student对象
        list.add(new Student("张三", 18));
        list.add(new Student("李四", 19));
        list.add(new Student("王五", 20));
        //创建一个序列化流ObjectOutputStream对象
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("listStudent.txt"));
        //使用ObjectOutputStream对象中的方法writeObject，对集合进行序列化
        objectOutputStream.writeObject(list);
        //创建一个反序列化ObjectInputStream对象
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("listStudent.txt"));
        //使用ObjectInputStream对象中的方法readObject，读取文件中保存的集合
        Object obj = objectInputStream.readObject();
        //把Object类型的集合转换为ArrayList类型
        ArrayList<Student> list1=(ArrayList<Student>)obj;
        //遍历ArrayList集合
        for(Student s:list1){
            System.out.println(s);
        }
        //释放资源
        objectInputStream.close();
        objectOutputStream.close();
    }
}