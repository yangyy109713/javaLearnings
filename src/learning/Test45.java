package learning;

import java.util.Scanner;

/**
 * Created by yuanyuanyang1 on 8/23/2017.
 * 题目：判断一个整数能被几个9整除
 */
public class Test45 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("输入一个整数：");
        int  a = sc.nextInt();
        int count = 0;
        while(a % 9 == 0){
            a = a / 9;
            count ++;
        }
        System.out.print("能被" + count + "个9整除");
        System.out.println();

        //第46题：两个字符串连接（用+或者StringBuffer实现）
        String s1 = "I am a ";
        String s2 = "tester";
        StringBuffer sb = new StringBuffer(s1);
        //System.out.println("两字符串连接:" + (s1 + s2));
        System.out.println("两字符串连接:" + sb.append(s2));
    }
}
