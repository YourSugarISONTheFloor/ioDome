package com.ft.first.io;

import org.junit.Test;

import java.io.File;

public class Demo06FileList {
    /*
        File类遍历(文件夹)目录功能
            public String[] list():返回一个String数组，表示该File目录中所有子文件或目录
            public File[] listFiles():返回一个File数组，表示该File目录中的所有子文件或目录
        注意：
            list方法和listFiles方法遍历的是构造方法中给出的目录
            如果构造方法中给出的目录不存在则会抛出空指针异常
            如果构造方法中给出的路径它不是一个目录，也会抛出空指针异常java.lang.NullPointerException
    */


    /*
        public String[] list():返回一个String数组，表示该File目录中所有子文件或目录.
        遍历构造方法中给出的目录，会获取目录中所有文件/文件夹的名称，把获取到的多个名称存储到一个String数组中
        能够获取到隐藏的文件夹
    */
    @Test
    public void show01(){
        File file=new File("D:\\workPaper\\firstdemo");
        String[] array=file.list();
        //遍历
        for(String str:array){
            System.out.println(str);
        }
    }

    /*
        public File[] listFiles():返回一个File数组，表示该File目录中的所有子文件或目录
        遍历构造方法给出的目录，它会获取目录中的所有文件/文件夹，把文件/文件夹封装为File对象，多个File对象存储到数组中

    */
    @Test
    public void show02(){
        File file=new File("D:\\workPaper\\firstdemo");
        File[] array=file.listFiles();
        //遍历
        for(File str:array){
            System.out.println(str);
        }
    }
}
