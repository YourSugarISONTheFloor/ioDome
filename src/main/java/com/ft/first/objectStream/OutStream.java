package com.ft.first.objectStream;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * java.io.PrintStream:打印流
 * PrintStream 为其他输出流添加了功能，使他们能够方便地打印各种数据值表示形式。
 * PrintStream特点：
 *      1.只负责数据的输出，不负责数据的读取
 *      2.与其他输出流不同，PrintStream永远不会抛出IOException,但会抛出文件找不到的异常
 *      3.有特有的方法，print、println
 *          print：(输出任意的数据格式)
 *          println：(输出任意的数据格式带换行)
 * 构造方法：
 *      PrintStream(File file)：输出的目的地是文件
 *      PrintStream(OutputStream out)：输出的目的地是一个输出流
 *      PrintStream(String FileName)：输出的目的地是一个文件路径
 * PrintStream extends OutputStream
 * 继承自父类的成员方法：
 *      void close()：关闭此输出流并释放与此流有关的所有系统资源。
 *      void flush()：刷新此输出流并强制写出所有缓冲的输出字节。
 *      void write(byte[] b)：将 b.length 个字节从指定的 byte 数组写入此输出流。
 *      void write(byte[] b, int off, int len)：将指定 byte 数组中从偏移量 off 开始的 len 个字节写入此输出流。
 *      abstract  void write(int b)：将指定的字节写入此输出流。
 * 注意：
 *      如果使用继承自父类的write方法写数据，那么查询数据的时候会查询编码表。例：97->a
 *      如果使用它自己的方法print、println写数据，写的数据会原样输出.例：97->97
 */
public class OutStream {
    @Test
    public void testOut() throws FileNotFoundException {
        //创建打印流PrintStream对象，构造方法中绑定要输出的目的地
        PrintStream printStream=new PrintStream("print.txt");
        //如果使用继承自父类的write方法写数据，那么查询数据的时候会查询编码表。例：97->a
        printStream.write(97);
        //如果使用它自己的方法print、println写数据，写的数据会原样输出.例：97->97
        printStream.println(97);
        //释放资源
        printStream.close();
    }

    /**
     * 可以改变输出语句的目的地(打印的流向)
     * 输出语句，默认在控制台输出
     * 使用：System.setOut方法改变输出语句的目的地改为参数中传递的打印流的目的地。
     *      static void setOut(PrintStream out)：重新分配"标准"输出流。
     */
    @Test
    public  void testOut01() throws FileNotFoundException {
        System.out.println("我是在控制台打印输出");
        PrintStream printStream=new PrintStream("打印流.txt");
        //把输出语句的目的地改变为打印流的目的地
        System.setOut(printStream);
        System.out.println("我在打印流的目的地中输出");
        printStream.close();
    }
}
