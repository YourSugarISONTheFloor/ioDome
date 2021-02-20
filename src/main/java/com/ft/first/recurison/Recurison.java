package com.ft.first.recurison;

import org.junit.Test;

public class Recurison {

    /*
        递归：方法自己调用自己
            递归的分类：
                递归分为两种，直接递归和间接递归
                直接递归称为方法自身调用自己。
                间接递归可以A方法调用B方法，B方法调用A方法
            注意事项：
                递归一定要有条件限制，保证能够停下来，否则会发生栈内存溢出
                在递归中虽然有限定条件，但是递归的次数不能太多。否则也会发生栈内存溢出。
                在递归方法中禁用构造方法。
            递归使用前提：
                当调用方法的时候，方法的主体不变，每次调用的方法次数不同，可以使用递归。
    */

    /*
        递归一定要有条件限制，保证能够停下来，否则会发生栈内存溢出
        java.lang.StackOverflowError

        a方法一直调用a方法，就会导致栈内有无数个a方法，方法太多了，超出了栈内存的大小，就会导致内存的溢出错误
        注意：
            当一个方法调用其他方法的时候，被调用的方法没有执行完毕之前，当前方法会一直等待调用的方法执行完毕，才会继续执行。
    */


    @Test
    public void a() {
        b(1);
    }



    public void b(int i) {
        System.out.println(i);
        //java.lang.StackOverflowError，方法次数也不能太多
        if (i == 10000) {
            //结束方法
            return;
        }
        b(++i);
    }

    /*
        构造方法，禁止递归
            编译报错：构造方法是创建对象使用的，一直递归会导致内存中有无数的个对象，直接编译报错
     */
//    public Recurison(){
//        Recurison();
//    }
}
