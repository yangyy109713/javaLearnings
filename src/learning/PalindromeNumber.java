package learning;

import java.util.Scanner;

/**
 * Created by yuanyuanyang1 on 8/11/2017.
 * 题目：一个5位数，判断它是不是回文数。即12321是回文数，个位与万位相同，十位与千位相同。
 */
public class PalindromeNumber {
    public static void main(String[] args){
        int n;
        Scanner sc = new Scanner(System.in);
        //循环测试
        for(int i = 0 ; i < 3 ; i++){
            System.out.print("输入一个5位数：");
            n = sc.nextInt();
            char[] c = Integer.toString(n).toCharArray();
            if(c.length == 5){
                if(c[0] == c[c.length - 1] && c[1] == c[c.length - 2]){
                    System.out.println(n + "是回文数！");
                }else{
                    System.out.println(n + "不是回文数！");
                }
            }else {
                System.out.println("输入错误，回文数是一个5位数！");
                continue;
            }
        }
    }
}
