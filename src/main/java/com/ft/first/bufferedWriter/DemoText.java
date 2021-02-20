package com.ft.first.bufferedWriter;

import org.junit.Test;

import java.io.*;
import java.util.HashMap;

/*
    练习：
        对文本的内容进行排序
        按照1,2,3,……
    分析：
        1.创建一个HashMap集合对象，可以存储每行文本的序号(1,2,3,……);value:存储每行文本。
        2.创建字符缓冲输入流对象，构造方法中绑定字符输入流。
        3.创建字符缓冲输出流，构造方法中绑定字符输出流。
        4.使用字符缓冲输入流中的方法readLine，逐行读取文本。
        5.对读取到的文本进行切割，获取行中的序号和文本的内容。
        6.把切割好的序号和文本的内容存储HashMap集合中(key序号是有序的，会自动排序1,2,3,4,……)。
        7.遍历HashMap集合，获取每一个键值对。
        8.把每个键值对，拼接到文本行。
        9.把拼接好的文本，使用字符缓冲输出流中方法write，写入到文件中。
        10.释放资源。
 */
public class DemoText {
    @Test
    public void TestDemo() throws IOException {
        //创建一个HashMap集合对象，可以存储每行文本的序号(1,2,3,……);value:存储每行文本。
        HashMap<String,String>map=new HashMap<>();
        //创建字符缓冲输入流对象，构造方法中绑定字符输入流。
        BufferedReader bufferedReader=new BufferedReader(new FileReader("in.txt"));
        //创建字符缓冲输出流，构造方法中绑定字符输出流。
        BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("out.txt"));
        //使用字符缓冲输入流中的方法readLine，逐行读取文本。
        String line;
        while ((line=bufferedReader.readLine())!=null){
            //对读取到的文本进行切割，获取行中的序号和文本的内容。
            String[] array = line.split("\\.");
            //把切割好的序号和文本的内容存储HashMap集合中(key序号是有序的，会自动排序1,2,3,4,……)。
            map.put(array[0],array[1]);
        }
        //遍历HashMap集合，获取每一个键值对。
        for(String key:map.keySet()){
            String value=map.get(key);
            //把每个键值对，拼接到文本行。
            line=key+"."+ value;
            //把拼接好的文本，使用字符缓冲输出流中方法write，写入到文件中。
            bufferedWriter.write(line);
            //写一个换行
            bufferedWriter.newLine();
        }
        //释放资源。
        bufferedWriter.close();
        bufferedReader.close();
    }
}
