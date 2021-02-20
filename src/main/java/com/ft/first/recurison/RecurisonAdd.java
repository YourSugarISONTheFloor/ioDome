package com.ft.first.recurison;

import org.junit.Test;

public class RecurisonAdd {
    /*
        使用递归计算1~n之间的和
    */
    @Test
    public void add() {
        int s = sum(10);
        System.out.println(s);
    }

    /*
        定义一个方法，使用递归计算1~n之间的和。
        1+2+3+……+n
        n+(n-1)+(n-2)+……+1
        已知：
            最大值：n
            最小值：1
        使用递归必须明确：
            1.递归的结束条件：
                获取到1的时候结束
            2.递归的目的：
                获取下一个被加的数字(n-1)
    */
    public static int sum(int n) {
        //获取到1的时候结束
        if (n == 1) {
            return 1;
        }
        //获取下一个被加的数字
        return n + sum(n - 1);
    }

    /*
        阶乘：所有小于及等于该数的正整数的积
        n的阶乘：n!=n*(n-1)*(n-2)*……*3*2*1
        推理得出：
            n!=n(n-1)!
    */
    @Test
    public void multiplication(){
        int end=jc(10);
        System.out.println(end);
    }
    /*
        定义一个方法，使用递归计算n的阶乘。
        n的阶乘：n!=n*(n-1)*(n-2)*……*3*2*1
        使用递归必须明确：
            1.递归的结束条件：
                获取到1的时候结束
            2.递归的目的：
                获取下一个被加的数字(n-1)
    */
    public static int jc(int n){
        //获取到1的时候结束
        if(n==1){
            return 1;
        }
        //获取下一个被乘的数字
        return n*jc(n-1);
    }
}
