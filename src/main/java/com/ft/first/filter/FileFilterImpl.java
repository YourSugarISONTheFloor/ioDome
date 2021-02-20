package com.ft.first.filter;

import java.io.File;
import java.io.FileFilter;

/*
    创建过滤器FileFilter的实现类，重写过滤器中的accept方法，定义过滤的规则
*/
public class FileFilterImpl implements FileFilter {
    /*
    必须明确两件事：
        1.过滤器中的accept方法是谁调用的
        2.accept方法的参数pathname是什么？
    */
    @Override
    public boolean accept(File pathname) {
        //过滤器的规则
        //在accept方法中，判断File对象是否是以.java结尾的
        //是的话返回true，保存到File数组中
        //是的话返回false，不保存到File数组中


        //accept返回值是布尔值
        //true：就会把传递过来的FIle对象保存到File数组中
        //false：就不会把传递过来的FIle对象保存到File数组中

        //如果是文件夹也返回true，继续遍历文件夹
        if(pathname.isDirectory()){
            return true;
        }
        return pathname.getName().toLowerCase().endsWith(".java");
    }
}
