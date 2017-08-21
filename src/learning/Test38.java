package learning;

import java.util.Scanner;

/**
 * Created by yuanyuanyang1 on 8/18/2017.
 * 题目：写一个函数，求一个字符串的长度，在main函数中输入字符串，并输出其长度。
 */
public class Test38 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("输入一行字符串：");
        String line = sc.nextLine();
        System.out.println();
        System.out.print("字符串长度是："+line.length());
    }
}
