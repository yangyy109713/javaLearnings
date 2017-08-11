package learning;

import java.util.Scanner;
/**
 * Created by yuanyuanyang1 on 8/11/2017.
 * 题目：给一个不多于5位的正整数，要求：一、求它是几位数，二、逆序打印出各位数字。
 */
public class Test24 {
    public static void main(String[] args){
        int n;
        Scanner sc = new Scanner(System.in);
        //循环测试
        for(int i = 0 ; i < 3 ; i++){
            System.out.print("请输入一个不多于5位的正整数：");
            n = sc.nextInt();
            char[] c = Integer.toString(n).toCharArray();
            if(c.length <= 5 && c.length != 0){
                System.out.println(n + "是：" + c.length + "位数");
                System.out.print(n + "的逆序是：");
                for(int j = c.length - 1 ; j >= 0 ; j--){
                    System.out.print(c[j]);
                }
                System.out.println();
            }else {
                System.out.println("输入数字不合法！");
                continue;
            }
        }
    }
}
