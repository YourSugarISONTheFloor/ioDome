package com.ft.first.objectStream;

import java.io.Serializable;

/**
 * 序列化和反序列化的时候，会抛出NotSerializableException没有序列化异常。
 * 类通过实现 java.io.Serializable 接口以启用器序列化功能，未实现此接口的类将无法使其任何状态序列化和反序列化。
 * Serializable也叫标记型接口
 * 要序列化和反序列化的类必须实现Serializable接口，就会给他添加一个标记
 * 当我们进行序列化和反序列化的时候，就会检测这个类上是否有Serializable标记，有的话就可以序列化和反序列化。没有就会报错会抛出NotSerializableException异常。
 * <p>
 * static关键字：静态关键字。静态优先于非静态加载到内存中。被static修饰的成员变量不能被序列化的，序列化的都是对象。
 * private static int age;
 * 序列化写入：
 * objectOutputStream.writeObject(new Student("橙子",20));
 * 反序列化读取：
 * Object obj=objectInputStream.readObject();
 * 结果为：Student{name='橙子', age=0}
 * <p>
 * transient关键字：瞬态关键字。
 * 被transient修饰的成员变量，不能被序列化
 * private transient int age;
 * 序列化写入：
 * objectOutputStream.writeObject(new Student("橙子",20));
 * 反序列化读取：
 * Object obj=objectInputStream.readObject();
 * 结果为：Student{name='橙子', age=0}
 */
public class Student implements Serializable {
    //定义这个类的serialVersionUID=42L;   不会出现序列号冲突
    static final long serialVersionUID=42L;    //常量不能改变
    private String name;
    //private transient int age;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}
