package com.ft.first.io;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class Demo05FileCreateDelete {
    /*
        public boolean createNewFile():当且仅当该文件不存在时，创建一个新的文件
        public boolean delete():删除由此File表示的文件或目录
        public boolean mkdir():创建由此File表示的目录
        public boolean mkdirs():创建由此File表示的目录，包括任何必需但不存在的父目录
    */

    /*
        public boolean createNewFile():当且仅当该文件不存在时，创建一个新的文件
        创建文件的路径和名称在构造方法中给出(构造方法的参数)
        返回值：布尔值
            true：文件不存在，创建文件，返回true
            false：文件存在，不创建文件，返回false
         注意：
            1.此方法只能用于创建文件，不能用于创建文件夹
            2.创建文件的路径必须存在，否则会抛出异常
         public boolean createNewFile() IOException
         createNewFile声明抛出了IOException，我们调用这个方法，就必须处理异常，要么throws，要么try、catch
    */
    @Test
    public void show01() {
        //文件创建
        File file1=new File("aaa.txt");
        File file2=new File("aaa\\aaa.txt");
        System.out.println("是否存在相对目录下的aaa.txt："+file1.exists());//false
        try {
            System.out.println("是否创建相对目录下aaa.txt："+file1.createNewFile());//true
            System.out.println("是否创建相对目录下aaa\\aaa.txt："+file2.createNewFile());//路径不存在会抛出异常，创建失败
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("路径不存在，创建失败");
        }
        System.out.println("是否存在相对目录下aaa.txt："+file1.exists());//true
        System.out.println("是否存在相对目录下aaa\\aaa.txt："+file2.exists());//false
    }

/*
    public boolean mkdir():创建由此File表示的目录
    public boolean mkdirs():创建由此File表示的目录，包括任何必需但不存在的父目录
    创建文件夹的路径和名称在构造方法中给出(构造方法的参数)
    返回：布尔值
        true：文件夹不存在，创建文件夹，返回true
        false：文件夹存在，不创建文件夹，返回false;构造方法中给出的路径不存在返回false
    注意：
        1.此方法只能用来创建文件夹，不能用来创建文件
        2.创建文件夹的路径必须存在，否则会抛出异常
*/
    @Test
    public void show02(){
        //目录创建
        File file1=new File("newDir");
        File file2=new File("111\\222\\333");//文件夹上级目录不存在
        System.out.println("是否存在相对目录下的newDir文件夹："+file1.exists());//false
        System.out.println("是否创建相对目录下的newDir文件夹："+file1.mkdir());//true
        System.out.println("是否存在相对目录下的newDir文件夹："+file1.exists());//true
        System.out.println("是否存在相对目录下的111\\222\\333文件夹："+file2.exists());//false
        System.out.println("是否创建相对目录下的111\\222\\333文件夹："+file2.mkdir());//false
        System.out.println("是否存在相对目录下的111\\222\\333文件夹："+file2.exists());//false
    }
    @Test
    public void show03(){
        //创建多级目录
        File file=new File("111\\222\\333");//文件夹上级目录不存在
        System.out.println("是否存在相对目录下的111\\222\\333文件夹："+file.exists());//false
        System.out.println("是否创建相对目录下的111\\222\\333文件夹："+file.mkdirs());//false
        System.out.println("是否存在相对目录下的111\\222\\333文件夹："+file.exists());//false
    }
    /*
        public boolean delete():删除由此File表示的文件或目录
        此方法，可以删除构造方法路径中给出的文件/文件夹
        返回值：布尔值
            true：文件/文件夹删除成功，返回true
            false：文件夹中有内容(文件有内容直接删除)，不会删除放回false;构造方法中给出的路径不存在返回false
        注意：
            delete方法是直接在硬盘中删除文件/文件夹，不走回收站，删除要谨慎。
            多级目录不能直接全部删除
    */
    @Test
    public void show04(){
        File file1=new File("aaa.txt");
        File file2=new File("newDir");
        File file3=new File("111\\222\\333");
        System.out.println("是否删除相对路径下的aaa.txt："+file1.delete());//true
        System.out.println("是否删除相对路径下的newDir："+file2.delete());//true
        System.out.println("是否删除相对路径下的111\\222\\333："+file3.delete());//false
    }
}
