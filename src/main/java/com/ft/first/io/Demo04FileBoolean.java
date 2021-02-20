package com.ft.first.io;

import org.junit.Test;

import java.io.File;

public class Demo04FileBoolean {
    /*
        public boolean exists()：此File表示文件或目录是否实际存在。
        public boolean isDirectory()：此File表示是否为目录
        public boolean isFile()：此File表示的是否为文件
    */

    /*
        public boolean exists()：此File表示文件或目录是否实际存在。
        用于判断构造方法中的路径是否存在
        存在返回：true
        不存在返回：false
    */
    @Test
    public  void show01() {
        //绝对路径
        File file1 = new File("D:\\aaa.txt");
        //判断文件是否存在
        System.out.println(file1.exists());//true
        //相对路径
        //D:\workPaper\firstdemo\b.txt
        File file2 = new File("b.txt");
        //获取文件的路径
        System.out.println(file2.getAbsolutePath());
        //判断文件是否存在
        System.out.println(file2.exists());//false
    }

    /*
        public boolean isDirectory()：此File表示是否为目录
            用于判断构造方法中给定的路径是否为以文件夹结尾
            是的话返回：true
            不是的话返回：false
        注意：
            电脑硬盘中只有文件/文件夹，两个方法是互斥的
            这两个方法使用前提，路径必须是存在的，否则都返回false
    */
    @Test
    public void show02() {
        //绝对路径
        File file1 = new File("D:\\aaa.txt");
        //判断文件是否存在
        System.out.println(file1.exists());//true
        //判断构造方法中给定的路径是否为以文件夹结尾
        System.out.println(file1.isDirectory());//false
        //判断构造方法中给定的路径是否为以文件结尾
        System.out.println(file1.isFile());//true
    }
}
