package learning;

import java.util.Scanner;

/**
 * Created by yuanyuanyang1 on 8/18/2017.
 * 题目：有n个整数，使其前面各数顺序向后移m个位置，最后m个数变成最前面的m个数.
 */
public class ChangePosition {
    //方法一
    static void test(){
        int[] a = {1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9};
        System.out.print("原数组是：");
        for(int i = 0 ; i < a.length ; i ++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
        int[] b = new int[a.length];
        int n = 6;
        for(int i = 0 ; i < n ; i ++){
            b[i] = a[a.length - n + i];
        }
        for(int i = 0 ; i < a.length - n ; i ++){
            b[i + n] = a[i];
        }
        System.out.print("后移" + n + "位后数组是：");
        for(int i = 0 ; i < b.length ; i ++){
            System.out.print(b[i] + " ");
        }
    }

    //方法二
    static void test2(int n){
        Scanner sc = new Scanner(System.in);
        int[] a = new int[n];
        System.out.print("输入" + n + "个数：");
        for(int i = 0 ; i < n ; i ++){
            a[i] = sc.nextInt();
        }
        System.out.print("输入向后移的位数：");
        int m = sc.nextInt();
        int[] b = new int[m];
        for(int i = 0 ; i < m ; i ++){
            b[i] = a[n - m + i];//备份原数组后m个数
        }
        for(int i = n - 1 ; i >= m ; i --){
            a[i] = a[i - m];//前n-m个数依次后移
        }
        for(int i = 0 ; i < m ; i ++){
            a[i] = b[i];//后m个数移到前m个位置上
        }
        System.out.print("后移" + n + "位后数组是：");
        for(int i = 0 ; i < n ; i ++){
            System.out.print(a[i] + " ");
        }
    }

    public static void main(String[] args){
        //test();
        test2(8);
    }
}
