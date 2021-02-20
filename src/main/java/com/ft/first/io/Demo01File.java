package com.ft.first.io;

import java.io.File;


public class Demo01File {
    public static void main(String[] args) {
        /*
        static  String pathSeparator 与系统有关的路径分隔符，为了方便，它表示为一个字符串
        static  char pathSeparatorChar

        static  String separator    与系统有关的默认名称分隔符，为了方便，它表示为一个字符串。
        static  char    separatorChar   与系统有关的默认名称分隔符。

        操作系统：路径不能写死了
        C:\develop\a\a.txt  windows
        C:/develop/a/a.txt  linux
        在Windows中和linux中都可以用
        "C:"+File.pathSeparator+"develop"+File.pathSeparator+"a"+File.pathSeparator+"a.txt"
         */
        String pathSeparator = File.pathSeparator;
        System.out.println(pathSeparator);//路径分隔符 Windows：分号；   linux：冒号；
        String separator = File.separator;
        System.out.println(separator);//文件名称分隔符 Windows：反斜杠\    linux：正斜杠/

    }
}
