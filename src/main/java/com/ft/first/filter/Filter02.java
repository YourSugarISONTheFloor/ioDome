package com.ft.first.filter;

import org.junit.Test;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class Filter02 {

    @Test
    public void look() {
        File file = new File("D:\\qwer");
        getAllFile(file);
    }

    public void getAllFile(File dir) {
        //打印被遍历的目录名称
        //System.out.println(dir);

//        File[] files = dir.listFiles(new FileFilter() {
//            @Override
//            public boolean accept(File pathname) {
//                //过滤规则
//                return pathname.isDirectory() || pathname.getName().toLowerCase().endsWith(".java");
//            }
//        });
//        File[] files = dir.listFiles(new FilenameFilter() {
//            @Override
//            public boolean accept(File dir, String name) {
//                //过滤规则
//                return new File(dir, name).isDirectory() || name.toLowerCase().endsWith(".java");
//            }
//        });

        //使用lambda表达式来优化匿名内部类(接口中只有一个抽象方法)
        File[] files=dir.listFiles((d,name)->new File(d, name).isDirectory() || name.toLowerCase().endsWith(".java"));
//        File[] files=dir.listFiles((File d,String name)->{
//            //过滤规则
//            return new File(d, name).isDirectory() || name.toLowerCase().endsWith(".java");
//        });
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
