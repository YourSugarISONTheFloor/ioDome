package com.ft.first.recurison;

import org.junit.Test;

import java.io.File;

public class RecurisonFile {
    /*
        递归打印多级目录
        遍历：D:\qwer文件夹及子文件夹
            D:\qwer\a
            D:\qwer\a\aaa.jpg
            D:\qwer\a\aaa.txt
            D:\qwer\b
            D:\qwer\b\bbb.java
            D:\qwer\b\bbb.txt
            D:\qwer\abc.java
            D:\qwer\abc.txt
    */
    @Test
    public void look() {
        File file=new File("D:\\qwer");
        getAllFile(file);
    }

    /*
        定义一个方法，参数传递File类型的目录
        方法中对目录进行遍历
    */

    public void getAllFile(File dir) {
        //打印被遍历的目录名称
        System.out.println(dir);
        File[] files = dir.listFiles();
        for (File file : files) {
            //对遍历的file进行判断是否是文件夹
            if(file.isDirectory()){
                //file是文件夹，则继续比遍历这个文件夹
                //我们发现getAllFile方法就是传递一个文件夹，遍历文件夹的方法
                //所以直接调用getAllFile方法即可、自己调用自己(递归)
                getAllFile(file);
            }else{
                //如果就是一个文件，直接打印即可
                System.out.println(file);
            }
        }
    }
}
