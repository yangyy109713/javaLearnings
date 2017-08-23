package learning;

import java.util.Scanner;

/**
 * Created by yuanyuanyang1 on 8/23/2017.
 * 题目：读取7个数（1—50）的整数值，每读取一个值，程序打印出该值个数的＊。
 */
public class Test47 {
    //方法一
    static void test1(){
        //取7个数，范围是1-50
        Scanner sc = new Scanner(System.in);
        for(int i = 0 ; i < 7 ; i ++){
            int a;
            do {
                System.out.print("输入在1-50范围内的整数：");
                a = sc.nextInt();
            }while(a < 1 || a > 50);
            System.out.println();
            for(int j = 0 ; j < a ; j ++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void test2(){
        Scanner sc = new Scanner(System.in);
        int n = 0;
        while(n < 7){
            int a;
            do {
                System.out.print("输入在1-50范围内的整数：");
                a = sc.nextInt();
            }while(a < 1 || a > 50);
            for(int j = 0 ; j < a ; j ++){
                System.out.print("*");
            }
            System.out.println();
            n ++;
        }
    }

    public static void main(String[] args){
        //test1();
        test2();
    }
}
