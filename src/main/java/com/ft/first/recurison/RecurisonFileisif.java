package com.ft.first.recurison;

import org.junit.Test;

import java.io.File;

public class RecurisonFileisif {
    /*
        递归打印多级目录
        遍历：D:\qwer文件夹及子文件夹
            D:\qwer\a
            D:\qwer\a\aaa.jpg
            D:\qwer\a\aaa.txt
            D:\qwer\a\abc.JAVA
            D:\qwer\b
            D:\qwer\b\bbb.java
            D:\qwer\b\bbb.txt
            D:\qwer\abc.java
            D:\qwer\abc.txt
    */
    @Test
    public void look() {
        File file = new File("D:\\qwer");
        getAllFile(file);
    }

    /*
        定义一个方法，参数传递File类型的目录
        方法中对目录进行遍历
    */

    public void getAllFile(File dir) {
        //打印被遍历的目录名称
        //System.out.println(dir);
        File[] files = dir.listFiles();
        for (File file : files) {
            //对遍历的file进行判断是否是文件夹
            if (file.isDirectory()) {
                //file是文件夹，则继续比遍历这个文件夹
                //我们发现getAllFile方法就是传递一个文件夹，遍历文件夹的方法
                //所以直接调用getAllFile方法即可、自己调用自己(递归)
                getAllFile(file);
            } else {
                //如果就是一个文件，直接打印即可
                /*
                    只要.java结尾的文件
                    1.把File对象file，转为字符串对象
                */
                /*
                //获取文件名
                //String name = file.getName();
                //String name=file.getPath();
                String name=file.toString();
                //把字符串转为小写
                name=name.toLowerCase();
                //2.调用String类中的方法endsWhit判断字符串是否是已.java结尾的
                Boolean b=name.endsWith(".java");
                //3.如果是以.Java结尾的直接输出即可
                if(b){
                    System.out.println(file);
                }
                */
                if(file.getName().toLowerCase().endsWith(".java")){
                    System.out.println(file);
                }
            }
        }
    }
}
