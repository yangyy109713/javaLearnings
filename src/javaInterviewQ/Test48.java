package javaInterviewQ;

import java.util.Scanner;

/**
 * Created by yuanyuanyang1 on 8/23/2017.
 * 题目：某个公司采用公用电话传递数据，数据是四位的整数，在传递过程中是加密的，加密规则如下：
 * 每位数字都加上5,然后用和除以10的余数代替该数字，再将第一位和第四位交换，第二位和第三位交换。
 */
public class Test48 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a;
        do {
            System.out.print("输入一个4位整数：");
            a = sc.nextInt();
        }while(a < 1000 || a > 9999);
        int[] arr = new int[4];
        /*//获取4个数字方法一
        int a4 = a / 1000;//千位数
        int a3 = (a - a4 * 1000) / 100;
        int a2 = (a - a4 * 1000 - a3 * 100) / 10;
        int a1 = a % 10;*/
        /*//获取4个数字方法二
        arr[0] = a / 1000;//千位数
        arr[1] = (a / 100) % 10;
        arr[2] = (a / 10) % 10;
        arr[3] = a % 10;*/
        //获取4个数字方法三
        char[] c = Integer.toString(a).toCharArray();
        for(int i = 0 ; i < c.length ; i ++){
            arr[i] = Integer.parseInt(Character.toString(c[i]));
        }
        //加密规则如下
        for(int i = 0 ; i < arr.length ; i ++){
            arr[i] += 5;
            arr[i] %= 10;
        }
        for(int i = 0 ; i < 1 ; i ++){
            int t = arr[i];
            arr[i] = arr[3 - i];
            arr[3 - i] = t;
        }

        System.out.println("加密后的数字是：");
        for(int i = 0 ; i < arr.length ; i ++){
            System.out.print(arr[i]);
        }
    }
}
