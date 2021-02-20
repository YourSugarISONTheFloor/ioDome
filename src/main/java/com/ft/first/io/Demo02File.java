package com.ft.first.io;

import java.io.File;

/*
 *路径：
 *   绝对路径：是一个完整的路径
 *       以盘符(C:,D:)开始的路径
 *           C:\\a.txt
 *           D:\\demo\\b.txt
 *    相对路径：是一个简化的路径
 *       相对指的是相对于当前项目的跟目录(C:\Program Files\Application Verifier)
 *       如果当前项目的跟目录，路径可以简化书写
 *       C:\Program Files\Application Verifier\\123.txt-->简化为：123.txt(可以省略项目的根目录)
 *    注意：
 *       1.路径是不区分大小写
 *       2.路径中的文件名称分隔符Windows使用反斜杠，反斜杠是转义字符，两个反斜杠代表一个普通的反斜杠
 */
public class Demo02File {
    public static void main(String[] args) {
            /*
                File类的构造方法
            */
        //show01();
        //show02("D", "a.txt");
        show03();
    }

    /*
     * File(String pathname)通过将给定路径名 字符串转换为抽象路径名来创建一个新 File 类
     * 参数：
     *   String pathname:字符串的路径名称
     *   路径可以是以文件结尾，也可以是以文件夹结尾
     *   路径可以是相对路径也可以是绝对路劲
     *   路劲是可以存在的也可以是不存在的
     *   创建File对象，只是把字符串路劲封装为File对象，不考虑路劲的真假情况
     * */
    private static void show01() {
        File file1 = new File("D:\\Work\\Word\\a.txt");
        System.out.println(file1);//重写了Object类的toString方法 D:\Work\Word\a.txt
        File file2 = new File("D:\\Work\\Word");
        System.out.println(file2);//文件夹 D:\Work\Word
        File file3 = new File("b.txt");
        System.out.println(file3);//相对路径 b.txt
    }

    /*
        File(String parent,String child) 根据parent路径名 字符串和child路径名 字符串创建一个新的File实例。
        参数：把路径分成了两部份
            String parent：父路径
            String child：子路径
        好处：父路径和子路径，可以单独书写，使用起来非常灵活，父路径和子路径都可以变化。
     */
    private static void show02(String parent, String child) {
        File file = new File(parent, child);
        System.out.println(file);
    }

    /*
        File(File parent,String child) 根据parent路径名 字符串和child路径名 字符串创建一个新的File实例。
        参数：把路径分成了两部份
            File parent：父路径
            String child：子路径
        好处：
            父路径和子路径，可以单独书写，使用起来非常灵活，父路径和子路径都可以变化。
            父路径是File类型，可以使用File的方法对路径进行一些操作，再使用路径创建对象。
     */
    private static void show03() {
        File fi=new File("D:","aa");
        File file = new File(fi, "aa.txt");
        System.out.println(file);
    }
}
