package com.ft.first.properties;
/*
    java.util.Properties集合 extends Hashtable<Object,Object> implements Map<K,V>
    Properties 类表示了一个持久的属性集。Properties 可保存在流中或从流中加载。属性列表中每个键及其对应值都是一个字符串。
    Properties集合是一个唯一和IO流相结合的集合
        可以使用Properties集合中的方法store，把集合中的临时数据，持久化写入到硬盘中存储
        可以使用Properties集合中的方法load，把硬盘中保存的文件(键值对)，读取到集合中使用
    Properties集合是一个双列集合，key和value默认都是字符串
 */

import org.junit.Test;

import java.io.*;
import java.util.Properties;
import java.util.Set;

public class TestProperties01 {
    /*
        使用Properties集合存储数据，遍历取出Properties集合中的数据。
        Properties集合是一个双列集合，key和value默认都是字符串。
        Properties集合中有一些操作字符串的特有方法。
            Object setProperty(String key, String value)：调用 Hashtable 的方法 put。
            String getProperty(String key)：用指定的键在此属性列表中搜索属性。通过key找value，相当于Map中的get方法
            Set<String> stringPropertyNames()：返回此属性列表中的键集，其中该键及其对应值是字符串，如果在主属性列表中未找到同名的键，则还包括默认属性列表中不同的键。相当于Map中的keySet方法
     */
    @Test
    public void TestProp() {
        //创建Properties集合对象
        Properties properties = new Properties();
        //使用setProperty往集合中添加数据
        properties.setProperty("IE", "10086");
        properties.setProperty("Goog", "10001");
        properties.setProperty("Houfu", "10010");
        //properties.put(1,true);
        //使用stringPropertyNames()把Properties集合中的键取出，存储到set集合中
        Set<String> set = properties.stringPropertyNames();
        //遍历Set集合，取出的properties集合中的每一个键
        for (String key : set) {
            //使用getProperty(String key)方法通过kay获取value
            System.out.println("properties中的键值对" + key + ":" + properties.getProperty(key));
        }
    }

    /*
        可以使用Properties集合中的方法store，把集合中的临时数据，持久化写入到硬盘中存储。
        void store(OutputStream out,String comments)
        void store(Writer writer,String comments)
        参数：
            OutputStream out：字节输出流，不能写中文。
            Writer writer：字符输出流，可以写中文。
            String comments：用来解释说明保存的文件是干什么用的。
                不能使用中文，会产生乱码，默认是Unicode编码。
                一般使用""空字符串。
        使用步骤：
            1.创建Properties集合对象，添加数据
            2.创建字节输出流/字符输出流对象，构造方法中绑定要输出的目的地
            3.使用Properties集合中的方法store，把集合中的临时数据，持久化到硬盘中。
            4.释放资源。
     */
    @Test
    public void TestProp02() throws IOException {
        //创建Properties集合对象
        Properties properties = new Properties();
        //使用setProperty往集合中添加数据
        properties.setProperty("IE", "10086");
        properties.setProperty("谷歌", "10001");
        properties.setProperty("Houfu", "火狐");
        //创建字节输出流/字符输出流对象，构造方法中绑定要输出的目的地

        //字符输出流
        FileWriter fileWriter = new FileWriter("prop.txt");
        //使用Properties集合中的方法store，把集合中的临时数据，持久化到硬盘中。
        properties.store(fileWriter, "");
        //释放资源
        fileWriter.close();

        //字节输出流
        //properties.store(new FileOutputStream("prop.txt"), "");
    }

    /*
        可以使用Properties集合中的方法load，把硬盘中保存的文件(键值对)，读取到集合中使用
        void load(InputStream inStream)
        void load(Reader reader)
        参数：
            InputStream inStream：字节输入流，不能读取含有中文的键值对。
            Reader reader：字符输入流，能读取含有中文的键值对。
        使用步骤：
            1.创建Properties集合对象
            2.使用Properties集合对象中的方法load读取保存键值对的文件
            3.遍历properties集合
        注意：
            1.存储键值对的文件中，键与值的连接符号可以使用=,空格(其他符号)。
            2.存储键值对的文件中，可以使用#来进行注释，被注释的键值对把会被读取。
            3.存储键值对的文件中，键与值默认都是字符串，不用加引号。
     */
    @Test
    public void TestProp03() throws IOException {
        //创建Properties集合对象
        Properties properties = new Properties();
        //使用Properties集合对象中的方法load读取保存键值对的文件
        //字符输入流可以读取中文
        properties.load(new FileReader("prop.txt"));
        //字节输入流不能读取中文
        properties.load(new FileInputStream("prop.txt"));
        //遍历properties集合
        Set<String> set = properties.stringPropertyNames();
        for (String key : set) {
            String value = properties.getProperty(key);
            System.out.println(key + "=" + value);
        }
    }
}