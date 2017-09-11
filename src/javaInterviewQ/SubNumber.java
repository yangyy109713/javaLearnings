package javaInterviewQ;

import java.util.Scanner;

/**
 * Created by yuanyuanyang1 on 8/17/2017.
 * 题目：取一个整数a从右端开始的4～7位。
 */
public class SubNumber {
    static char[] getChar(){
        System.out.print("输入一个大于7位的数：");
        Scanner sc = new Scanner(System.in);
        long num = sc.nextLong();
        //判断长度
        char[] c = Long.toString(num).toCharArray();
        if(c.length < 7){
            System.out.println("输入错误，请重新输入!");
            getChar();
        }
        return c;
    }

    public static void main(String[] args){
        char[] c = getChar();
        System.out.print("截取从右端开始4-7位：");
        for(int i = c.length - 4 ; i >= c.length - 7 ; i --){
            System.out.print(c[i]);
        }
    }
}
