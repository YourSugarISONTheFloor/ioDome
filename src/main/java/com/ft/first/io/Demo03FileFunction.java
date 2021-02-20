package com.ft.first.io;

import java.io.File;

public class Demo03FileFunction {
    /*
        public String getAbsolutePath();返回此File的绝对路径名字字符串
        public String getPath();将此File转换为路径名 字符串
        public long length():返回由此File表示的文件的长度。
    */
    public static void main(String[] args) {
        //show01();
        //show02();
        //show03();
        show04();
    }

    /*
        public String getAbsolutePath();返回此File的绝对路径名字字符串
        获取的构造方法中传递的路径
        无论路径是绝对的还是相对的，getAbsolutePath()方法返回的都是绝对路径
    */
    private static void show01() {
        File file = new File("C:\\Users\\小熊打倒的饭团\\IdeaProjects\\first\\a.txt");
        String absolutePath = file.getAbsolutePath();
        System.out.println(absolutePath);
        File fi = new File("b.txt");
        String absolutePath2 = fi.getAbsolutePath();
        System.out.println(absolutePath2);
    }

    private static void show02() {
        File file1 = new File("C:\\Users\\小熊打倒的饭团\\IdeaProjects\\first\\a.txt");
        File file2 = new File("a.txt");
        String fi1 = file1.getAbsolutePath();//输出该文件的绝对路径
        String fi2 = file2.getAbsolutePath();
        /*
            public String getPath();将此File转换为路径名 字符串
            获取的构造方法中传递的路径
            toString方法调用的就是getPath方法
            源码：
                public String toString() {
                   return getPath();
                }
        */
        String fil1 = file1.getPath();//C:\Users\小熊打倒的饭团\IdeaProjects\first\a.txt
        String fil2 = file2.getPath();//a.txt

        System.out.println(fi1);
        System.out.println(fi2);

        System.out.println(fil1);
        System.out.println(fil2);

        System.out.println(file1.toString());
        System.out.println(file2.toString());
    }

    private static void show03() {
        File file1 = new File("C:\\Users\\小熊打倒的饭团\\IdeaProjects\\first\\a.txt");//是一个文件
        String name1 = file1.getName();
        System.out.println(name1);//a.txt
        File file2=new File("C:\\Users\\小熊打倒的饭团\\IdeaProjects\\first");//是一个文件夹
        String name2=file2.getName();
        System.out.println(name2);//first
    }
    /*
        public long length():返回由此File表示的文件的长度。
        获取的是构造方法指定的文件大小，以字节为单位
        注意：
            文件如果没有大小概念的，不能获取文件夹的大小
            如果构造方法中给出的路径它不存在，那么length返回0
    */
    private static void show04(){
        //返回文件大小，以字节为单位：313626
        File file1=new File("D:\\aaa.jpg");
        long length1=file1.length();
        System.out.println(length1);
        //文件不存在返回0
        File file2=new File("D:\\aa.jpg");
        long length2=file2.length();
        System.out.println(length2);
        //文件夹也返回0：8192
        File file3=new File("D:\\Software");
        long length3=file3.length();
        System.out.println(length3);
    }
}
