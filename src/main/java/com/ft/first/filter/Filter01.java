package com.ft.first.filter;

import org.junit.Test;

import java.io.File;

public class Filter01 {
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
        我们使用过滤器来实现
        在File类中有两个和listFiles重载的方法，方法的参数传递的就是过滤器。

        File[] listFiles(FileFilter filter)
        返回抽象路径名数组，这些路径名表示此抽象路径名表示的目录中满足指定过滤器的文件和目录
        java.io.FileFilter接口：用于抽象路径名(File对象)的过滤器。
            作用：用来过滤文件的。
            抽象方法：用来过滤文件的方法
                boolean accept(File pathname)
                测试指定抽象路径名是否应该包含在某个路径名列表中。
                参数：File pathname：使用的就是listFiles方法遍历目录，得到的每一个文件对象

        static File[] listFiles(FilenameFilter filter)
        返回抽象路径名数组，这些路径名表示此抽象路径名表示的目录中满足指定过滤器的文件和目录。
        java.io.FileFilter接口：用于抽象路径名(File对象)的过滤器。
            作用：用于过滤文件名称。
            抽象方法：用来过滤文件的方法。
            boolean accept(File dir, String name)
            测试指定文件是否应该包含在某一文件列表中。
            参数：
                File dir:构造方法中传递的被遍历的目录。
                String name：使用listFiles方法遍历目录，获取的每一个文件/文件夹名称。

        注意：
            两个过滤器接口都没有实现类，需要我们自己写实习类，重写过滤器的方法accept，在方法中自己定义过滤的规则
    */
    @Test
    public void look() {
        File file = new File("D:\\qwer");
        getAllFile(file);
    }

    public void getAllFile(File dir) {
        //打印被遍历的目录名称
        //System.out.println(dir);
        File[] files = dir.listFiles(new FileFilterImpl());//传递过滤器对象
        //listFiles方法一共做了3件事
        //1.listFiles方法会对构造方法中传递的目录进行遍历，获取目录中的每一个文件/文件夹-->封装为File对象
        //2.listFiles方法会调用参数传递的过滤器中的方法
        //3.listFiles方法会把遍历得到的每一个File对象，传递过accept方法的参数叫pathname
        for (File file : files) {
            //对遍历的file进行判断是否是文件夹
            if (file.isDirectory()) {
                getAllFile(file);
            } else {
                System.out.println(file);
            }
        }
    }

}
