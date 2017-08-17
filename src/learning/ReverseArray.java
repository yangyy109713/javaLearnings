package learning;

import java.util.Scanner;

/**
 * Created by yuanyuanyang1 on 8/17/2017.
 * 题目：将一个数组逆序输出。
 */
public class ReverseArray {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] a = new int[100];
        System.out.println("输入多个整数（-1表示结束）：");
        int i = 0;
        do{
            a[i] = sc.nextInt();
            i ++;
        }while(a[i - 1] != -1);//最近一次输入的数不是-1
        System.out.println("输入的数组：");
        //数组中元素的实际长度等于i-1
        for(int j = 0 ; j < i - 1 ; j ++){
            System.out.print(a[j] + " ");
        }
        System.out.println("逆序输出数组：");
        //数组中元素的实际长度等于i-1，从倒数第一个数开始输出
        for(int j = i - 2 ; j >= 0 ; j = j - 1){
            System.out.print(a[j] + " ");
        }
    }
}
