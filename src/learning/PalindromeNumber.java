package learning;

import java.util.Scanner;

/**
 * Created by yuanyuanyang1 on 8/11/2017.
 * 题目：一个5位数，判断它是不是回文数。即12321是回文数，个位与万位相同，十位与千位相同。
 */
public class PalindromeNumber {
    static Scanner sc = new Scanner(System.in);
    static int a;
    static long b;
    public static void palindrome1(){
        //循环测试
        for(int i = 0 ; i < 3 ; i++){
            System.out.print("输入一个5位数：");
            a = sc.nextInt();
            char[] c = Integer.toString(a).toCharArray();
            if(c.length == 5){
                if(c[0] == c[c.length - 1] && c[1] == c[c.length - 2]){
                    System.out.println(a + "是回文数！");
                }else{
                    System.out.println(a + "不是回文数！");
                }
            }else {
                System.out.println("输入错误，回文数是一个5位数！");
                continue;
            }
        }
    }

    public static void palindrome2(){
        //如果输入的数字不是5位数，则提示再次输入，直到输入一个5位数
        do {
            System.out.print("输入一个5位数：");
            a = sc.nextInt();
        }while(a < 10000 || a > 99999);
        String s = String.valueOf(a);
        char[] c = s.toCharArray();
        if(c[0] == c[4] && c[1] == c[3]){
            System.out.println(a + "是回文数");
        }else {
            System.out.println(a + "不是回文数");
        }
    }

    //不限制位数
    public static void palindrome3(){

        System.out.print("输入一个整数：");
        b = sc.nextLong();
        char[] c = Long.toString(a).toCharArray();
        boolean is = true;//判断是否是回文数
        for(int i = 0 ; i < c.length / 2 ; i ++){
            if(c[i] != c[c.length - i - 1]){
                is = false;
            }
        }
        if(is){
            System.out.println(b + "是回文数");
        }else {
            System.out.println(b + "不是回文数");
        }
    }

    public static void main(String[] args){
        //palindrome1();
        //palindrome2();
        palindrome3();
    }
}
